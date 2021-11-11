package com.example.examapi.dao;

import com.example.examapi.entity.User;

import java.util.List;

public interface UserDao {
    boolean isExist(User user);

    boolean isExistById(long id);

    void save(User user);

    void update(User user);

    void delete(long id);

    List<User> getAll();

    User getUserById(long id);
}
