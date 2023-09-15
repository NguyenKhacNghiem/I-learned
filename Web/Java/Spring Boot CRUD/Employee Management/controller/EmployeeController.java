package lab8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lab8.model.Employee;
import lab8.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	// Hiển thị danh sách employee
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		List<Employee> employees = es.getAllEmployee();
		model.addAttribute("employees", employees);
		
		return "index"; // Dùng đối với những trang web tĩnh (home, introduction) hoặc mới truy cập lần đầu
	}
	
	// Lưu employee vào database sau khi thêm hoặc sửa
	@PostMapping("/index")
	public String save(@ModelAttribute("employee") Employee employee, RedirectAttributes redirect) {
		es.saveEmployee(employee);
		
		// Nếu dùng return "redirect:/index" để chuyển hướng trang thì dùng cái này. 
		// Nếu dùng return "index" để hiển thị View lên thì dùng: model.addAttribute("employees", employees);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		
		// GET
		return "redirect:/index"; // Dùng khi muốn truy cập vào những trang có sự thay đổi dữ liệu. Nó khác return "index"
	} 							  // ở chỗ là thay vì hiển thị trực tiếp View lên thì nó sẽ gửi 1 HTTP request
	
	// Thêm employee
	@GetMapping("/create")
	public String create(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "form";
	}
	
	// Sửa employee
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Employee selected = es.getEmployeeById(id);
		model.addAttribute("employee", selected);
		
		return "form";
	}
	
	// Xóa employee
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		Employee selected = es.getEmployeeById(id);
		es.deleteEmployee(selected);
		
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		
		return "redirect:/index";
	}
	
	// search
	@GetMapping("/search")
	public String search(@RequestParam("key") String key, Model model) {
		if (key.equals("")) 
			return "redirect:/index";
		
		List<Employee> employees = es.searchByName(key);
		model.addAttribute("employees", employees);
		
		return "index";
	}
}