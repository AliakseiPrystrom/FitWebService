package com.example.examapi.controller;

import com.example.examapi.entity.History;
import com.example.examapi.service.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<History>> getHistory() {
        if (!historyService.getAllHistory().isEmpty()) {
            return new ResponseEntity<>(historyService.getAllHistory(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<History> delete(@PathVariable long id) {
        if (historyService.deleteHistory(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
