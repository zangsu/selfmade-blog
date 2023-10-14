package com.example.selfmadeBlog.controller;

import com.example.selfmadeBlog.dto.UserReceivingDTO;
import com.example.selfmadeBlog.service.UserService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    private final String viewPath = "view/user/";

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
    public String loginView() {
        return viewPath + "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, ServletRequest request) {

        System.out.println("success login");
        String id = request.getParameter("id");
        String pw = request.getParameter("password");
        try {
            String loginSession = userService.getLoginSession(id, pw);
            session.setAttribute("userIdx", loginSession);
            session.setMaxInactiveInterval(30 * 60);
            return viewPath + "successLogin";
        } catch (SQLException e) {
            return viewPath + "failedLogin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return viewPath + "login";
    }

}