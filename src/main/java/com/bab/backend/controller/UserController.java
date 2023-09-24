package com.bab.backend.controller;


import com.bab.backend.entity.Mood;
import com.bab.backend.entity.Sleep;
import com.bab.backend.entity.Wellness;
import com.bab.backend.service.MoodService;
import com.bab.backend.service.SleepService;
import com.bab.backend.service.UserService;
import com.bab.backend.service.WellnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")

public class UserController {

    private String UserName = "Bruce";

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

    @GetMapping("/getPassword")
    @ResponseBody
    String getPassword(@RequestParam String username){
        String password = userService.getPassword(username);
        System.out.println(password);
        return password;
    }

    @PostMapping("authorize")

    String authorize(@RequestParam String username, @RequestParam String password){

        String retrievedPassword = userService.getPassword(username);
        if (retrievedPassword != null && retrievedPassword.equals(password)) {
            this.UserName = username;
            return "Sleep";
        } else {
            return "login";
        }

    }

    @GetMapping("correct")
    public String connT(){
        return "index";
    }

    @GetMapping("/SleepPage")
    public String sleepPage(){
        sleepService.createTable(this.UserName);
        return "Sleep";
    }
    @GetMapping("/MoodPage")
    public String MoodPage(){
        moodService.createTable(this.UserName);
        return "Mental";
    }
    @GetMapping("/WellnessPage")
    public String wellnessPage(){
        wellnessService.createTable(this.UserName);
        return "Physical";
    }

    @GetMapping("/DoYouKnowPage")
    public String doYouKnowPage(){
        sleepService.createTable(this.UserName);
        return "finish";
    }



    @PostMapping("/saveSleepData")
    @ResponseBody
    public void insertSleepData(@RequestBody Integer score){
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        sleepService.insertSleepData(this.UserName, score, curDate);

    }

    @PostMapping("/saveMoodData")
    @ResponseBody
    public void insertMoodData(@RequestBody Integer score){
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        moodService.insertMoodData(this.UserName,score, curDate);

    }

    @PostMapping("/saveWellnessData")
    @ResponseBody
    public void insertWellnessData(@RequestBody Integer score){
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        wellnessService.insertWellnessData(this.UserName, score, curDate);
    }


    @GetMapping("/getWeeklySleepData")
    @ResponseBody
    public List<Integer> getWeeklySleepData(){
        List<Integer> sleepWList = sleepService.getSleepData(this.UserName, 7).stream()
                .map(Sleep::getScore)
                .collect(Collectors.toList());
        System.out.println(sleepWList);
        return sleepWList;
    }

    @GetMapping("/getWeeklyMoodData")
    @ResponseBody
    public List<Integer> getWeeklyMoodData(){
        List<Integer> moodWList = moodService.getMoodData(this.UserName, 7).stream()
                .map(Mood::getScore)
                .collect(Collectors.toList());
        System.out.println(moodWList);
        return moodWList;
    }

    @GetMapping("/getWeeklyWellnessData")
    @ResponseBody
    public List<Integer> getWeeklyWellnessData(){
        List<Integer> wellWList = wellnessService.getWellnessData(this.UserName, 7).stream()
                .map(Wellness::getScore)
                .collect(Collectors.toList());
        System.out.println(wellWList);
        return wellWList;
    }



    @GetMapping("/getMonthlySleepData")
    @ResponseBody
    public List<Integer> getMonthlySleepData() {

        return sleepService.getSleepData(this.UserName,30).stream()
                .map(Sleep::getScore)
                .collect(Collectors.toList());
    }
    @GetMapping("/getMonthlyMoodData")
    @ResponseBody
    public List<Integer> getMonthlyMoodData() {

        return moodService.getMoodData(this.UserName,30).stream()
                .map(Mood::getScore)
                .collect(Collectors.toList());
    }
    @GetMapping("/getMonthlyWellnessData")
    @ResponseBody
    public List<Integer> getMonthlyWellnessData() {

        return wellnessService.getWellnessData(this.UserName,30).stream()
                .map(Wellness::getScore)
                .collect(Collectors.toList());
    }



}
