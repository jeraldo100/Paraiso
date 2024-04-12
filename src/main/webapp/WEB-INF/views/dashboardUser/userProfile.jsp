<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Paraiso Hotel Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet" href="/styles/dashboardUser/userProfile.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- Main Content -->

			<div class="col">
				<div class="container-fluid" id="main-content">
					<div class="row">
						<div class="col-lg-15 ms-auto p-4 overflow-hidden">
							<table class="table" id="bookingList">
								<tbody>
									<tr>
										<td><h1 class="display-3">Welcome, ${user.username}!</h1></td>
									</tr>
								</tbody>
							</table>
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<h1>Profile</h1>
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">
									<a href="/user/editProfile" type="button"
										class="btn btn-success m-1"> Edit </a>
								</div>
							</div>

							<div class="card border-0">
								<div class="card-body">
									<table class="table table-hover" id="bookingList">
										<thead>

										</thead>
										<tbody>
											<tr>
												<th>User ID:</th>
												<td class="text-center">${user.userid}</td>
											</tr>
											<tr>

												<th>Username:</th>
												<td class="text-center">${user.username}</td>

											</tr>
											<tr>
												<th>First Name:</th>
												<td class="text-center">${user.firstName}</td>


											</tr>
											<tr>
												<th>Last Name:</th>
												<td class="text-center">${user.lastName}</td>


											</tr>
											<tr>
												<th>Date of Birth:</th>
												<td class="text-center">${fn:substring(user.dateOfBirth,0,10)}</td>


											</tr>
											<tr>
												<th>Address:</th>
												<td class="text-center">${user.address}</td>


											</tr>
											<tr>
												<th>Phone:</th>
												<td class="text-center">${user.phone}</td>


											</tr>
											<tr>
												<th>Email:</th>
												<td class="text-center">${user.email}</td>


											</tr>

										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</html>
