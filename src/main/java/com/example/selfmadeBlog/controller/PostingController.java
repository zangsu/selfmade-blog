package com.example.selfmadeBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("post")
@Controller
public class PostingController {

    @GetMapping
    public void connectChecking(){

    }
}
