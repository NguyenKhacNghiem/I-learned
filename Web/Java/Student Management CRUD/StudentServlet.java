package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import pojo.Student;
import utils.HibernateUtils;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentServlet() {
        super();
    }
	
	// Used to delete
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Session session = HibernateUtils.getFactory().openSession();
				
		Student student = session.get(Student.class, id);
		
		session.getTransaction().begin(); 
		session.delete(student);
		session.getTransaction().commit(); 
				
		session.close();
		response.sendRedirect("index.jsp");
	}
	
	// Used to add and update
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtils.getFactory().openSession();
		Student student = null;
		
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		int fee = Integer.valueOf(request.getParameter("fee"));
		String id = request.getParameter("id");
		
		if(id == null) // id is not founded -> add
		{
			student = new Student();
			
			student.setName(name);
			student.setCourse(course);
			student.setFee(fee);
			
			session.save(student);
		}
		else // id is founded -> update (by id)
		{
			student = session.get(Student.class, Integer.parseInt(id));
			
			student.setName(name);
			student.setCourse(course);
			student.setFee(fee);
			
			session.getTransaction().begin();
			session.save(student);
			session.getTransaction().commit();
		}
		
		session.close();
		response.sendRedirect("index.jsp");
	}
}
