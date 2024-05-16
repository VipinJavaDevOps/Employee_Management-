package onetomany.jpa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onetomany.jpa.entity.Customer;
import onetomany.jpa.reposistory.CustomerRepository;
import onetomany.jpa.reposistory.ProductRepository;
@RestController
@RequestMapping("/customer/prod")

public class CustomerProductController {
	@Autowired
	private CustomerRepository customerRepository;
	private ProductRepository productRepository;



	public CustomerProductController(CustomerRepository customerrepository,ProductRepository productRepository) {
		this.customerRepository=customerRepository;
		this.productRepository=productRepository;
	}
		@PostMapping("/customer/prod")
		public ResponseEntity<String>saveCustomer(@RequestBody List<Customer>customerData){
				//public ResponseEntity<String>saveStudent(@RequestBody List<Student>studentData){
			customerRepository.saveAll(customerData);
			return ResponseEntity.ok("Data saved");
	}

}
