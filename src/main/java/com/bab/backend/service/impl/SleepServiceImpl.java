package com.bab.backend.service.impl;

import com.bab.backend.entity.Sleep;
import com.bab.backend.mapper.SleepMapper;
import com.bab.backend.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class SleepServiceImpl implements SleepService {

    @Autowired
    SleepMapper sleepMapper;

    @Override
    public void createTable(String tableName) {
        if (sleepMapper.getTableNameIfExists() == null){
            sleepMapper.createTable(tableName);
        }
    }

    @Override
    public void insertSleepData(int score, Date date) {
        sleepMapper.insertSleepData(score, date);
    }

    @Override
    public List<Sleep> getSleepData(int days) {
        return sleepMapper.getSleepData(days);
    }
}
