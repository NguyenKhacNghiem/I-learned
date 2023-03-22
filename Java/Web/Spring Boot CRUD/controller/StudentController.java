package lab8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lab8.service.StudentService;
import lab8.entity.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// Đọc danh sách students
	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		
		model.addAttribute("students", students);
		
		return "students";
	}
	
	// Thêm 1 student vào ds
	// @ModelAttribute("student"): lấy thông tin của object "student" gửi lên từ form gán vào parameter
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		
		return "redirect:/students"; // GET
	}
	
	// Xóa 1 student
	// @PathVariable: lấy id từ đường dẫn gán vào Parameter
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		
		return "redirect:/students"; // GET
	}
	
	// Sửa 1 student
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student selectedStudent = studentService.getStudentById(id);
		
		selectedStudent.setFirstName(student.getFirstName());
		selectedStudent.setLastName(student.getLastName());
		selectedStudent.setEmail(student.getEmail());

		studentService.updateStudent(selectedStudent);
		
		return "redirect:/students";
	}
	
	// Hiển thị view create_student (form thêm student)
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// tạo ra object student để gửi qua form th:object
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "create_student";
	}
	
	// Hiển thị view edit_student (form sửa student)
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		Student selectedStudent = studentService.getStudentById(id);
		
		model.addAttribute("student", selectedStudent);
		
		return "edit_student";
	}
}
