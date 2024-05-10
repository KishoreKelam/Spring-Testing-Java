package com.springexample.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;

// @ComponentScan(basePackages = {"Student"})
@SpringBootApplication
@EnableAutoConfiguration

public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @GetMapping()
	// public List<String> hello() {
	// Student student = new Student();
	// student.setAge(20);
	// student.setName("John Doe");
	// student.setEmail("ksihroe.kumar@gmail.com");
	// student.setDob("1999-01-01");
	// return List.of("Hello", "World");
	// }

	// @GetMapping()
	// public Student hello() {
	// Student student = new Student();

	// student.setAge(20);
	// student.setName("John Doe");
	// student.setDob(LocalDate.of(1995, Month.JANUARY, 1));
	// student.setEmail("ksihroe.kumar@gmail.com");
	// return student;

	// // return new Student(20, "John Doe", "Kishore@gmail.com", LocalDate.of(1995,
	// Month.JANUARY, 1));
	// }

}
