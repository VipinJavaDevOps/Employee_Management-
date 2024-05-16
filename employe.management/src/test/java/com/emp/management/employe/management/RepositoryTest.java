package com.emp.management.employe.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.emp.management.employe.management.TaskController.StudentController;
import com.emp.management.employe.management.TaskEntity.Student;
import com.emp.management.employe.management.TaskRepository.StudentRepo;

@SpringBootTest

public class RepositoryTest {
	
	@Autowired
	private StudentController controller;
	@MockBean
	private StudentRepo repository;
	
	
	
	@Test
	public void getAllStudent() throws Exception {
	when(repository.findAll()).thenReturn(Stream.of(new Student(5L,"rohan-tiwari","male","8987658675"),new Student(3L,"rohan-dubey","male","8987658679")).collect(Collectors.toList()));
		assertEquals(2,repository.findAll().size());
		
	}
 @Test
 public void addStudent()throws Exception{
	 Student student= new Student(2L,"rohan","male","8908080087");
	 when(repository.save(student)).thenReturn(student);
	 assertEquals(student, repository.save(student));
 }
 
 
 @Test
 public void UpdateStudent() throws Exception{
 
	// Student student=repository.findById(2L).get();
	// when(repository.save(student)).thenReturn(student);
	 Student student= new Student(2L,"Amit","male","809862652");
	 student.setFullName("Sumit");
	 student.setPhoneNo("808862652");
	 when(repository.save(student)).thenReturn(student);
	 Student updateStudent=repository.save(student);
	 assertThat(updateStudent.getFullName()).isEqualTo("Sumit");
	 assertThat(updateStudent.getPhoneNo()).isEqualTo("808862652");
	
	 
	 
 }
 
 
 @Test
 public void DeleteStudent()throws Exception{
	 Long id=1L;
	
	doNothing().when(repository).deleteById(id);
	repository.deleteById(id);
	 verify(repository,times(1)).deleteById(id);
	 
 }
}
