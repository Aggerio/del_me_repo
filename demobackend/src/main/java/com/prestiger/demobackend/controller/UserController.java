package com.prestiger.demobackend.controller;

import com.prestiger.demobackend.entities.User;
import com.prestiger.demobackend.exceptions.UserNotFoundException;
import com.prestiger.demobackend.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = service.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<Object> fetch(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> fetch(@PathVariable Long id){
        try{
            User user = service.findById(id);
            return ResponseEntity.ok(user);
        }catch (UserNotFoundException e){
            Map<String, String> error = Map.of("message", e.getMessage());
            return ResponseEntity.status(404).body(error);

        }
    }
}
