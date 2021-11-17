package com.example.examapi.service;

import com.example.examapi.entity.User;
import com.example.examapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean save(User user) {
        if (!userRepository.existsById(user.getId())) {
            userRepository.save(user);
            return true;
        } else return false;
    }

    public boolean update(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
            return true;
        } else return false;
    }

    public boolean delete(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.delete(user);
            return true;
        } else return false;
    }

    public boolean deleteById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return Optional.of(userRepository.getById(id));
    }

    public boolean isExistById(long id){
        return userRepository.existsById(id);
    }


}
