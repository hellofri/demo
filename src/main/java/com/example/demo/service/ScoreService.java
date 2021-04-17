package com.example.demo.service;

import com.example.demo.model.Score;

import java.util.List;

public interface ScoreService {
    List<Score> test(int pageNum, int pageSize);
}
