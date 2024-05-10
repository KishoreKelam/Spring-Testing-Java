package com.springexample.spring.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springexample.spring.Models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // @Query("SELECT s FROM Student s WHERE s.email = ?1")

    Optional<Student> findStudentByEmail(String email);

    Optional<Student> findStudentByName(String name);

    Optional<Student> findStudentByNameAndId(String name, int id);

    // @Query("SELECT s FROM Student s WHERE s.age = ?1")
    // Optional<Student> getmeStudentByAge(int age);

    @Query("SELECT s FROM Student s WHERE s.age = ?1")
    Optional<List<Student>> getmeStudentByAge(int age);

    String deleteStudentByAge(int age);

    // List<Student> findStudentByName(String name, int id);

    // Optional<Student> List<Student> findStudentByName(String name);

}
