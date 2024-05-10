package com.springexample.spring.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springexample.spring.Models.Student;

@Component
public class StudentManager {

    @Autowired
    private StudentRepository studentRepository;

    // public StudentManager(StudentRepository studentRepository) {
    // this.studentRepository = studentRepository;
    // }

    public void saveStudent() {

        Student student = new Student();
        student.setAge(28);
        student.setName("Kishore Kumar Kelam");
        student.setEmail("Kishore@gmail.com");
        student.setDob(LocalDate.of(1995, Month.JUNE, 26));

        studentRepository.save(student);
    }

    public void saveStudentObject(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }
        student.setAge(
                student.getAge() > 0 ? student.getAge() : LocalDate.now().getYear() - student.getDob().getYear());
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        return studentRepository.findAll();
    }

    public Student getStudentById(String studentId) {
        // TODO Auto-generated method stub
        return studentRepository.findById(Integer.parseInt(studentId)).orElseThrow(() -> new IllegalStateException(
                "Student with id " + studentId + " does not exist in the database"));
    }

    public Optional<List<Student>> getStudentByAge(int studentAge) {
        // TODO Auto-generated method stub
        return studentRepository.getmeStudentByAge(studentAge);
    }

    public void deleteStudent(String id) {
        if (!studentRepository.existsById(Integer.parseInt(id))) {
            throw new IllegalStateException("Student with id " + id + " does not exist in the database");
        }
        // TODO Auto-generated method stub
        studentRepository.deleteById(Integer.parseInt(id));
    }

    // @Transactional
    public String deleteStudentByAge(String age) {
        Optional<List<Student>> studentOptional = studentRepository.getmeStudentByAge(Integer.parseInt(age));
        System.out.println(studentOptional);
        if (studentOptional.isPresent() && !studentOptional.get().isEmpty()) {
            studentRepository.deleteStudentByAge(Integer.parseInt(age));
            return "Student with age " + age + " deleted successfully";
        }
        return "Student with age " + age + " does not exist in the database";
    }

    @Transactional
    public void updateStudentById(String id, String name, int age, String email) {

        if (studentRepository.existsById(Integer.parseInt(id))) {
            Student student = studentRepository.findById(Integer.parseInt(id)).get();
            if (name != null && name != "" && !name.isEmpty()) {
                student.setName(name);
            }
            if (age > 0) {
                student.setAge(age);
            }
            if (email != null && email != "" && !email.isEmpty()) {
                student.setEmail(email);
            }
        } else {
            throw new IllegalStateException("Student with id " + id + " does not exist in the database");
        }
    }

    @Transactional
    public String updateStudentObject(String id, Student student) {
        // TODO Auto-generated method stub
        if (studentRepository.existsById(Integer.parseInt(id))) {
            student.setId(Integer.parseInt(id));
            if (student.getName() == null || student.getName() == "" || student.getName().isEmpty()) {
                student.setName("Student Name");
            }
            if (student.getAge() < 0 || student.getAge() == 0) {
                student.setAge(25);
            }
            if (student.getEmail() == null || student.getEmail() == "" || student.getEmail().isEmpty()) {
                student.setEmail("Example@gmail.com");
            }
            if (student.getDob() == null) {
                if (student.getName().contains("Kishore")) {
                    student.setDob(LocalDate.of(1995, Month.JUNE, 26));
                } else {
                    student.setDob(LocalDate.now());
                }
            }

            studentRepository.save(student);
            return "Student with id " + id + " updated successfully";
        } else {
            return "Student with id " + id + " does not exist in the database";
        }
    }

}
