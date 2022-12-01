package com.todo.controllers;

import com.todo.entity.Task;
import com.todo.entity.User;
import com.todo.services.TaskService;
import com.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/tasks")
@Controller
@ExposesResourceFor(Task.class)
public class TaskController {

    TaskService service;
    UserService userService;

    @Autowired
    public TaskController(TaskService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getAll(Principal principal) {
        List<Task> tasks = new ArrayList<>();
        if (principal != null) {
            var user = ((User) userService.loadUserByUsername(principal.getName()));
            tasks = user.getTasks();
            for (var task : user.getTasks()) {
                Link selfLink = linkTo(TaskController.class).slash(task.getId()).withSelfRel();
                task.add(selfLink);
            }
        }

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Task> get(@PathVariable long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("task") Task task, Principal principal) {
        if (principal != null) {
            var usr = principal.getName();
            var user = userService.loadUserByUsername(usr);
            if (user != null) {
                List<User> list = new ArrayList<>();
                list.add((User) user);
                task.setUser(list);

                ((User) user).getTasks().add(task);
            }
        }
        service.add(task);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model) {
        var task = service.get(id);
        model.addAttribute("editedTask", task);
        return "task";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("task") Task task) {
        if (task != null) {
            service.update(task);
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "redirect:/";
    }
}
