<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Base64"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Paraiso Hotel Dashboard</title>
<link rel="icon" type="image/png" sizes="16x16 32x32" href="/images/logo/paraisologo2.png">

<!-- BOOTSTRAP LINK -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

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
								<h1>Room Types</h1>
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">

									<a href="/admin/addRoomTypes" class="btn btn-success"
										data-dismiss="modal">Add</a>
								</div>
							</div>

							<div class="row mb-4">
								<div class="col-md-12 b-4">
									<div class="card text-center p-3 text-success table-responsive"
										style="max-height: 100%; overflow-y: auto">
										<table class="table table-hover">
											<thead>
												<tr>
													<th>Type ID</th>
													<th>Name</th>
													<th>Description</th>
													<th>Amount</th>
													<th>Capacity</th>
													<th>Beds</th>
													<th>Bathrooms</th>
													<th>Image</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="room_type" items="${room_types}">
													<tr>
														<td><c:out value="${room_type.type_id}" /></td>
														<td><c:out value="${room_type.name}" /></td>
														<td><c:out value="${room_type.description}" /></td>
														<td><c:out value="${room_type.price_per_night}" /></td>
														<td><c:out value="${room_type.capacity}" /></td>
														<td><c:out value="${room_type.beds}" /></td>
														<td><c:out value="${room_type.bathrooms}" /></td>
														<td><img
															src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(room_type.roomImage)}"
															alt="" style="max-width: 100px; max-height: 100px;">
														</td>
														<td><select
															onchange="window.location.href=this.value"
															class="btn btn-success">
																<option value="">Select an action</option>
																<option
																	value="/admin/editRoomTypes/${room_type.type_id}">Edit</option>
																<option value="/admin/deleteType/${room_type.type_id}">Delete</option>
																<option value="/jasperReportRooms/${room_type.type_id}">Print</option>
														</select></td>
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