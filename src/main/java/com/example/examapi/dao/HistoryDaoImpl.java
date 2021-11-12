package com.example.examapi.dao;

import com.example.examapi.entity.History;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryDaoImpl implements HistoryDao {
    final List<History> historyList = new ArrayList<>();


    @Override
    public void save(History history) {
        historyList.add(history);
    }

    @Override
    public void delete(long id) {
        historyList.removeIf(history -> history.getId() == id);
    }

    @Override
    public List<History> getAll() {
        return historyList;
    }

    @Override
    public boolean isExist(History history) {
        return historyList.contains(history);
    }

    @Override
    public boolean isExistById(long id) {
        for (History history : historyList) {
            if (history.getId() == id) {
                return true;
            }
        }
        return false;
    }
}

