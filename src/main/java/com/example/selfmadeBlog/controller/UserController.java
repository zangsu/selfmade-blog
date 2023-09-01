package com.example.selfmadeBlog.controller;

import com.example.selfmadeBlog.dto.UserReceivingDTO;
import com.example.selfmadeBlog.service.UserService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private final String viewPath ="view/user/";

    @GetMapping("/join")
    public String joinView() {
        return viewPath + "join";
    }

    @PostMapping()
    public String join(ServletRequest request) throws SQLException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        userService.join(new UserReceivingDTO(id, password));

        return viewPath + "successJoin";
    }

    @GetMapping("/login")
    public String loginView(){
        return viewPath + "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session) {

        System.out.println("success login");
        session.setAttribute("userIdx", 1);
        return viewPath + "successLogin";
    }
}