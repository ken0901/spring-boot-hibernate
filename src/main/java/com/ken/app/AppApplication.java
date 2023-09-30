package com.ken.app;

import com.ken.app.test.hibernate.jpa.dao.StudentDAO;
import com.ken.app.test.hibernate.jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// If package is outside of main method then define location using scanBasePackages to scan package.
//@SpringBootApplication(
//		scanBasePackages =  {"com.ken.app.component.scan.util",
//							 "com.ken.app.controller"}
//)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Ken", "Lee", "ken@gmail.com");

		//Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
