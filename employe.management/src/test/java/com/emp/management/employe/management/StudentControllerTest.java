package com.emp.management.employe.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emp.management.employe.management.TaskController.StudentController;
import com.emp.management.employe.management.TaskEntity.Student;
import com.emp.management.employe.management.TaskRepository.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(SpringExtension.class)

@WebMvcTest(controllers = StudentController.class)

public class StudentControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private StudentRepo  repository;
	@Autowired
	private StudentController studentController;
	
//	private JacksonTester<Student> jsonStudent;
	@BeforeEach
	public void setup() {
     	JacksonTester.initFields(this,new ObjectMapper());
		mvc=MockMvcBuilders.standaloneSetup(studentController)
				//.setControllerAdvice(new Student(0, null, null, null))
				//.addFilters()
				.build();
				
		
	}
	
	@Test
	public void addStudentTest() throws Exception{
		String uri="/Student/save";
	          mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(
  				new ObjectMapper().writeValueAsString(new Student(3L,"Rahul","male","9089786342"))))
	  				.andExpect(MockMvcResultMatchers.status().isOk());
//	
	}
	@Test
	public void getAllStudent()throws Exception{
		String uri="/Student/studentlist";
		List<Student>student=Arrays.asList(new Student(3L,"Rahul","male","9089786342"),new Student(3L,"Rohan","male","9080786342"));
		when(studentController.getAllStudent()).thenReturn(student);
		 mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON)
				 .content(
	  				new ObjectMapper().writeValueAsString(student)))
		  				.andExpect(MockMvcResultMatchers.status().isOk());
		  			assertEquals(2, studentController.getAllStudent().size());;	
		
	}
	@Test
	public void UpdateStudent()throws Exception{
		String uri="/Student/edit/3";
		Long id=3L;
		 Student student= new Student(3L,"Amit","male","809862652");
		
		 student.setFullName("Sumit");
		 student.setPhoneNo("808862652");
		 //when(studentController.UpdateStudent(student,id)).thenReturn(student);
		 //Student updateStudent=repository.save(student);
		 mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
				 .content(
	  				new ObjectMapper().writeValueAsString(id)))
		  				.andExpect(MockMvcResultMatchers.status().isOk());
		 assertThat(student.getFullName()).isEqualTo("Sumit");
	}
	@Test
	public void DeleteStudent()throws Exception{
		String uri="/Student/delete/3";
		Long id=3L;
		//when(studentController.DeleteStudent(id)).thenReturn(id);
		 mvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON)
				 .content(
	  				new ObjectMapper().writeValueAsString(id)))
		  				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
	
	
	
	
	
//		Student student=new Student(3L,"Rahul_Tiwari","male","8909786754");
//		student.setId(3L);
//		student.setFullName("Rahul_Tiwari");
//		student.setGender("male");
//		student.setPhoneNo("8909786754");
//		
//		String URI="/save";
//		when(repository.save(student)).thenReturn(student);
//		assertEquals(student, repository.save(student));
//		mvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON).content(
//				new ObjectMapper().writeValueAsString(response)))
//				.andExpect(MockMvcResultMatchers.status().isOk());
////		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
//		Assertions.assertEquals(student,Controller.addStudent(student).equals(student));
	


	



}
//Student student= new Student(3L, "Rahul_Tiwari", "male", "909775443");
//when(repository.save(student)).thenReturn(student);
//assertEquals(student, repository.save(student));
//MockHttpServletResponse response=mvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON).content(
//    jsonStudent.write(new Student(2L,"Sumit","male","89736328")).getJson()))
//		.andReturn().getResponse();
////response.andExpect(MockMvcResultMatchers.status().isCreated());
//.andExpect(MockMvcResultMatchers.jsonPath("$.fullName",CoreMatchers.is(repository.getFullName)))
//      assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
