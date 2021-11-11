package com.example.examapi.dao;

import com.example.examapi.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    final List<User> userList = new ArrayList<>();


    @Override
    public boolean isExist(User user) {
        return userList.contains(user);
    }

    @Override
    public boolean isExistById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public void update(User user) {
        delete(user.getId());
        save(user);
    }


    @Override
    public void delete(long id) {
        userList.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User getUserById(long id) {
       return userList.stream()
               .filter(user -> user.getId()==id)
               .findFirst()
               .get();
    }
}
