package lab7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lab7.model.Student;
import lab7.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
	@Autowired
	private StudentRepository sr;
		
	@Override
	public void addStudent(Student student) {
		sr.save(student);
	}
	
	// Sắp xếp danh sách sinh viên theo tứ tự giảm dần của tuổi.
	// Nếu bằng tuổi thì sắp xếp tăng dần theo điểm ielts
	@Override
	public List<Student> getSortedStudents() {
		return sr.findAll(Sort.by("age").descending().and(Sort.by("ielts").ascending()));
	}
	
	// Phân trang kết quả trả về
	@Override
	public List<Student> getPagingStudents() {
		// Lấy ra trang đầu tiên (trang 0) gồm 10 students, được sắp xếp... 
		Pageable pageable = PageRequest.of(0, 10, Sort.by("age").descending().and(Sort.by("ielts").ascending()));
		
		Page<Student> students = sr.findAll(pageable);
		
		// Lấy ra danh sách con từ index 4 đến index 7-1 (index bắt đầu từ 0)
		return students.getContent().subList(4, 7);
	}
}
