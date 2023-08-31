package com.example.selfmadeBlog.service;

import com.example.selfmadeBlog.DAO.UserDAO;
import com.example.selfmadeBlog.dto.UserReceivingDTO;
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
}
