package com.emp.management.employe.management.TaskRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.management.employe.management.TaskEntity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
