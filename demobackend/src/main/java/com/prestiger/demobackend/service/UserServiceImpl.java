package com.prestiger.demobackend.service;

import com.prestiger.demobackend.dao.UserRepository;
import com.prestiger.demobackend.entities.User;
import com.prestiger.demobackend.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepo;

    public User createUser(User user){
        return userRepo.save(user);
    }
    public User findById(long id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user " + id + " not found"));
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

}
