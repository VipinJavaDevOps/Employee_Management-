package onetomany.jpa.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onetomany.jpa.entity.Students;
import onetomany.jpa.reposistory.CourseRepository;
import onetomany.jpa.reposistory.StudentsRepository;

//import onetomany.jpa.entity.Customer;
//import onetomany.jpa.entity.Students;
//import onetomany.jpa.reposistory.CustomerRepository;

//import onetomany.jpa.entity.Student;
//import onetomany.jpa.reposistory.StudentRepository;

@RestController
@RequestMapping("/student/course")
public class StudentsCourseController {
	@Autowired
	private StudentsRepository studentRepository;
	private CourseRepository courseRepository;
	public StudentsCourseController(StudentsRepository studentrepository,CourseRepository courseRepository) {
		this.studentRepository=studentRepository;
		this.courseRepository=courseRepository;
	}
	@PostMapping("/savestudent/course")
	public Students saveStudentsWithCourse(@RequestBody Students student) {
		return studentRepository.save(student);
	
	}
	
	

}
