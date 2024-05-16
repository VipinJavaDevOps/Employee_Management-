package com.emp.management.employe.management.TaskRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.management.employe.management.TaskEntity.Address;
import com.emp.management.employe.management.TaskEntity.EmployeeEntity;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	
}
