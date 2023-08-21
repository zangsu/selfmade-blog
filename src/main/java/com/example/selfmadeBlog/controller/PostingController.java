package com.example.selfmadeBlog.controller;

import com.example.selfmadeBlog.dto.PostingDTO;
import com.example.selfmadeBlog.service.PostingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RequestMapping("/post")
@Controller
public class PostingController {
    @Autowired
    PostingService postingService;

    @GetMapping
    public String createView(){
        return "view/posting/writePosting";
    }


    @PostMapping
    public ModelAndView posting(HttpServletRequest request) throws SQLException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        postingService.savePosting(new PostingDTO(title, 1, content));


        ModelAndView mv = new ModelAndView("view/posting/readPosting")
                .addObject("title", title)
                .addObject("content", content);

        return mv;
    }
}
