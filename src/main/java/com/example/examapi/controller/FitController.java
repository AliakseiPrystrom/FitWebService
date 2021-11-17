package com.example.examapi.controller;

import com.example.examapi.service.FitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/fit")
public class FitController {

    @Autowired
    private FitService fitService;


    @PostMapping("/walk/{id}/{steps}/{time}")
    public ResponseEntity<Map<Double, Double>> walk(@PathVariable long id, @PathVariable int steps, @PathVariable double time) {
        return new ResponseEntity<>(fitService.getTotal(id, steps, time), HttpStatus.OK);
    }

    @PostMapping("/run/{id}/{steps}/{time}")
    public ResponseEntity<Map<Double, Double>> run(@PathVariable long id, @PathVariable int steps, @PathVariable double time) {
        return new ResponseEntity<>(fitService.getTotal(id, steps, time), HttpStatus.OK);
    }

}
