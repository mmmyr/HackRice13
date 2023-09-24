package com.bab.backend.service.impl;

import com.bab.backend.entity.Mood;
import com.bab.backend.mapper.MoodMapper;
import com.bab.backend.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class MoodServiceImpl implements MoodService {

    @Autowired
    MoodMapper moodMapper;

    @Override
    public void createTable(String username) {
        if (moodMapper.getTableNameIfExists(username) == null) {
            moodMapper.createTable(username);
        }

    }

    @Override
    public void insertMoodData(String username, int score, Date date) {
        moodMapper.insertMoodData(username,score, date);
    }

    @Override
    public List<Mood> getMoodData(String username, int days) {
        return moodMapper.getMoodData(username, days);
    }
}
