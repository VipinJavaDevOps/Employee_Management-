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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.emp.management.employe.management.TaskEntity.Student;
import com.emp.management.employe.management.TaskRepository.StudentRepo;
import com.emp.management.employe.management.TaskService.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	@Mock
	private StudentRepo repo;
	@InjectMocks
	private StudentService service;
	
	
	@Test
	public void getAllStudent() throws Exception {
	when(service.getAllStudent()).thenReturn(Stream.of(new Student(5L,"rohan-tiwari","male","8987658675"),new Student(3L,"rohan-dubey","male","8987658679")).collect(Collectors.toList()));
		assertEquals(2,service.getAllStudent().size());
		
	}
 @Test
 public void addStudent()throws Exception{
	 Student student= new Student(2L,"rohan","male","8908080087");
	 when(repo.save(student)).thenReturn(student);
	 service.addStudent(student);
	 assertEquals(student, repo.save(student));
	 assertThat(student.getFullName()).isEqualTo("rohan");
 }
 
 
 @Test
 public void UpdateStudent() throws Exception{
 
	// Student student=repository.findById(2L).get();
	// when(repository.save(student)).thenReturn(student);
	 Student student= new Student(2L,"Amit","male","809862652");
	 long id=2L;
	 student.setFullName("Sumit");
	 student.setPhoneNo("808862652");
	 when(repo.save(student)).thenReturn(student);
	 Student updateStudent=service.UpdateStudent(student,id);
	 assertThat(updateStudent.getFullName()).isEqualTo("Sumit");
	 assertThat(updateStudent.getPhoneNo()).isEqualTo("808862652");
	
	 
	 
 }
 
 
 @Test
 public void DeleteStudent()throws Exception{
	 Long id=1L;
	
	doNothing().when(repo).deleteById(id);
	service.DeleteStudent(id);
	 verify(repo,times(1)).deleteById(id);
	 
 }

}
