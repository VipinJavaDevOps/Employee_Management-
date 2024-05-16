package com.emp.management.employe.management.TaskController;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.emp.management.employe.management.Exception.EmptyInputException;
import com.emp.management.employe.management.Exception.RecordNotFoundException;
import com.emp.management.employe.management.TaskEntity.EmployeeEntity;
import com.emp.management.employe.management.TaskRepository.EmployeeEntityRepository;
import com.emp.management.employe.management.TaskService.EmployeeEntityService;

@RestController
public class TaskController {
	@Autowired
	private EmployeeEntityService employeeEntityService;
	@Autowired
	private EmployeeEntityRepository empRepo;
	
	//Create or Add the employee data on server or database
	
	@PostMapping("/emprecords")
	public String addEmployeeEntity( @RequestBody EmployeeEntity employeeEntity) {
		empRepo.save(employeeEntity);
			if(employeeEntity.getFirstName()==null||employeeEntity.getLastName()==null || employeeEntity.getAddress().size()==0||employeeEntity.getFirstName().isEmpty() ) {
		}
	

		return employeeEntity.getFirstName();
	}
	
	// Get the All Employee Records List 
	
	@GetMapping("/emprecords")
	//public String viewHomePage(Model model) {
		//model.addAttribute("listEmployeeEntity",employeeEntityService.getAll());
	public List<EmployeeEntity>getAllEmployeeEntity(){
           List<EmployeeEntity>emplist = new ArrayList<EmployeeEntity>();
		
		empRepo.findAll().forEach(Employee1->emplist.add(Employee1));
		if(emplist.isEmpty()) {
			throw new EmptyInputException("No Records"); 
		}
		return emplist;
		//return"home";
		
	}
	
	//Get the details of Employee by empId
	
	@GetMapping("/emprecords/{id}")
	public EmployeeEntity getEmployeeEntity(@PathVariable ("id") Long emp_id) {
		try {
		     return empRepo.findById(emp_id).get();
		}catch(Exception e) {
				 
			     throw new RecordNotFoundException("This emmployee Id is not match from database");
		}
			 	
		
	}
	
	//Update the particular employee Data 
	
	@PutMapping("/emprecords/{emp_id}")
	public EmployeeEntity updateEmployeeEntity(@RequestBody EmployeeEntity employeeEntity,Long emp_id) {
		try {
		       empRepo.save(employeeEntity);
		            return employeeEntity;
		    
		      
		}catch(IllegalArgumentException e){
	    	if(employeeEntity.getAddress().isEmpty()||employeeEntity.getFirstName().isEmpty()) {
	    	throw new EmptyInputException("please fill the value");
	    	}
	       
	    }catch(Exception e) {
	    	throw new RecordNotFoundException("invalid value");
	    }
		
	  return employeeEntity;
	}
	
	// Delete the employee Data from Server or Database
	
	@DeleteMapping("/employeerecords/{emp_id}")
	
	
	public EmployeeEntity deleteEmployeeEntity(@PathVariable long emp_id) {
		try {
		EmployeeEntity emp = empRepo.findById(emp_id).get();
		empRepo.delete(emp);
		return emp; 
		}catch(Exception e) {
			throw new RecordNotFoundException("Invalid Employee Id");
		}
		
	}
	
	//Custom JPA query Method  findByFirstName or Custom finder /derived method
	@RequestMapping("/emp/{firstName}")
	public  EmployeeEntity findByFirstName(@PathVariable String  firstName) {
		try {
		EmployeeEntity emp =empRepo.findByFirstName(firstName).getFirst();
		return emp;
		}catch(Exception e) {
			throw new RecordNotFoundException("No data belong to this first Name");
		}
	}
}

	


