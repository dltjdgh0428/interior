package com.example.interior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("home")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/")
    public String mainPage() {
        return "home";
    }
    @GetMapping("about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("estimate")
    public String estimatePage() {
        return "estimate";
    }

    @GetMapping("portfolio")
    public String portfolioPage() {
        return "portfolio";
    }

}
