package com.bab.backend.service;

import java.sql.Date;

public interface WellnessService {

    void createTable(String tableName);

    void insertWellnessData(int score, Date date);
}
