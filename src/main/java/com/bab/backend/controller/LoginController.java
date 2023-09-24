package com.bab.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("")
    String index(){
        return "login";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }
//    @PostMapping("/login")
//    void login
}
