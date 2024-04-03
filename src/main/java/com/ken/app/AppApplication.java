package com.ken.app;

import com.ken.app.test.api.jpa.dao.StudentDAO;
import com.ken.app.test.api.jpa.entity.Student;
import com.ken.app.test.hibernate.jpa.dao.AppDAO;
import com.ken.app.test.hibernate.jpa.entity.Course;
import com.ken.app.test.hibernate.jpa.entity.Instructor;
import com.ken.app.test.hibernate.jpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);

			updateCourse(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 11;

		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("JSP course");

		appDAO.update(tempCourse);
		System.out.println("Done !");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 3;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setFirstName("Ken");

		appDAO.update(tempInstructor);
		System.out.println("Done !");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 3;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done !");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated coures: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Ken","Lee","ken@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube/kenlee","Coding");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Java Beginner");
		Course tempCourse2 = new Course("Angular Beginner");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done !");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor detail: " + theId);

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done !");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*// create the instructor
		Instructor tempInstructor = new Instructor("Ken","Lee","ken@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube/kenlee","Coding");*/

		// create the instructor
		Instructor tempInstructor = new Instructor("Katie","Lee","katie@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube/katielee","Cooking");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		/*};
	}*/

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int studentId = 5;
		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		// Update the student
		studentDAO.update(myStudent);

		// Display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Lee");

		// Display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
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
