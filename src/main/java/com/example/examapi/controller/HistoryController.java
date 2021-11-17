package com.example.examapi.controller;

import com.example.examapi.entity.History;
import com.example.examapi.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<History>> getHistory() {
        if (!historyService.findAll().isEmpty()) {
            return new ResponseEntity<>(historyService.findAll(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


}
