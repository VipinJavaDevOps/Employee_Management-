package com.emp.management.employe.management.TaskRepository;

import org.springframework.data.repository.CrudRepository;

import com.emp.management.employe.management.TaskEntity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
