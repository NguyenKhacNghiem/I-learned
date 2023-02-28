<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body class="container">
	<h1>Student Update</h1>
	
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
				<input type="text" class="form-control d-none" id="id" name="id" value=<%= request.getParameter("id") %>>
				<button type="submit" class="btn btn-info">Submit</button>
				<button type="reset" class="btn btn-warning">Reset</button>
			</form>
		</div>
	</div>
</body>
</html>