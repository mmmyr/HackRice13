package com.bab.backend.service;

import com.bab.backend.entity.Sleep;

import java.sql.Date;
import java.util.List;

public interface SleepService {

    void createTable(String tableName);

    void insertSleepData(int score, Date date);

    List<Sleep> getSleepData(int days);
}
