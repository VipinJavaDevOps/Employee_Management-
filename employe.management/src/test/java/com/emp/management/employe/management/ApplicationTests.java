package com.emp.management.employe.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.emp.management.employe.management.TaskController.TaskController;
import com.emp.management.employe.management.TaskController.UserController;
import com.emp.management.employe.management.TaskEntity.EmployeeEntity;
import com.emp.management.employe.management.TaskEntity.User;
import com.emp.management.employe.management.TaskRepository.EmployeeEntityRepository;
import com.emp.management.employe.management.TaskRepository.UserRepository;
import com.itextpdf.text.List;

@SpringBootTest

class ApplicationTests {

//	@Autowired
//	private TaskController Controller;
//	@MockBean    
//	private EmployeeEntityRepository empRepo;
//
//
	@Test
	void contextLoads() {
	}
//	@Test
//	public void getAllEmployeeEntityTest() throws Exception {
//	   // when(Controller.getAllEmployeeEntity()).thenReturn(Stream.of(new EmployeeEntity(903L, "rohan", "dubey", "75593",202L,"dhwd", "hddueu", "ncjn", "363445"),new EmployeeEntity(1202L, "Sumit", "tripathi", "75536744", 203L, "dhed","hdeueu",  "ncjen","365578")).collect(Collectors.toList()));
//         assertEquals("[]",empRepo.findAll());
//		
//		
//	}
//	@Test
//	void addEmployeeEntityTest() throws Exception {
//		EmployeeEntity employeeEntity=new EmployeeEntity(2L, "rohan", "dubey", "9080709080",3L,"tahsil","fzd","up","787767");
//		when(empRepo.save(employeeEntity)).thenReturn(employeeEntity);
//		assertEquals(0,Controller.addEmployeeEntity(employeeEntity));
//		
//	}
//	
//
}
