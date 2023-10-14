package com.example.selfmadeBlog.controller;

import ch.qos.logback.core.model.Model;
import com.example.selfmadeBlog.dto.PostingDTO;
import com.example.selfmadeBlog.service.PostingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RequestMapping("/post")
@Controller
public class PostingController {
    @Autowired
    PostingService postingService;

    final String viewPath = "view/posting/";

    @GetMapping
    public String createView(){
        return "view/posting/writePosting";
    }

    @GetMapping("/{postingIdx}")
    public String readPost(@PathVariable("postingIdx") int postingIdx, HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("title", "title" + postingIdx);
        request.setAttribute("content", "content");


        return viewPath + "readPosting";
    }


    @PostMapping
    public ModelAndView posting(HttpServletRequest request) throws SQLException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        postingService.savePosting(new PostingDTO(title, 1, content));


        ModelAndView mv = new ModelAndView(viewPath + "readPosting")
                .addObject("title", title)
                .addObject("content", content);

        return mv;
    }
}
