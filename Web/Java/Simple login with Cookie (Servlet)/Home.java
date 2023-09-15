import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Home() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null)
		{	
			for (Cookie c : cookies)
			{
				if (c.getName().equals("username"))
				{
					writer.println("<p style=\"color: green\">Your name: Nguyen Khac Nghiem</p>");
					writer.println("<p style=\"color: green\">Your StudentID: 520H0557</p>");
					
					if(c.getValue().equals(""))
					{
						Cookie cookie = new Cookie("username", "");

						cookie.setMaxAge(0);
						resp.addCookie(cookie);
					}
				}		
			}		
		}
		else
			resp.sendRedirect("/Lab5/login");

		writer.close();
	}	
}
