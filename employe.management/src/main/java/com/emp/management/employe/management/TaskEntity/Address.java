package com.emp.management.employe.management.TaskEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Getter
@Setter
public class Address {
 
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id  
	@GeneratedValue
	private Long id;
	@NotNull
	private String town;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	@Valid
	private int pinCode;
//	@ManyToOne(cascade=CascadeType.ALL)
//	 private EmployeeEntity employeeEntity;
//	   public Address(){}
	

	public Long getId() {
		return id;
	}
	public Address(Long id, String town, String city, String state, int pinCode) {
	super();
	this.id = id;
	this.town = town;
	this.city = city;
	this.state = state;
	this.pinCode = pinCode;
}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	
}
