package com.bab.backend.service.impl;

import com.bab.backend.entity.Mood;
import com.bab.backend.mapper.MoodMapper;
import com.bab.backend.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
public class MoodServiceImpl implements MoodService {

    @Autowired
    MoodMapper moodMapper;

    @Override
    public void createTable(String tableName) {
        if (moodMapper.getTableNameIfExists() == null) {
            moodMapper.createTable("ada_mood_table");
        }

    }

    @Override
    public void insertMoodData(int score, Date date) {
        moodMapper.insertMoodData(score, date);
    }
}
