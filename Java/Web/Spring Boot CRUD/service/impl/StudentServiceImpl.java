package lab8.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab8.entity.Student;
import lab8.repository.StudentRepository;
import lab8.service.StudentService;

// @Service: khi gọi các hàm trong interface StudentService thì nó sẽ tự động gọi qua các hàm override tương ứng bên dưới
// Đáng lý ra là interface StudentService sẽ không tạo được đối tượng và gọi phương thức, nhưng annotation này cho phép làm
// điều đó.
// Lưu ý: nếu có nhiều class implements interface StudentService (1 interface ánh xạ đến nhiều @Service) thì chúng ta cần chọn
// ra @Service nào được ánh xạ qua annotation @Qualifier
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	// get ra để update, delete, search
	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
		// findById(id) sẽ trả về Optional<Student>. Có nghĩa là nếu id tồn tại thì trả về có, còn không thì null
		// Nếu tồn tại thì gọi get() để lấy ra
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student); // nếu trong database đã có sẵn student có id này rồi (trùng khóa chính) 					
	} 											// thì nó sẽ tự động đề lên (update)

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}
}
