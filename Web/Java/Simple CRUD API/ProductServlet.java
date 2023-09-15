package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Product;

@WebServlet("/ProductService")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Product> list; 

	public ProductServlet() {
        super();
        
		// Create sample data
        list = new ArrayList<>();
        list.add(new Product(1, "Milk", 10000));
        list.add(new Product(2, "Chocolate", 90000));
        list.add(new Product(3, "Candy", 15000));
    }
	
	// Used to read and search
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Support Vietnamese (UTF-8)
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ObjectMapper objectMapper = new ObjectMapper();  // ObjectMapper is a class of Jackson library to transfer data to JSON
		PrintWriter out = response.getWriter();
		
		String json = "";
		String jsonProducts = "";
		String id = request.getParameter("id");
		
		if(id == null)  // read
		{
			jsonProducts = objectMapper.writeValueAsString(list); // transfer a list to JSON
			json = "{\"code\": 0, "
					+ "\"message\": \"Read product list success\"" 
					+ ", \"data\": " + jsonProducts + "}";
		}
		else // search
		{
			// Find product whose id = id
			Product product = list.stream()
								  .filter(p -> p.getId() == Integer.parseInt(id))
								  .findFirst()
								  .orElse(null);
			if(product != null)  // found
			{
				jsonProducts = objectMapper.writeValueAsString(product); // transfer a object to JSON
				json = "{\"code\": 1, "
						+ "\"message\": \"Read a product success\"" 
						+ ", \"data\": " + jsonProducts + "}";
			}
			else // not found
				json = "{\"code\": 2, \"message\": \"Product not found\"}"; 
		}
			
		out.write(json);
		out.flush(); // should be use to write all json data to browser
	}
	
	// Used to add
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		PrintWriter out = response.getWriter();
		String json = "";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		if(id == null || id == "" || 
		   name == null || name == "" || 
		   price == null || price == "")
			json = "{\"code\": 3, \"message\": \"Please enter all information\"}";
		else
		{
			int i, p;
			
			try
			{
				i = Integer.parseInt(id);
				p = Integer.parseInt(price);
			} catch(Exception e)
			{
				json = "{\"code\": 4, \"message\": \"id and price must be numeric values\"}";
				
				out.write(json);
				out.flush();
				
				return;
			}
			
			Product product = list.stream()
								  .filter(k -> k.getId() == i)
								  .findFirst()
								  .orElse(null);
			
			if(product == null) // id is not exists -> add
			{
				product = new Product(i, name, p);
				String jsonProduct = objectMapper.writeValueAsString(product);
				
				json = "{\"code\": 5, "
						+ "\"message\": \"Add a product success\"" 
						+ ", \"data\": " + jsonProduct + "}";
				
				list.add(product);
			}
			else // id is already exists -> not add
				json = "{\"code\": 6, \"message\": \"id is already exists\"}";
		}
		
		out.write(json);
		out.flush();
	}
	
	// Used to edit
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		PrintWriter out = response.getWriter();
		String json = "";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		if(id == null || id == "" || 
		   name == null || name == "" || 
		   price == null || price == "")
			json = "{\"code\": 3, \"message\": \"Please enter all information\"}";
		else
		{
			int i, p;
			
			try
			{
				i = Integer.parseInt(id);
				p = Integer.parseInt(price);
			} catch(Exception e)
			{
				json = "{\"code\": 4, \"message\": \"id and price must be numeric values\"}";
				
				out.write(json);
				out.flush();
				
				return;
			}
			
			for(Product product : list)
				if(product.getId() == i) // found product -> update
				{
					// edit data
					product.setName(name);
					product.setPrice(p);
					
					String jsonProduct = objectMapper.writeValueAsString(product);
					json = "{\"code\": 7, "
							+ "\"message\": \"Update a product success\"" 
							+ ", \"data\": " + jsonProduct + "}";
					
					out.write(json);
					out.flush();
					return;
				}
			
			json = "{\"code\": 2, \"message\": \"Product not found\"}";
		}
		out.write(json);
		out.flush();
	}
	
	// Used to delete
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		PrintWriter out = response.getWriter();
		
		String json = "";
		String id = request.getParameter("id");
		
		if(id == null || id == "") 
			json = "{\"code\": 3, \"message\": \"Please enter all information\"}";
		else 
		{
			for(int i=0;i<list.size();i++)
				if(list.get(i).getId() == Integer.parseInt(id))
				{
					String jsonProduct = objectMapper.writeValueAsString(list.get(i));
					json = "{\"code\": 8, "
							+ "\"message\": \"Delete a product success\"" 
							+ ", \"data\": " + jsonProduct + "}";
					
					list.remove(i);
					
					out.write(json);
					out.flush();
					return;
				}
			
			json = "{\"code\": 2, \"message\": \"Product not found\"}";
		}	 
		
		out.write(json);
		out.flush();
	}
}