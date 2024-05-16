package onetomany.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name= "book_details")
public class Library {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int book_id;
	private String book_name;
	private String book_author;
	@OneToOne(cascade=CascadeType.ALL)
	//@OneToOne(mappedBy="book_details")
	private Student student;
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Library(String book_name, String book_author) {
		super();
		this.book_name = book_name;
		this.book_author = book_author;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	@Override
	public String toString() {
		return "Library [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author + "]";
	}
	
	
	

}
