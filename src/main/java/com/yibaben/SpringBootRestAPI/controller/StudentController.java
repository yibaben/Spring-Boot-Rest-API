package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.medel.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Student studentRequest(@RequestParam int id,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName){
        return  new Student(id, firstName, lastName);
    }

    // Spring boot Rest API with HTTP Post Request - Creating new resources
    // @PostMapping and @RequestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring boot Rest API with HTTP Put Request - Updating old/existing resources
    // @PutMapping, @RequestBody and @PathVariable
    @PutMapping("students/{id}/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getFirstName());
        return student;
    }

    // Spring boot Rest API with HTTP Delete Request - Deleting old/existing resources
    // @DeleteMapping and @PathVariable
    @DeleteMapping("student/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student Deleted Successfully";
    }

}
