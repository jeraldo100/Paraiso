<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
var contextPath = '${pageContext.request.contextPath}' + '/';
</script>
</head>
<body>
	<div id="mainDiv" class="container">
		<div class="row"> 
			<h1>User List</h1>
		</div>
		<div class="row"> 
			<div class = "col-lg-3 my-3">
				<a href="adduser" class="btn btn-primary">Add User</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-striped">
					<thead class="table-dark">
						<tr>
							<th scope="col" class="col-2">User ID</th>
							<th scope="col" class="col-4">Username</th>
							<th scope="col" class="col-4">Password</th>
							<th scope="col" class="col-2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td><c:out value="${user.userid}" /></td>
								<td><c:out value="${user.username}" /></td>
								<td><c:out value="${user.password}" /></td>
								<td>
									<a href="edit/${user.userid}" class="btn btn-primary">Update</a>
									
									<a href="delete/${user.userid}" class="btn btn-danger">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<input id="btnLoadUsers" type="button" value="Load user"/>
</body>
<script type="text/javascript">


$(document).ready(function(){
	
	$("#btnLoadUsers").click(function(){
		$.ajax({
			url: contextPath + "user/",
			method: "GET",
			success: function(result){
				$("#mainDiv").html(result);
			}
		})
	});
	//loadUsers();
});
</script>
</html>