package com.emp.management.employe.management.TaskController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emp.management.employe.management.TaskEntity.Student;
import com.emp.management.employe.management.TaskRepository.StudentRepo;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import jakarta.validation.metadata.MethodType;

@Controller
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	private StudentRepo studentRepo;
	
	
	@PostMapping("/save")
//	RequestMapping//("/save")
       public  String addStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "student";
	}
	@GetMapping("/studentlist")
	public List<Student>  getAllStudent() {
		List<Student>student=new ArrayList<Student>(); 
		studentRepo.findAll().forEach(student1->student.add(student1));
		return student; 
	}
	@PutMapping("/edit/{id}")
	public Student UpdateStudent( Student student,Long id ) {
		 return studentRepo.save(student);
	
	}
	@DeleteMapping("/delete/{id}")
	public void DeleteStudent(@PathVariable Long id) {
		// student=studentRepo.findById(id).get();
		studentRepo.deleteById(id);
	
		
	}
}
