<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Paraiso Hotel Dashboard</title>
<link rel="icon" href="/images/logo/logoo.png" sizes="any" type="image/png">

<!-- BOOTSTRAP LINK -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<!-- CSS LINK -->

<!--  <link rel="stylesheet" href="/styles/dashboardAdmin/dashboard.css" /> -->

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  
  <link rel="stylesheet" href="//cdn.datatables.net/2.0.3/css/dataTables.dataTables.min.css">
  <script src="//cdn.datatables.net/2.0.3/js/dataTables.min.js"></script>
  
  <script type="text/javascript">
  	var contextPath = '${pageContext.request.contextPath}' + '/';
  	
  	$(document).ready(function(){
  		$('#roomTypeList').DataTable({
  		  pageLength: 50,
  		  columnDefs: [
  		    { targets: [0, 1, 2, 3,4,5,6], searchable: true },
  		    { targets: [7], searchable: false },
  		  ]
  		});

  	});
  </script>

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
									<button type="button" class="btn btn-success">Print</button>
									<a href="/addRoomTypes" class="btn btn-success" data-dismiss="modal" >Add</a>
								</div>
							</div>

							<div class="row mb-4">
								<div class="col-md-12 b-4">
										<div
											class="card text-center p-3 text-success table-responsive"
											style="max-height: 100%; overflow-y: auto">
											<table class="table table-hover" id="roomTypeList">
												<thead>
													<tr>
														<th>Type ID</th>
														<th>Name</th>
														<th>Description</th>
														<th>Amount</th>
														<th>Capacity</th>
														<th>Beds</th>
														<th>Bathrooms</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="room_types" items="${room_types }">
														<tr>
															<td><c:out value="${room_types.type_id }" /></td>
															<td><c:out value="${room_types.name }" /></td>
															<td><c:out value="${room_types.description }" /></td>
															<td><c:out value="${room_types.price_per_night }" /></td>
															<td><c:out value="${room_types.capacity }" /></td>
															<td><c:out value="${room_types.beds }" /></td>
															<td><c:out value="${room_types.bathrooms }" /></td>
															<td>
																<a href="/editRoomTypes/${room_types.type_id }" type="button" class="btn btn-success m-1">
																	Edit</a>
																<a href="/deleteType/${room_types.type_id}" type="button" class="btn btn-danger m-1">
																	Delete</a>
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