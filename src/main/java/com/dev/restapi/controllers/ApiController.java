package com.dev.restapi.controllers;

import com.dev.restapi.models.User;
import com.dev.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {
    @Autowired
    UserService userService;

    @GetMapping("users/all")
    public List<User> listAll() {
        return userService.findAll();
    }

    @GetMapping("user/id/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("user/username/{username}")
    public User findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("user/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("user/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
    }
}
