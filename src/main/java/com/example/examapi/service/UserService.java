package com.example.examapi.service;

import com.example.examapi.dao.UserDao;
import com.example.examapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public boolean save(User user) {
        if (!userDao.isExist(user)) {
            userDao.save(user);
            return true;
        } else return false;
    }

    public boolean update(User user) {
        if (userDao.isExist(user)) {
            userDao.update(user);
            return true;
        } else return false;
    }

    public boolean delete(long id) {
        if (userDao.isExistById(id)) {
            userDao.delete(id);
            return true;
        } else return false;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
