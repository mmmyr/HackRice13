package com.bab.backend.service;

import com.bab.backend.entity.Mood;
import com.bab.backend.entity.Sleep;

import java.sql.Date;
import java.util.List;

public interface MoodService {
    void createTable(String tableName);

    void insertMoodData(String username, int score, Date date);

    List<Mood> getMoodData(String username, int days);

}
