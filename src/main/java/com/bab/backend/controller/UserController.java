package com.bab.backend.controller;

import com.bab.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String connT(){
        return "connected";
    }

    @GetMapping("/getUID")
    @ResponseBody
    public int userGetUid(String username) {
        try {
            int uid = userService.userGetUid(username);
            System.out.println("uid fetched, "+ uid);
            return uid;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
