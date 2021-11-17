package com.example.examapi.controller;

import com.example.examapi.entity.User;
import com.example.examapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        if (userService.save(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        if (!userService.findAll().isEmpty()) {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable long id) {
        if (userService.findById(id).isPresent()) {
            return new ResponseEntity<>(userService.findById(id).get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        if (userService.update(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable long id) {
        if (userService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
