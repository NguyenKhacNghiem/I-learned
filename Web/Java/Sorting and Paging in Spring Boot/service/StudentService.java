package lab7.service;

import java.util.List;

import lab7.model.Student;

public interface StudentService {
	void addStudent(Student student);
	List<Student> getSortedStudents();
	List<Student> getPagingStudents();
}
