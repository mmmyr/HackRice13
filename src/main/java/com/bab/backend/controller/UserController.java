package com.bab.backend.controller;

import com.bab.backend.dto.NumberDTO;
import com.bab.backend.entity.Sleep;
import com.bab.backend.service.MoodService;
import com.bab.backend.service.SleepService;
import com.bab.backend.service.UserService;
import com.bab.backend.service.WellnessService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Controller
@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")

public class UserController {

    private String UserName;

    @Autowired
    UserService userService;

    @Autowired
    SleepService sleepService;

    @Autowired
    MoodService moodService;

    @Autowired
    WellnessService wellnessService;

    @GetMapping("")
    public String Login(){
        return "login";
    }

    @GetMapping("authorize")
    String authorize(@RequestBody String username, String password){
        String retrievedPassword = userService.getPassword(username);
        if(retrievedPassword != null & retrievedPassword == password) {
            this.UserName = username;
        }
        return "Sleep";
    }

    @GetMapping("correct")
    public String connT(){
        return "index";
    }

    @GetMapping("/SleepPage")
    public String sleepPage(){
        return "Sleep";
    }
    @GetMapping("/MoodPage")
    public String MoodPage(){
        return "Mental";
    }
    @GetMapping("/WellnessPage")
    public String wellnessPage(){
        return "Physical";
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
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        sleepService.insertSleepData(score, curDate);
    }

    @PostMapping("/saveMoodData")
    @ResponseBody
    public void insertMoodData(@RequestBody Integer score){
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        moodService.insertMoodData(score, curDate);
    }

    @PostMapping("/saveWellnessData")
    @ResponseBody
    public void insertWellnessData(@RequestBody Integer score){
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        wellnessService.insertWellnessData(score, curDate);
    }


    @GetMapping("/getWeeklySleepData")
    @ResponseBody
    public List<Integer> getWeeklySleepData(){
        List<Integer> sleepWList = sleepService.getSleepData(7).stream()
                .map(Sleep::getScore)
                .collect(Collectors.toList());
        System.out.println(sleepWList);
        return sleepWList;
    }

    @GetMapping("/getMonthlySleepData")
    @ResponseBody
    public List<Integer> getMonthlySleepData() {

        return sleepService.getSleepData(30).stream()
                .map(Sleep::getScore)
                .collect(Collectors.toList());
    }

}
