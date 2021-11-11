package com.example.examapi.controller;

import com.example.examapi.entity.User;
import com.example.examapi.service.FitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/fit")
public class FitController {

    private final FitService fitService;

    public FitController(FitService fitService) {
        this.fitService = fitService;
    }

    @PostMapping("/walk/{id}/{steps}/{time}")
    public ResponseEntity<Map<Double, Double>> walk(@PathVariable long id, @PathVariable int steps, @PathVariable double time) {
        double way = fitService.getDayResultWalkInKm(id, steps);
        double calories = fitService.getCalories(id, way, time);
        Map<Double, Double> map = new HashMap<>();
        map.put(way, calories);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/run/{id}/{steps}")
    public ResponseEntity<Double> run(@PathVariable long id, @PathVariable int steps) {
        return new ResponseEntity<>(fitService.getResultRunInKm(id, steps), HttpStatus.OK);
    }

}
