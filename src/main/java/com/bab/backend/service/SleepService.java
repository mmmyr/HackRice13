package com.bab.backend.service;

import com.bab.backend.entity.Sleep;

import java.sql.Date;
import java.util.List;

public interface SleepService {

    void createTable(String tableName);

    void insertSleepData(String username, int score, Date date);

    List<Sleep> getSleepData(String username, int days);

}
