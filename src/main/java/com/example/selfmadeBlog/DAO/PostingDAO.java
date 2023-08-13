package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.model.Posting;
import com.example.selfmadeBlog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.function.Function;

@Repository
public class PostingDAO {

    @Autowired
    private DAOContext daoContext;

    public void setDaoContext(DAOContext daoContext) {
        this.daoContext = daoContext;
    }

    private final String url = DAOConfig.URL;
    private final String userName = DAOConfig.USERNAME;
    private final String password = DAOConfig.PASSWORD;

    private Function<ResultSet, Posting> postingMapper = rs -> {
        Posting p = new Posting();
        try {
            p.setIdx(rs.getInt("idx"));
            p.setTitle(rs.getString("title"));
            p.setContent(rs.getString("content"));
            p.setUser_idx(rs.getInt("user_idx"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    };


    public void save(Posting posting, User user){
        posting.setUser_idx(user.getIdx());
        String sql = "insert into posting (title, user_idx, content) VALUES (?,?,?)";
        int generatedKey = daoContext.executeSQLAndReturn(sql, posting.getTitle(), Integer.toString(user.getIdx()), posting.getContent());

        posting.setIdx(generatedKey);
    }

    public Posting findByIdx(int idx){
        Posting posting = daoContext.getObject("select * from posting where idx = ?", postingMapper, idx);
        return posting;
    }

    public void update(Posting posting){
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {

            PreparedStatement ps = conn.prepareStatement("update posting set title = ?, content = ? where idx = ?");
            ps.setString(1, posting.getTitle());
            ps.setString(2, posting.getContent());
            ps.setString(3, Integer.toString(posting.getIdx()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
