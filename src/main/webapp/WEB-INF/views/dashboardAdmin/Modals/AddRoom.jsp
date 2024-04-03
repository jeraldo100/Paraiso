<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 container	justify-content-center card">
				<h1>Register New User</h1>
				<div class="card-body">
					<form action="addRoom/save" method="post">
						<div class="form-group">
							<label>Room ID :</label>
							<input type="text" name="room_id" id="room_id" placeholder="Enter Room ID" />
						</div>
						<div class="form-group">
							<label>Hotel ID :</label>
							<input type="text" name="hotel_id" id="hotel_id" placeholder="Enter Hotel ID" />
						</div>
						<div class="form-group">
							<label>Type ID :</label>
							<input type="text" name="type_id" id="type_id" placeholder="Enter Type ID" />
						</div>
						<div class="form-group">
							<label>Status :</label>
							<input type="text" name="status" id="status" placeholder="Enter Status" />
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