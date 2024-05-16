package com.emp.management.employe.management.TaskService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.emp.management.employe.management.TaskEntity.Student;
import com.emp.management.employe.management.TaskRepository.StudentRepo;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepo repo;
	
	public String addStudent(Student student ) {
		repo.save(student);
		return "student";
	}
	public List<Student>getAllStudent(){
	
		List<Student>student=new ArrayList<Student>(); 
		repo.findAll().forEach(student1->student.add(student1));
		return student; 
	}
	
	public Student UpdateStudent( Student student,Long id ) {
		 return repo.save(student);
	}
	public void DeleteStudent(@PathVariable Long id) {
		// student=studentRepo.findById(id).get();
		repo.deleteById(id);
	
	}
	

}
