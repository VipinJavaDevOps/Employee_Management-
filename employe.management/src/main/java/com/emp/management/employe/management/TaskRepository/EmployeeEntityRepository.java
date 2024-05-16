package com.emp.management.employe.management.TaskRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.management.employe.management.TaskEntity.EmployeeEntity;
@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long> {
	public List<EmployeeEntity>findByFirstName(String firstName);

}
