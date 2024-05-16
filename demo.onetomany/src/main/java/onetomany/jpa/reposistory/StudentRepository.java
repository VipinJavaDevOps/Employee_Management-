package onetomany.jpa.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import onetomany.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer > {

}
