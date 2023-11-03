package com.example.studentapp.model;

import lombok.Data;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Data
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    private String description;

    private String color;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel student;


}
