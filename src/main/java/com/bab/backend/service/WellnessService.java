package com.bab.backend.service;

import com.bab.backend.entity.Wellness;

import java.sql.Date;
import java.util.List;

public interface WellnessService {

    void createTable(String tableName);

    void insertWellnessData(String username, int score, Date date);

    List<Wellness> getWellnessData(String username, int days);
}
