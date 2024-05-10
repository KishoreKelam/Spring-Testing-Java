package com.springexample.spring.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.springexample.spring.Models.Student;

@Component
public class StudentRestServer {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentManager studentManager;

    public List<Student> getStudents() {
        return studentManager.getStudents();
        // return studentRepository.findAll();
    }

    public ResponseEntity<?> saveStudent() {
        studentManager.saveStudent();
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> saveStudents(List<Student> students) {
        studentRepository.saveAll(students);
        return ResponseEntity.ok().build();

    }

    public ResponseEntity<?> saveStudentObject(Student student) {
        // TODO Auto-generated method stub
        studentManager.saveStudentObject(student);
        return ResponseEntity.ok().build();
    }

    public Student getStudentById(String studentId) {
        // TODO Auto-generated method stub
        return studentManager.getStudentById(studentId);
    }

    public Optional<List<Student>> getStudentByAge(int studentAge) {
        return studentManager.getStudentByAge(studentAge);
    }

    public String deleteStudent(String id) {
        // TODO Auto-generated method stub
        studentManager.deleteStudent(id);
        return "Student with id " + id + " deleted successfully";
    }

    public String deleteStudentByAge(String age) {
        // TODO Auto-generated method stub
        return studentManager.deleteStudentByAge(age);
    }

    public void updateStudentById(String id, String name, int age, String email) {
        // TODO Auto-generated method stub
        studentManager.updateStudentById(id, name, age, email);
    }

    public String updateStudentObject(String id, Student student) {
        // TODO Auto-generated method stub
        return studentManager.updateStudentObject(id, student);
    }

    // public List<Student> getStudents() {
    // return List.of(new Student(
    // 1, 0, "John Doe", "Kishore@gmail.com", LocalDate.of(1995, Month.JANUARY,
    // 1)));
    // }

}
