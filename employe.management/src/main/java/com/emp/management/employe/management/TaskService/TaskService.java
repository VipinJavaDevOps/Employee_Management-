package com.emp.management.employe.management.TaskService;
import java.util.List;

import com.emp.management.employe.management.TaskEntity.*;
public interface TaskService {
	void addEmployeeEntity(EmployeeEntity employeeEntity);
	void updateEmployeeEntity(EmployeeEntity employeeEntity);
	void deleteEmployeeEntity(EmployeeEntity employeeEntity);
	
	EmployeeEntity getById(Long emp_id);
	List<EmployeeEntity> getAll();
	List<EmployeeEntity>getByAdress(String address );

	
}
