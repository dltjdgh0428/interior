package com.example.interior.web;

import com.example.interior.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/"})
    public String homePage(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("principal", principalDetails);
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        model.addAttribute("principal", principalDetails);
        return "about";
    }


}
