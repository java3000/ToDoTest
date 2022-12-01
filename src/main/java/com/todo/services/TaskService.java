package com.todo.services;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;


    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task get(long id) {
        return repository.findById(id).orElseThrow();
    }

    public boolean add(Task task) {
        repository.save(task);
        return true;
    }

    public void update(Task task) {
        if (repository.findById(task.getId()).isPresent()) {
            repository.save(task);
        }
    }

    public boolean delete(long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
