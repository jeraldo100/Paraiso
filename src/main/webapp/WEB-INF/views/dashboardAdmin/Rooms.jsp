<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Paraiso Hotel Dashboard</title>

<!-- BOOTSTRAP LINK -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<!-- CSS LINK -->

<link rel="stylesheet" href="/styles/dashboardAdmin/dashboard.css" />

<!-- GOOGLE ICON LINK -->

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

</head>

<body>
	<div class="container-fluid">
		<div class="row flex-nowrap">
			<jsp:include page="sidebar.jsp"></jsp:include>
			<div class="col">
				<div class="container-fluid" id="main-content">
					<div class="row">
						<div class="col-lg-15 ms-auto p-4 overflow-hidden">
							<h1 class="display-3">Good morning, Admin!</h1>
							<hr />
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<h1>Rooms</h1>
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">
									<button type="button" class="btn btn-success">Print</button>
									<a href="/addRoom" class="btn btn-success">
									Add
									</a>
									<select name="" id=""
										class="form-select shadow-none bg-light w-auto">
										<option value="0">Select timeline</option>
										<option value="1">Past 30 Days</option>
										<option value="2">Past 60 Days</option>
										<option value="3">Past 90 Days</option>
										<option value="4">Past 1 Year</option>
										<option value="5">All time</option>
									</select>
								</div>
							</div>

							<div class="row mb-4">
								<div class="col-md-12 b-4">
									<a href="#" class="text-decoration-none">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 100%; overflow-y: auto">
											<table class="table table-hover">
												<thead>
													<tr>
														<th></th>
														<th>Room ID</th>
														<th>Hotel ID</th>
														<th>Type</th>
														<th>Status</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="rooms" items="${rooms }">
														<tr>
															<td><input type="checkbox" /></td>
															<td><c:out value="${rooms.room_id }" /></td>
															<td><c:out value="${rooms.hotel_id }" /></td>
															<td><c:out value="${rooms.type_id }" /></td>
															<td><c:out value="${rooms.status }" /></td>
															<td>
																<a href="#" type="button" class="btn btn-success">
																	Edit</a>
																<a href="#" type="button" class="btn btn-danger">
																	Delete</a>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<%-- 	<jsp:include page="Modals/AddRoomsModal.jsp"></jsp:include> --%>

	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script> -->

</body>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>

<!-- IONICONS LINK -->

<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</html>