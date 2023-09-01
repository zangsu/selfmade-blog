package com.example.selfmadeBlog.service;

import com.example.selfmadeBlog.DAO.UserDAO;
import com.example.selfmadeBlog.dto.UserReceivingDTO;
import com.example.selfmadeBlog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void join(UserReceivingDTO userDTO) throws SQLException {
        userDAO.save(userDTO.getUserObj());
    }

    public String getLoginSession(String id, String pw) throws SQLException {
        User user = userDAO.findUserByIdAndPW(id, pw);

        return Integer.toString(user.getIdx());
    }
}
