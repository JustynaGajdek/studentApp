package com.example.studentapp.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "git_hub")
    private String gitHub;

    @Column(name = "start")
    private String start;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TaskModel> tasks;

}
