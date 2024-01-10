package com.example.interior.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/"})
    public String homePage() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/portfolio")
    public String portfolioPage() {
        return "image/portfolio";
    }

}
