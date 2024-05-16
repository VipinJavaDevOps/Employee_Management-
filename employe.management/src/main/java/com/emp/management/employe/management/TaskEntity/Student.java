package com.emp.management.employe.management.TaskEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long id;
	private String fullName;
	private  String gender;
	private String phoneNo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Student(long id, String fullName, String gender, String phoneNo) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.phoneNo = phoneNo;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
