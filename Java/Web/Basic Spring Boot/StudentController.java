package tdtu.lab7.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import tdtu.lab7.form.StudentForm;
import tdtu.lab7.model.Student;

@Controller 
public class StudentController 
{
	private List<Student> students = new ArrayList<>();
	
	// Lay value cua key error.message trong file application.properties gan vao bien errorMessage
	@Value("${error.message}") 
	private String errorMessage;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String showStudentList(Model model, HttpServletRequest request) // Model de dua du lieu tu Controller qua View
	{	
		String parameter = request.getParameter("id");
		
		if(parameter != null)
			for(int i=0;i<students.size();i++)
				if(students.get(i).getId() == Integer.parseInt(parameter))
					students.remove(i);
		
		StudentForm studentForm = new StudentForm();
		model.addAttribute("studentForm", studentForm); // dua doi tuong studentForm nay xuong method POST ben duoi (nho dung ten)
				
		model.addAttribute("students", students); // dua du lieu tu Controller qua View
		
		return "studentView"; // tra ve View co ten "studentView" (show View nay len browser)
	}
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.POST)
	public String addStudent(Model model, @ModelAttribute StudentForm studentForm) 
	{
		// @ModelAttribute dai dien cho doi tuong se nhan du lieu tu form gui len
		String firstname = studentForm.getFirstname();
		String lastname = studentForm.getLastname();
		String email = studentForm.getEmail();

		if (firstname != null && firstname.length() > 0 
			&& lastname != null && lastname.length() > 0
			&& email != null && email.length() > 0) 
		{
			
			Student s = new Student(students.size()+1, firstname, lastname, email);
			
			students.add(s);
						
			return "redirect:/index"; // goi lai trang bang phuong thuc GET
		}

		model.addAttribute("errorMessage", errorMessage);
		
		return "studentView";
	}
}
