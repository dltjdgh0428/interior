package com.example.interior.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller // 1. IoC 2.파일을 리턴하는 컨트롤러
public class AuthController {
    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }
}
