package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.medel.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // Rest API returning student object as a bean
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Bennett",
                "Wenifiri"
        );
        return student;
    }

    // Rest API returning a list of student objects.

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bennett", "Wenifiri"));
        students.add(new Student(2, "Ebiye", "Ben"));
        students.add(new Student(3, "Pere", "Freeman"));
        students.add(new Student(4, "Tari", "Bennett"));

        return students;
    }

    // Spring Boot RestAPI with pathVariable annotation
    // {id} is the URI Template variable

    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Spring boot RestApi with RequestParam annotation
    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequest(@RequestParam int id){
        return  new Student(1, "Bennett", "Yibaben");
    }
}
