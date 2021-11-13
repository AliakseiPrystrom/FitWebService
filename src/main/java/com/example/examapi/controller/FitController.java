package com.example.examapi.controller;

import com.example.examapi.service.FitService;
import com.example.examapi.service.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/fit")
public class FitController {

    private final FitService fitService;
    private final HistoryService historyService;

    public FitController(FitService fitService, HistoryService historyService) {
        this.fitService = fitService;
        this.historyService = historyService;
    }

    @PostMapping("/walk/{id}/{steps}/{time}")
    public ResponseEntity<Map<Double, Double>> walk(@PathVariable long id, @PathVariable int steps, @PathVariable double time) {
        double way = fitService.getDayResultWalkInKm(id, steps);
        double speed = fitService.getSpeed(way,time);
        double calories = fitService.getCaloriesAfterWalk(id, way, time);
        String type = historyService.type(fitService.getSpeed(way,time));
        String date = historyService.getDate();
        Map<Double, Double> map = new HashMap<>();
        map.put(way, calories);
        historyService.saveHistory(id,date,type,way,speed,calories);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/run/{id}/{steps}/{time}")
    public ResponseEntity<Map<Double, Double>> run(@PathVariable long id, @PathVariable int steps,@PathVariable double time) {
        double way = fitService.getResultRunInKm(id, steps);
        double speed = fitService.getSpeed(way,time);
        double calories = fitService.getCaloriesAfterRun(id, way);
        String type = historyService.type(fitService.getSpeed(way,time));
        String date = historyService.getDate();
        Map<Double, Double> map = new HashMap<>();
        map.put(way, calories);
        historyService.saveHistory(id,date,type,way,speed,calories);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

}
