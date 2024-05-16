package onetomany.jpa.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import onetomany.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>  {

}
