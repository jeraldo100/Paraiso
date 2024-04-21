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
<link rel="icon" type="image/png" sizes="16x16 32x32" href="/images/logo/paraisologo2.png">

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
			<div class="col overflow-hidden">
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
														<th>Room ID</th>
														<th>Hotel ID</th>
														<th>Type</th>
														<th>Status</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="rooms" items="${rooms }">
														<tr>
															<td><c:out value="${rooms.room_id }" /></td>
															<td><c:out value="${rooms.hotel_id }" /></td>
															<td><c:out value="${rooms.type_id }" /></td>
															<td><c:out value="${rooms.status }" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div
									class="d-flex align-items-center justify-content-between mb-3">
									<h3>Room Type</h3>
								</div>
								<div class="row mb-4">
									<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 300px; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Room Type ID</th>
														<th>Name</th>
														<th>Description</th>
														<th>Capacity</th>
														<th>Beds</th>
														<th>Bathrooms</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="roomTypes" items="${roomTypes }">
														<tr>
															<td><c:out value="${roomTypes.type_id }" /></td>
															<td><c:out value="${roomTypes.name }" /></td>
															<td><c:out value="${roomTypes.description }" /></td>
															<td><c:out value="${roomTypes.capacity }" /></td>
															<td><c:out value="${roomTypes.beds }" /></td>
															<td><c:out value="${roomTypes.bathrooms }" /></td>
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
														<th>Voucher ID</th>
														<th>Voucher Code</th>
														<th>Description</th>
														<th>Amount</th>
														<th>Validity</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="voucher" items="${voucher }">
														<tr>
															<td><c:out value="${voucher.voucher_id }" /></td>
															<td><c:out value="${voucher.voucher_code }" /></td>
															<td><c:out value="${voucher.description }" /></td>
															<td><c:out value="${voucher.amount }" /></td>
															<td><c:out value="${voucher.validation }" /></td>
														</tr>
													</c:forEach>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div
									class="d-flex align-items-center justify-content-between mb-3">
									<h3>Add Ons</h3>
								</div>
								<div class="row mb-4">
									<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 300px; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Add Ons ID</th>
														<th>Name</th>
														<th>Description</th>
														<th>Amount</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="addOns" items="${addOns }">
														<tr>
															<td><c:out value="${addOns.add_on_id }" /></td>
															<td><c:out value="${addOns.add_on_name }" /></td>
															<td><c:out value="${addOns.description }" /></td>
															<td><c:out value="${addOns.amount }" /></td>
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


</body>


<!-- IONICONS LINK -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</html>