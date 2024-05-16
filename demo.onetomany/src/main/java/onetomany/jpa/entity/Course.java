package onetomany.jpa.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Course_TBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Course {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String abbreviation;
	private int modules;
	private double fees;
	@ManyToMany(mappedBy="courses",fetch=FetchType.LAZY)
	
	private Set <Students>student;

}
