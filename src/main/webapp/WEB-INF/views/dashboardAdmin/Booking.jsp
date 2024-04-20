<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Paraiso Hotel Dashboard</title>

<!--BOOTSTRAP LINK-->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<link rel="icon" href="/images/logo/logoo.png" sizes="any"
	type="image/png">

<!-- CSS LINK -->

<link rel="stylesheet" href="/styles/dashboardAdmin/dashboard.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="//cdn.datatables.net/2.0.3/css/dataTables.dataTables.min.css">
<script src="//cdn.datatables.net/2.0.3/js/dataTables.min.js"></script>
<script src="/js/dataTable.js"></script>


</head>

<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- Main Content -->
			<div class="col overflow-hidden">
				<div class="container-fluid" id="main-content">
					<div class="row">
						<div class="col-lg-15 ms-auto p-4 overflow-hidden">
							<h1 class="display-3">Good morning, Admin!</h1>
							<hr />
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<h1>Bookings</h1>
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">
										<a
										href="/jasperReportBookingRev"
										type="button" class="btn btn-success m-1" id="printButton"> Print Booking</a>
										<a href="addBooking" type="button"
										class="btn btn-success m-1" id="printButton">Add</a>
								</div>
							</div>

							<div class="row mb-4">
								<div class="col-md-12 b-4">
									<div class="card text-center p-3 text-success table-responsive"
										style="max-height: 100%; overflow-y: auto">
										<table class="table table-hover" id="bookingList">
											<thead>
												<tr>
													<th></th>>
													<th>Booking ID</th>
													<th>User ID</th>
													<th>Check In</th>
													<th>Check Out</th>
													<th>Total Price</th>
													<th>Arrival Time</th>
													<th>Adults</th>
													<th>Children</th>
													<th>Status</th>
													<th>Approval</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="bookings" items="${bookings }">
													<tr>
														<td><input type="checkbox" value="${bookings.user_id }"></td>
														<td><c:out value="${bookings.booking_id }" /></td>
														<td><c:out value="${bookings.user_id }" /></td>
														<td><c:out value="${bookings.checkin_date }" /></td>
														<td><c:out value="${bookings.checkout_date }" /></td>
														<td><c:out value="${bookings.total_price }" /></td>
														<td><c:out value="${bookings.arrival_time }" /></td>
														<td><c:out value="${bookings.adults }" /></td>
														<td><c:out value="${bookings.children }" /></td>
														<td><c:out value="${bookings.status }" /></td>
														<td>
															<button class="btn btn-success m-1 approve-btn"
																value="Approved"
																data-booking-id="${bookings.booking_id }">Approve</button>
															<button class="btn btn-danger m-1 disapprove-btn"
																value="Disapproved"
																data-booking-id="${bookings.booking_id }">
																Disapprove</button>
														</td>
														<td><a
															href="/admin/editBooking/${bookings.booking_id }"
															type="button" class="btn btn-success m-1"> Edit </a> <a
															href="/admin/deleteBooking/${bookings.booking_id}"
															type="button" class="btn btn-danger m-1"> Delete </a></td>
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
</body>

<!-- IONICONS LINK -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script src="/js/approval.js"></script>

</html>