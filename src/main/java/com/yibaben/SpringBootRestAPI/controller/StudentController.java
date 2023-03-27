package com.yibaben.SpringBootRestAPI.controller;

import com.yibaben.SpringBootRestAPI.medel.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // Rest API returning student object as a bean
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Bennett",
                "Wenifiri"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
         return ResponseEntity.ok(student);

         // Adding custom header to Http with ResponseEntity class
//        return ResponseEntity.ok()
//                .header("custom-header", "Bennett")
//                .body(student);
    }

    // Rest API returning a list of student objects.
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bennett", "Wenifiri"));
        students.add(new Student(2, "Ebiye", "Ben"));
        students.add(new Student(3, "Pere", "Freeman"));
        students.add(new Student(4, "Tari", "Bennett"));

        return ResponseEntity.ok(students);
    }

    // Spring Boot RestAPI with pathVariable annotation
    // {id} is the URI Template variable

    @GetMapping("student/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot RestApi with RequestParam annotation
    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequest(@RequestParam int id,
                                  @RequestParam String firstName,
                                  @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot Rest API with HTTP Post Request - Creating new resources
    // @PostMapping and @RequestBody

    @PostMapping("students/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot Rest API with HTTP Put Request - Updating old/existing resources
    // @PutMapping, @RequestBody and @PathVariable
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getFirstName());
        return ResponseEntity.ok(student);
    }

    // Spring boot Rest API with HTTP Delete Request - Deleting old/existing resources
    // @DeleteMapping and @PathVariable
    @DeleteMapping("student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student Deleted Successfully");
    }

}
