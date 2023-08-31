package com.example.selfmadeBlog.controller;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
@RequestMapping("/cookie")
public class CookiePracticeController {
    @GetMapping("/practice")
    public String checkCookie(){
        return "jpa-view/jsp/cookie/setCookie";
    }
    @GetMapping("/makeSession")
    public String makeSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("cookie", "cookieValue");
        return "jpa-view/jsp/cookie/setCookie";
    }
    @GetMapping("/deleteSession")
    public String deleteSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("cookie");
        return "jpa-view/jsp/cookie/setCookie";
    }
}
