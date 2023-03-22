package lab8.service;

import java.util.List;

import lab8.entity.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	
	public Student getStudentById(Long id);
	
	public Student saveStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public void deleteStudentById(Long id);
}
