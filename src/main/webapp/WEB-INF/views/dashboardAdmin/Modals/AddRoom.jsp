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
<!-- 	<form action="addroom/save" method="POST">
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Room
				ID</span> <input type="text" class="form-control rounded-end"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" name="room_id" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Hotel
				ID </span> <input type="number" class="form-control rounded-end"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" name="hotel_id" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Type
				ID </span> <input type="number" class="form-control rounded-end"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" name="type_id" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Status
				per night</span> <input type="number" class="form-control rounded-end"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" name="status" />
		</div>
		<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">Description</span>
											<input type="text" class="form-control rounded-end"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" />
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">Capacity</span>
											<input type="number" class="form-control rounded-end"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" />
										</div>
										<div class="input-group mb-3">
											<span class="input-group-text" id="inputGroup-sizing-default">Status</span>
											<input type="text" class="form-control rounded-end"
												aria-label="Sizing example input"
												aria-describedby="inputGroup-sizing-default" />
										</div>
		<div class="modal-footer">
			<p>Save changes?</p>
			<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
			<button type="button" class="btn btn-success" value="submit">Yes</button>
		</div>
	</form> -->
	
<!-- 	<div class="container">
		<div class="row">
			<div class = "col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
				<h1 class="text-center">HAHAHAHA</h1>
				<div class="card-body">
					<form action="/addroom/save" method="POST">
    <div class="form-group">
        <label>Room ID</label>
        <input type="number" name="room_id" class="form-control" required/>
    </div>
    <div class="form-group">
        <label>Hotel ID</label>
        <input type="number" name="hotel_id" class="form-control" required/>
    </div>
    <div class="form-group">
        <label>Type ID</label>
        <input type="number" name="type_id" class="form-control" required/>
    </div>
    <div class="form-group">
        <label>Status</label>
        <input type="text" name="status" class="form-control" required/>
    </div>
    <div class="box-footer">
        <button type="submit" class="btn btn-success">Submit</button>
    </div>
</form>
				</div>
			</div>
		</div>
	</div> -->
	
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 container	justify-content-center card">
				<h1>Register New User</h1>
				<div class="card-body">
					<form action="adduser/save" method="post">
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