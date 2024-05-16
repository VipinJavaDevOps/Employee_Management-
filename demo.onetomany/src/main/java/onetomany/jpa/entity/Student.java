package onetomany.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@Transactional
@Data
@NoArgsConstructor
@Entity
@Table(name = "Student_details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="S_id")
	private int S_id;
	private String S_name;
	private String S_deparment;


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_book_id")
	
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="f__book_id",referencedColumnName="S_id")
	 private Library library;

	
	
	public int getS_id() {
		return S_id;
	}



	public void setS_id(int s_id) {
		S_id = s_id;
	}



	public String getS_name() {
		return S_name;
	}



	public void setS_name(String s_name) {
		S_name = s_name;
	}



	public String getS_deparment() {
		return S_deparment;
	}



	public void setS_deparment(String s_deparment) {
		S_deparment = s_deparment;
	}



	public Library getLibrary() {
		return library;
	}



	public void setLibrary(Library library) {
		this.library = library;
	}



	public Student(String s_name, String s_deparment, Library library) {
		super();
		S_name = s_name;
		S_deparment = s_deparment;
		this.library = library;
	}



	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}
