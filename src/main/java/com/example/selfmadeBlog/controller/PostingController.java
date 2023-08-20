package com.example.selfmadeBlog.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;

@RequestMapping("/post")
@Controller
public class PostingController {

    @GetMapping
    public String createView(){
        return "view/posting/writePosting";
    }


    @PostMapping
    public ModelAndView posting(HttpServletRequest request){
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ModelAndView mv = new ModelAndView("view/posting/readPosting")
                .addObject("title", title)
                .addObject("content", content);

        return mv;
    }
}
