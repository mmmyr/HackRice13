package com.bab.backend.service.impl;

import com.bab.backend.entity.Wellness;
import com.bab.backend.mapper.WellnessMapper;
import com.bab.backend.service.WellnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class WellnessServiceImpl implements WellnessService {
    @Autowired
    WellnessMapper wellnessMapper;
    @Override
    public void createTable(String tableName) {
        if (wellnessMapper.getTableNameIfExists(tableName) == null) {
            wellnessMapper.createTable(tableName);
        }
    }

    @Override
    public void insertWellnessData(String username, int score, Date date) {
        wellnessMapper.insertWellnessData(username,score, date);
    }

    @Override
    public List<Wellness> getWellnessData(String username, int days) {
        return wellnessMapper.getWellnessData(username, days);
    }
}
