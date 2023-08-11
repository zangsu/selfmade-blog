package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.function.Function;

@Repository
public class UserDAO {

    private DAOContext daoContext = DAOContext.getDaoContext();
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

    //== 싱글톤 ==//
    private static UserDAO userDAO = null;
    private UserDAO(){}
    public static UserDAO getUserDAO() {
        if(userDAO == null)
            userDAO = new UserDAO();
        return userDAO;
    }
    //== 싱글톤 ==//

    public void save(User user){
        String sql = "insert into users (id, password) VALUES (?, ?)";
        int generatedKey = daoContext.executeSQLAndReturn(sql, user.getId(), user.getPassword());
        user.setIdx(generatedKey);
    }

    public User findUserByIdx(int idx){
        String sql = "select * from users where idx = ?";
        User user = daoContext.getObject(sql, userMapper, idx);
        return user;
    }

}
