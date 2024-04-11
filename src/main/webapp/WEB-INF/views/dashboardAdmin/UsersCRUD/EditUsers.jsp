<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paraiso Hotel | Add New User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet" href="/styles/dashboardAdmin/CRUD.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center vertical-center">
			<div class="col-lg-6 col-md-6">
				<div class="card" style="max-height: 600px; overflow-y: auto">
					<h1 class="text-center p-3">Add New User</h1>
					<div class="card-body">
						<form action="/admin/updateUser/${user.userid}" method="post">

							<div class="form-group">
								<label>Username :</label> <input type="text" name="username"
									id="username" placeholder="Enter Username" class="form-control" />
							</div>
							<div class="form-group">
								<label>Password :</label> <input type="password" name="password"
									id="password" placeholder="Enter Password" class="form-control" />
							</div>
							<div class="form-group">
								<label>Account Type :</label> <select
									class="form-select form-select-sm"
									aria-label=".form-select-sm example"
									id="account_type" name="account_type">
									<option selected>Select Account Type</option>
									<option value="User">USER</option>
									<option value="Admin">ADMIN</option>
								</select> 
							</div>
							<div class="form-group">
								<label>First Name :</label> <input type="text" name="first_name"
									id="first_name" placeholder="Enter First Name"
									class="form-control" />
							</div>
							<div class="form-group">
								<label>Last Name :</label> <input type="text" name="last_name"
									id="last_name" placeholder="Enter Last Name" class="form-control" />
							</div>
							<div class="form-group">
								<label>Date of Birth :</label> <input type="date" name="date_of_birth"
									id="date_of_birth" placeholder="Enter Birthday" class="form-control" />
							</div>
							<div class="form-group">
								<label>Address :</label> <input type="text" name="address"
									id="address" placeholder="Enter Address"
									class="form-control" />
							</div>
							<div class="form-group">
								<label>Phone Number :</label> <input type="number" name="phone"
									id="phone" placeholder="Enter Phone Number" class="form-control" />
							</div>
							<div class="form-group">
								<label>Email :</label> <input type="email" name="email"
									id="email" placeholder="Enter Email" class="form-control" />
							</div>
							<div class="box-footer">
								<a type="button" href="/admin/AdminUsers"
									class="btn btn-danger float-end m-3">Back</a> <input
									type="submit" class="btn btn-success float-end m-3"
									value="Submit">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>