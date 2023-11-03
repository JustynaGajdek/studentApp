package com.example.studentapp.controller;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students")
    public String getStudentList() {
        return "persons/personList";
    }

    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }


    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel student) {
        studentService.addStudent(student);
        return new RedirectView("/students");
    }


    @GetMapping("/editStudent")
    public String getEditStudent() {
        return "persons/editPerson";
    }
}
