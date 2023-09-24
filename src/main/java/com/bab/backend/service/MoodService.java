package com.bab.backend.service;

import java.sql.Date;

public interface MoodService {
    void createTable(String tableName);

    void insertMoodData(int score, Date date);

}
