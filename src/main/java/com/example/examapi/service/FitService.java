package com.example.examapi.service;

import com.example.examapi.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class FitService {
    private final UserDao userDao;

    public FitService(UserDao userDao) {
        this.userDao = userDao;
    }

    public double stepLenghtForWalk(long id) {
        return userDao.getUserById(id).getHeight() / 4 + 37;
    }

    public double stepLenghtForRun(long id) {
        return userDao.getUserById(id).getHeight() * 0.65;
    }

    public double getDayResultWalkInKm(long id, int steps) {
        double length = stepLenghtForWalk(id);
        return getFormatResult((steps * length) / 100000);
    }

    public double getResultRunInKm(long id, int steps) {
        double length = stepLenghtForRun(id);
        return getFormatResult((steps * length) / 100000);
    }

    public double getCalories(long id, double way, double time) {
        double formatTime = time/60;
        double speed = getSpeed(way, time);
        int weight = userDao.getUserById(id).getWeight();
        //int height = userDao.getUserById(id).getHeight();
        if (speed < 4) {
            return (1.5 * weight) * formatTime;
        } else if (speed >= 4 && speed < 6) {
            return (3.2 * weight) * formatTime;
        } else if (speed >= 6 && speed < 8) {
            return (4.5 * weight) * formatTime;
        } else if (speed >= 8 && speed <= 10) {
            return (10 * weight) * formatTime;
        }
        return 0;
    }

//return 0.035 * weight + (speed * speed / height) * 0.029 * weight;


    public double getSpeed(double way, double time) {
        double formatTime = (time / 60);
        return way / formatTime;
    }

    public double getFormatResult(double value) {
        double scale = Math.pow(10, 3);
        return Math.ceil(value * scale) / scale;
    }


}
