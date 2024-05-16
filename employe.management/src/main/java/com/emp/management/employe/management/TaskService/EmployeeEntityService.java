package com.emp.management.employe.management.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.management.employe.management.TaskEntity.EmployeeEntity;
import com.emp.management.employe.management.TaskRepository.AddressRepository;
import com.emp.management.employe.management.TaskRepository.EmployeeEntityRepository;
@Service
public class EmployeeEntityService implements TaskService {

	@Autowired
	private EmployeeEntityRepository empRepo;
	private AddressRepository addRepo;
    @Override
	public void addEmployeeEntity(EmployeeEntity employeeEntity) {
		empRepo.save(employeeEntity);
		
	}


    @Override
	public void updateEmployeeEntity(EmployeeEntity employeeEntity) {
		empRepo.save(employeeEntity);
		
	}

	@Override
	public void deleteEmployeeEntity(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeEntity getById(Long emp_id) {
		// TODO Auto-generated method stub
		return empRepo.findById(emp_id).get();
	}

	@Override
	public List<EmployeeEntity> getAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public List<EmployeeEntity> getByAdress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

}
