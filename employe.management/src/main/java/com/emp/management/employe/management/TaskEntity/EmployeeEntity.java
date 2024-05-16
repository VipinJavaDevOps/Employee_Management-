package com.emp.management.employe.management.TaskEntity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Employee_Records")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	public EmployeeEntity(Long empId) {
		super();
		this.empId = empId;
	}


	@Column
	@jakarta.validation.constraints.NotNull
	private String firstName;
	@jakarta.validation.constraints.NotNull
	private String lastName;
    @Size(min = 10,max=10)
	private String phoneNo;

	
	
	@OneToMany(targetEntity  = Address.class,cascade  = CascadeType.ALL)
	@JoinColumn(name="employee_add",referencedColumnName = "empId")
	private List<Address>address = new ArrayList<>();
	public EmployeeEntity() {
	}	
	
	





	public EmployeeEntity(Long empId, String firstName, String lastName, String phoneNo, List<Address> address) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
	}
   public EmployeeEntity(Long empId, @NotNull String firstName, @NotNull String lastName,
			@Size(min = 10, max = 10) String phoneNo) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}





	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}















	
	


	
}
