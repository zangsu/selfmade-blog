package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.exception.database.NoDataFoundedException;
import com.example.selfmadeBlog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.function.Function;

@Repository
public class UserDAO {

    @Autowired
    private DAOContext daoContext;

    public void setDaoContext(DAOContext daoContext) {
        this.daoContext = daoContext;
    }

    private final String url = DAOConfig.URL;
    private final String userName = DAOConfig.USERNAME;
    private final String password = DAOConfig.PASSWORD;

    Function<ResultSet, User> userMapper = rs ->{
        User user = null;
        try {
            user = new User();
            user.setId(rs.getString("id"));
            user.setPassword(rs.getString("password"));
            user.setIdx(rs.getInt("idx"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    };


    public void save(User user) throws SQLException {
        String sql = "insert into users (id, password) VALUES (?, ?)";
        int generatedKey = daoContext.executeSQLAndReturn(sql, user.getId(), user.getPassword());
        user.setIdx(generatedKey);
    }

    public User findUserByIdx(int idx) throws SQLException {
        String sql = "select * from users where idx = ?";
        User user = daoContext.getObject(sql, userMapper, idx);
        return user;
    }

    public User findUserByIdAndPW(String id, String pw) throws SQLException {
        String sql = "select * from users where id = ? and password = ?";
        User user = daoContext.getObjectByParameters(sql, userMapper, id, pw);
        return user;
    }

    public void update(User user) throws SQLException {
        String sql = "update users set id = ?, password = ? where idx = ?";
        daoContext.update(sql, user.getId(), user.getPassword(), Integer.toString(user.getIdx()));
    }

    public void delete(int idx) throws SQLException {
        String sql = "delete from users where idx = ?";
        daoContext.delete(sql, Integer.toString(idx));
    }
}
