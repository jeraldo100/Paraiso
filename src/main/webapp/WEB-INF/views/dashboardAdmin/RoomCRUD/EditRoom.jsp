<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Room</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
</head>
<body>
	<div class="col-lg-6 col-md-6 container 	justify-content-center card">
		<h1>Edit Room</h1>
		<div class="card-body">
			<form action="/update/${room.room_id}" method="post">
				<div class="form-group">
					<label>Hotel ID :</label> <input type="text" name="hotel_id"
						id="hotel_id" value="1" readonly placeholder="Enter Hotel ID" />
				</div>
				<div class="form-group">
					<label>Type ID :</label> <input type="text" name="type_id"
						id="type_id" placeholder="Enter Type ID" />
				</div>
				<div class="form-group">
					<label>Status :</label> <input type="text" name="status"
						id="status" placeholder="Enter Status" />
				</div>
				<div class="box-footer">
					<input type="submit" class="btn btn-success" value="Submit">
				</div>
			</form>
		</div>
	</div>
</body>
</html>