package com.example.examapi.service;

import com.example.examapi.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class FitService {
    private final UserDao userDao;

    public FitService(UserDao userDao) {
        this.userDao = userDao;
    }

    public double getSpeed(double way, double time) {
        double formatTime = (time / 60);
        return way / formatTime;
    }

    public double getFormatResult(double value) {
        double scale = Math.pow(10, 3);
        return Math.ceil(value * scale) / scale;
    }

    public double stepLenghtForWalk(long id) {
        return(double)userDao.getUserById(id).getHeight() / 4 + 37;
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

    public double getCaloriesAfterWalk(long id, double way, double time) {
        double speed = getSpeed(way, time);
        int weight = userDao.getUserById(id).getWeight();
        int height = userDao.getUserById(id).getHeight();
        double result = 0.035 * weight + ((speed*speed)/height) * 0.029 * weight;
        return result*time;
    }

    public double getCaloriesAfterRun(long id, double way){
        int weight = userDao.getUserById(id).getWeight();
        return weight*way;
    }


}
