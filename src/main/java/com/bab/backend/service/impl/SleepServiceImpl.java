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
        if (sleepMapper.getTableNameIfExists(tableName) == null){
            sleepMapper.createTable(tableName);
        } else {
            System.out.println("tables already exists");
        }
    }

    @Override
    public void insertSleepData(String username, int score, Date date) {
        sleepMapper.insertSleepData(username, score, date);
    }

    @Override
    public List<Sleep> getSleepData(String username, int days) {
        return sleepMapper.getSleepData(username, days);
    }




}
