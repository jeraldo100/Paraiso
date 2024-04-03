<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Module</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 container	justify-content-center card">
				<h1>Update User</h1>
				<div class="card-body">
					<form action="update/${user.userid}" method="post">
						<div class="form-group">
							<label>Username :</label>
							<input type="text" name="username" id="username" value="${user.username}" placeholder="Enter username" />
						</div>
						<div class="form-group">
							<label>Password :</label>
							<input type="text" name="password" id="password" value="${user.password}" placeholder="Enter password" />
						</div>
						<div class = "box-footer">
							<input type="submit" class="btn btn-primary" value="Submit">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>