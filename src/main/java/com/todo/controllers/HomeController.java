package com.todo.controllers;

import com.todo.entity.Task;
import com.todo.entity.User;
import com.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(Principal principal, Model model) {

        if (principal != null) {
            var usr = principal.getName();
            System.out.println(usr);
            var user = userService.loadUserByUsername(usr);
            model.addAttribute("task", new Task());
            model.addAttribute("tasks", userService.getUserTasks(((User) user).getId()));
        }

        return "home";
    }
}
