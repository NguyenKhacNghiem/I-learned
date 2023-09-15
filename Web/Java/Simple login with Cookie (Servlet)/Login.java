import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer =resp.getWriter();
		
		writer.println("<h1 style=\"text-align: center;margin-top: 8%;color: blue\">LOGIN</h1>");
		writer.println("<form style=\"margin-left: 40%;\" action=\"/Lab5/login\" method=\"post\">");
		writer.println("Username: <input type=\"text\" name=\"username\"><br>");
		writer.println("Password : <input type=\"password\" name=\"password\"><br>");
		writer.println("<input style=\"margin-left: 10%;margin-top: 5px\" type=\"checkbox\" name=\"remember\"> Remember me <br>");
		writer.println("<button style=\"margin-left: 10%;margin-top: 5px\" type=\"submit\">Login</button>");
		writer.println("</form>");
		
		writer.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		if(username.equals("admin") && password.equals("123456"))
		{
			Cookie cookie;
			
			if (remember != null && remember.equals("on")) 
				cookie = new Cookie("username", username);
			else
				cookie = new Cookie("username", "");
			
			cookie.setMaxAge(14);
			resp.addCookie(cookie);
			
			resp.sendRedirect("/Lab5/home");
		}
		else
			resp.sendRedirect("/Lab5/login");
			
		writer.close();
	}	
}
