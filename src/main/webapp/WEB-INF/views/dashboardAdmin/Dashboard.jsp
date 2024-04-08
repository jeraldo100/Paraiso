<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Paraiso Hotel Dashboard</title>

<!-- BOOTSTRAP LINK -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<!-- CSS LINK -->

<link rel="stylesheet" href="/styles/dashboardAdmin/dashboard.css">
</head>

<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- Main Content -->
			<div class="col">
				<div>
					<div class="container-fluid" id="main-content">
						<div class="row">
							<div class="col-lg-15 ms-auto p-4 overflow-hidden">
								<h1 class="display-3">Good morning, Admin!</h1>
								<hr />
								<div
									class="d-flex align-items-center justify-content-between mb-4">
									<h1>Dashboard</h1>
								</div>
								<div class="row mb-4">
									
									<div class="col-md b-4">
										<a href="#" class="text-decoration-none">
											<div class="card text-center p-3 text-success">
												<h6 class="pt-3">Bookings</h6>
												<h1><%= request.getAttribute("totalBooking") %></h1>
											</div>
										</a>
									</div>
									<div class="col-md b-4">
										<a href="#" class="text-decoration-none">
											<div class="card text-center p-3 text-success">
												<h6 class="pt-3">Revenue</h6>
												<h1><%= request.getAttribute("totalPrice") %></h1>
											</div>
										</a>
									</div>
								</div>
								<div
									class="d-flex align-items-center justify-content-between mb-3">
									<h3>Bookings</h3>
								</div>
								<div class="row mb-4">
									<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 300px; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Booking ID</th>
														<th>User ID</th>
														<th>Room ID</th>
														<th>Check In</th>
														<th>Check Out</th>
														<th>Total Price</th>
														<th>Arrival Time</th>
														<th>Adults</th>
														<th>Children</th>
														<th>Status</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="bookings" items="${bookings }">
														<tr>
															<td><c:out value="${bookings.booking_id }" /></td>
															<td><c:out value="${bookings.user_id }" /></td>
															<td><c:out value="${bookings.booking_id }" /></td>
															<td><c:out value="${bookings.checkin_date }" /></td>
															<td><c:out value="${bookings.checkout_date }" /></td>
															<td><c:out value="${bookings.total_price }" /></td>
															<td><c:out value="${bookings.arrival_time }" /></td>
															<td><c:out value="${bookings.adults }" /></td>
															<td><c:out value="${bookings.children }" /></td>
															<td><c:out value="${bookings.status }" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div
									class="d-flex align-items-center justify-content-between mb-3">
									<h3>Users</h3>
								</div>
								<div class="row mb-4">
									<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 300px; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th></th>
														<th>User ID</th>
														<th>Username</th>
														<th>Password</th>
														<th>Account Type</th>
														<th>First Name</th>
														<th>Last Name</th>
														<th>Date of Birth</th>
														<th>Address</th>
														<th>Phone</th>
														<th>Email</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="users" items="${users }">
														<tr>
															<td><c:out value="${users.userid }" /></td>
															<td><c:out value="${users.username }" /></td>
															<td><c:out value="${fn:substring(users.password, 0, 6)}" /></td>
															<td><c:out value="${users.accountType }" /></td>
															<td><c:out value="${users.firstName }" /></td>
															<td><c:out value="${users.lastName }" /></td>
															<td><c:out value="${users.dateOfBirth }" /></td>
															<td><c:out value="${users.address }" /></td>
															<td><c:out value="${users.phone }" /></td>
															<td><c:out value="${users.email }" /></td>
														</tr>
													</c:forEach>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div
									class="d-flex align-items-center justify-content-between mb-3">
									<h3>Rooms</h3>
								</div>
								<div class="row mb-4">
									<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 300px; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th></th>
														<th>Room ID</th>
														<th>Hotel ID</th>
														<th>Type</th>
														<th>Status</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="rooms" items="${room }">
														<tr>
															<td><input type="checkbox" /></td>
															<td><c:out value="${room.room_id }" /></td>
															<td><c:out value="${room.hotel_id }" /></td>
															<td><c:out value="${room.type_id }" /></td>
															<td><c:out value="${room.status }" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div
									class="d-flex align-items-center justify-content-between mb-3">
									<h3>Vouchers</h3>
								</div>
								<div class="row mb-4">
									<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 300px; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th></th>
														<th>Voucher ID</th>
														<th>Voucher Code</th>
														<th>Description</th>
														<th>Amount</th>
														<th>Validity</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="vouchers" items="${vouchers }">
														<tr>
															<td><input type="checkbox" /></td>
															<td><c:out value="${vouchers.voucher_id }" /></td>
															<td><c:out value="${vouchers.voucher_code }" /></td>
															<td><c:out value="${vouchers.description }" /></td>
															<td><c:out value="${vouchers.amount }" /></td>
															<td><c:out value="${vouchers.validation }" /></td>
															<td>
																<button type="button" class="btn btn-success">
																	Edit</button>
																<button type="button" class="btn btn-danger">
																	Delete</button>
															</td>
														</tr>
													</c:forEach>

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
		</div>
	</div>

	<!-- <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script> -->

</body>

<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
  integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
  integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script> -->

<!-- IONICONS LINK -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</html>