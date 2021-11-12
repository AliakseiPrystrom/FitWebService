package com.example.examapi.dao;

import com.example.examapi.entity.History;

import java.util.List;

public interface HistoryDao {

    void save(History history);

    void delete(long id);

    List<History> getAll();

    boolean isExist(History history);

    boolean isExistById(long id);
}
