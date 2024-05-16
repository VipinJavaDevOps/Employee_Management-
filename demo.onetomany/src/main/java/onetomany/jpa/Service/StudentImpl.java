/*package onetomany.jpa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onetomany.jpa.entity.Student;
import onetomany.jpa.reposistory.StudentRepository;
@Service
public class StudentImpl implements StudentService {
	private StudentRepository studentRepository;
	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void updateStudent(Student student) {
	
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getById(int student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByDeparment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/