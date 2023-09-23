package com.bab.backend.controller;

import com.bab.backend.dto.NumberDTO;
import com.bab.backend.entity.Sleep;
import com.bab.backend.service.SleepService;
import com.bab.backend.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SleepService sleepService;

    @GetMapping()
    public String connT(){
        return "index";
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

    @PostMapping("/saveSleepData")
    @ResponseBody
    public void insertSleepData(@RequestBody Integer score){
        System.out.println("received request");
        System.out.println(score);

//        System.out.println(numberDTO);
//
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
//
//        int score = numberDTO.getValue();
        sleepService.insertSleepData(score, curDate);


    }


//    @PostMapping("/setPassword")
//    @ResponseBody
//    public void setUserPassword(String username, String password){
//        userService.setPassword(username, password);
//    }

}
