package com.bab.backend.service.impl;

import com.bab.backend.mapper.WellnessMapper;
import com.bab.backend.service.WellnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
@Service
public class WellnessServiceImpl implements WellnessService {
    @Autowired
    WellnessMapper wellnessMapper;
    @Override
    public void createTable(String tableName) {
        if (wellnessMapper.getTableNameIfExists() == null) {
            wellnessMapper.createTable(tableName);
        }
    }

    @Override
    public void insertWellnessData(int score, Date date) {
        wellnessMapper.insertMoodData(score, date);
    }
}
