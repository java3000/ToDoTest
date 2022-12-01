package com.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends RepresentationModel<Task> {
    @Id
    @GenericGenerator(name = "incrementator", strategy = "increment")
    @GeneratedValue(generator = "incrementator")
    @Column(name = "id", nullable = false)
    private Long id;
    private String subject;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "tasks", fetch = FetchType.EAGER)
    private List<User> user;
}
