package com.todo.todotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.todo"})
@EntityScan(basePackages = {"com.todo.entity"})
@EnableJpaRepositories(basePackages = {"com.todo.repository"})
public class ToDoTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoTestApplication.class, args);
    }
}
