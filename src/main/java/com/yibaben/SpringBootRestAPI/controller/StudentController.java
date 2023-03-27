package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.medel.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Bennett",
                "Wenifiri"
        );
        return student;
    }
}
