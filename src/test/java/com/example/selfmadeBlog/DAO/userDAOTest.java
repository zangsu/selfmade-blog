package com.example.selfmadeBlog.DAO;

import com.example.selfmadeBlog.model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class userDAOTest {

    private UserDAO userDAO = UserDAO.getUserDAO();

    User user = new User("userId", "userPassword");

    @Test
    public void saveTest() throws SQLException, ClassNotFoundException {
        userDAO.save(user);
    }

}