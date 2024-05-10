package com.springexample.spring.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.spring.Models.Student;

@RestController

@RequestMapping(path = "api/v1/students")
// @ResponseBody
// @RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentRestServer studentRestServer;

    // public StudentController(StudentRestServer studentRestServer) {
    // this.studentRestServer = studentRestServer;
    // }

    // @GetMapping(path = "api/v1/students", produces = "application/json")
    @GetMapping(path = "/get", produces = "application/json")
    public List<Student> getStudents() {
        return studentRestServer.getStudents();
    }

    @PostMapping(path = "save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        // TODO: process POST request
        return studentRestServer.saveStudentObject(student);
    }

    // @PutMapping("update/{id}")
    // public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody
    // Student student) {
    // // TODO: process PUT request
    // // studentRestServer.saveStudentObject(student);

    // return ResponseEntity.ok().build();
    // }

    @PutMapping("update/{id}")
    public void updateStudentById(@PathVariable String id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) int age,
            @RequestParam(name = "email", required = false) String email) {
        // TODO: process PUT request
        studentRestServer.updateStudentById(id, name, age, email);
    }

    @PutMapping("update/student/{id}")
    public String updateStudentObject(@PathVariable String id, @RequestBody Student student) {
        return studentRestServer.updateStudentObject(id, student);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentRestServer.getStudentById(id);
    }

    @GetMapping("age/{id}")
    public Optional<List<Student>> getStudentByAge(@PathVariable int id) {
        return studentRestServer.getStudentByAge(id);
    }

    @DeleteMapping(path = "delete/{studentId}")
    public String deleteStudent(@PathVariable(name = "studentId") String id) {
        return studentRestServer.deleteStudent(id);
    }

    @DeleteMapping(path = "age/{age}")
    public String deleteStudentByAge(@PathVariable(name = "age") String age) {
        return studentRestServer.deleteStudentByAge(age);
    }

}
