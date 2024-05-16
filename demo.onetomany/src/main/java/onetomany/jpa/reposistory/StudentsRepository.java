package onetomany.jpa.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import onetomany.jpa.entity.Customer;
import onetomany.jpa.entity.Students;
//import onetomany.jpa.entity.Student;
@Repository
//public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	public interface StudentsRepository extends JpaRepository<Students,Long>{
	
	
	List<Students>findByNameContaining(String name);


}
