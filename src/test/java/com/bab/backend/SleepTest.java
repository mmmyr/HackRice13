package com.bab.backend;

import com.bab.backend.service.MoodService;
import com.bab.backend.service.SleepService;
import com.bab.backend.service.WellnessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
public class SleepTest {
    @Autowired
    SleepService sleepService;

    @Autowired
    MoodService moodService;

    @Autowired
    WellnessService wellnessService;
    @Test
    void PlayDate(){
    }

    @Test
    void genSleep(){
        sleepService.createTable("Benson");
    }

//    @Test
//    void setSleepDate(){
//        LocalDate curLocalDate = LocalDate.now();
//        Date curDate = Date.valueOf(curLocalDate);
//        sleepService.insertSleepData("Bruce",2,curDate);
//    }

    @Test
    void genMood(){
        moodService.createTable("ada_mood_table");
    }

    @Test
    void genWellness(){
        wellnessService.createTable("ada_wellness_table");
    }

    @Test
    void getDate(){
//        var data = moodService.getMoodData();
    }
}
