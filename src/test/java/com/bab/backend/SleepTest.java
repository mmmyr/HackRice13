package com.bab.backend;

import com.bab.backend.service.SleepService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
public class SleepTest {
    @Autowired
    SleepService sleepService;
    @Test
    void PlayDate(){
        Date adaDate = sleepService.getCreateDate(1);
        System.out.println(adaDate);
        LocalDate newDate = adaDate.toLocalDate();
        newDate.plusDays(2);
        System.out.println(newDate);
        Date newAdaDate = Date.valueOf(newDate);
        System.out.println(newAdaDate);
    }

    @Test
    void genSleep(){
        sleepService.createTable("Ada_Sleep_Table");
    }

    @Test
    void setSleepDate(){
        LocalDate curLocalDate = LocalDate.now();
        Date curDate = Date.valueOf(curLocalDate);
        sleepService.insertSleepData(2,curDate);
    }

    @Test
    void genMood(){
        return;
    }
}
