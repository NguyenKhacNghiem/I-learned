<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="pojo.Student" %>
<%@ page import="utils.HibernateUtils" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body class="container">
	<h1>Student Registation System CRUD using JSP</h1>
	
	<div class="row">
		<div class="col-6">
			<form action="StudentServlet" method="post">
				<div class="form-group">
					<label for="name">Student Name</label>
					<input type="text" class="form-control" id="name" name="name">
				</div>
				<div class="form-group">
					<label for="course">Course</label>
					<input type="text" class="form-control" id="course" name="course">
				</div>
				<div class="form-group">
					<label for="fee">Fee</label>
					<input type="text" class="form-control" id="fee" name="fee">
				</div>
				<button type="submit" class="btn btn-info">Submit</button>
				<button type="reset" class="btn btn-warning">Reset</button>
			</form>
		</div>
		
		<div class="col-6">
			<table class="table table-bordered text-center">
				<tr>
					<th>Student Name</th>
					<th>Course</th>
					<th>Fee</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				
				<%
					Query query = HibernateUtils.getFactory().openSession().createQuery("FROM Student");
					List<Student> students = query.getResultList();
												
					if(students != null) {
						for(Student s : students) { 
				%>
							<tr>
								<td><%= s.getName() %></td>
								<td><%= s.getCourse() %></td>
								<td><%= s.getFee() %></td>
								<td><a href="update.jsp?id=<%= s.getId() %>">Update</a></td>
								<td><a href="StudentServlet?id=<%= s.getId() %>">Delete</a></td>
							</tr>
				<%
						}	
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>