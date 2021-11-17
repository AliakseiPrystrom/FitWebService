package com.example.examapi.service;

import com.example.examapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FitService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HistoryService historyService;


    public double getSpeed(double way, double time) {
        double formatTime = (time / 60);
        return way / formatTime;
    }

    public double getFormatResult(double value) {
        double scale = Math.pow(10, 3);
        return Math.ceil(value * scale) / scale;
    }

    public double stepLenghtForWalk(long id) {
        return (double) userRepository.getById(id).getHeight() / 4 + 37;
    }

    public double stepLenghtForRun(long id) {
        return userRepository.getById(id).getHeight() * 0.65;
    }

    public double getDayResultWalkInKm(long id, int steps) {
        double length = stepLenghtForWalk(id);
        return getFormatResult((steps * length) / 100000);
    }


    public double getCaloriesAfterWalk(long id, double way, double time) {
        double speed = getSpeed(way, time);
        int weight = userRepository.getById(id).getWeight();
        int height = userRepository.getById(id).getHeight();
        double result = 0.035 * weight + ((speed * speed) / height) * 0.029 * weight;
        return result * time;
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

    public Map<Double, Double> getTotal(long id, int steps, double time) {
        Map<Double, Double> map = new HashMap<>();
        double way = getDayResultWalkInKm(id, steps);
        double speed = getSpeed(way, time);
        double calories = getCaloriesAfterWalk(id, way, time);
        String type = type(getSpeed(way, time));
        String date = getDate();
        map.put(way, calories);
        historyService.save(historyService.getHistoryDTO(date, type, way, speed, calories));
        return map;
    }

//        public double getResultRunInKm(long id, int steps) {
//        double length = stepLenghtForRun(id);
//        return getFormatResult((steps * length) / 100000);
//    }

//        public double getCaloriesAfterRun(long id, double way) {
//        int weight = userRepository.getById(id).getWeight();
//        return weight * way;
//    }

}



