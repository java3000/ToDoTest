package com.todo.controllers;

import com.todo.entity.User;
import com.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}", produces = {"application/hal+json"})
    public ResponseEntity<User> get(@PathVariable long id) {
        var user = service.get(id);
        return ResponseEntity.ok(user);
    }

}
