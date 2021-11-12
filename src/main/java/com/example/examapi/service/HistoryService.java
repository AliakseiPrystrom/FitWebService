package com.example.examapi.service;

import com.example.examapi.dao.HistoryDao;
import com.example.examapi.entity.History;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryService {
    final private HistoryDao historyDao;

    public HistoryService(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }


    public void saveHistory(long id,String date,String type,double way,double speed,double calories) {
        History history = new History(id,date,type,way,speed,calories);
            historyDao.save(history);
    }

    public boolean deleteHistory(long id) {
        if (historyDao.isExistById(id)) {
            historyDao.delete(id);
            return true;
        } else return false;
    }

    public List<History> getAllHistory() {
        return historyDao.getAll();
    }

    public String type(double speed) {
        if (speed < 7) {
            return "walk";
        } else return "running";
    }

    public String getDate() {
        Date date = new Date();
        return date.toString();
    }


}
