package onetomany.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onetomany.jpa.entity.Library;
import onetomany.jpa.entity.Student;
import onetomany.jpa.reposistory.LibraryRepository;
import onetomany.jpa.reposistory.StudentRepository;
@RestController
@RequestMapping("/student/lib")


public class StudentLibrary {
	@Autowired
	private StudentRepository studentRepository;
	private LibraryRepository libraryRepository;



	public StudentLibrary(StudentRepository studentrepository,LibraryRepository libraryRepository) {
		this.studentRepository=studentRepository;
		this.libraryRepository=libraryRepository;
	}
		@PostMapping("/student/lib")
		public ResponseEntity<String>savestudent(@RequestBody List<Student>studentData){
				//public ResponseEntity<String>saveStudent(@RequestBody List<Student>studentData){
			studentRepository.saveAll(studentData);
			return ResponseEntity.ok("Data saved");
	}
}
