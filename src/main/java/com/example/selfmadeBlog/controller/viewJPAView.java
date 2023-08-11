package com.example.selfmadeBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jpa")
public class viewJPAView {
    @GetMapping("/orderList")
    public String orderList(){
        return "jpa-view/jsp/order/orderList";
    }

    @GetMapping("/home")
    public String home(){
        return "jpa-view/view/home";
    }

    @GetMapping("/itemList")
    public String itemList(){
        return "jpa-view/jsp/items/itemList";
    }
}
