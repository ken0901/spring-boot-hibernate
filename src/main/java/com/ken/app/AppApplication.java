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
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		//Create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		//Save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//Display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//Create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Kaite", "Lee", "kaite@gmail.com");
		Student tempStudent2 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent3 = new Student("Latie", "Lee", "latie@gmail.com");

		//Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

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
