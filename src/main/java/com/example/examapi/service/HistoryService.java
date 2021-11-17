package com.example.examapi.service;

import com.example.examapi.entity.History;
import com.example.examapi.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public void save(History history) {
        historyRepository.save(history);
    }

    public List<History> findAll() {
        return historyRepository.findAll();
    }

    public History getHistoryDTO(String date, String type, double way, double speed, double calories) {
        return new History(date, type, way, speed, calories);
    }
}
