package com.dev.restapi.controllers;

import com.dev.restapi.models.User;
import com.dev.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("users/all")
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @GetMapping("user/id/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("user/username/{username}")
    public User findByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping("user/save")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("user/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        return userRepository.deleteById(id);
    }
}
