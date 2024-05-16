package onetomany.jpa.reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import onetomany.jpa.entity.Course;
//import onetomany.jpa.entity.Product;
//import onetomany.jpa.entity.Student;

//import onetomany.jpa.entity.Library;
@Repository
//public interface LibraryRepository extends JpaRepository<Library,Integer> {
	
	
//public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	
	public interface CourseRepository extends JpaRepository<Course,Long>{
	
	
	List<Course>findByfeesLessThan(double fees);


}
