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

<!-- CSS LINK -->

<link rel="stylesheet" href="/styles/dashboardUser/userEditProfile.css" />

<!-- GOOGLE ICON LINK -->

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
										<td><h1 class="display-3">Welcome, ${user.username}</h1></td>
									</tr>
								</tbody>
							</table>
							<div
								class="d-flex align-items-center justify-content-between mb-4">
								<h1>Edit Profile</h1>
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">
									<!-- <button type="button" class="btn btn-success">Edit</button>
                    <button type="button" class="btn btn-success">Add</button> -->
								</div>
							</div>

							<div class="container-fluid">
								<div class="row justify-content-center vertical-center">
									<div class="col-lg col-md">
										<div class="card border-0">
											<div class="card-body">
												<table class="table" id="bookingList">

													<tbody>

														<tr>
															<td>
																
																<form action="/user/updateUser" method="post" onsubmit="return validateForm()">
																<div class="mb-3">
																	<label for="username" class="form-label">Username</label>
																	<input type="text" class="form-control" id="username"
																		name="username"
																		placeholder="${user.firstName}">
																</div>
																	<div class="mb-3">
																		<label for="firstName" class="form-label">First
																			Name</label> <input type="text" class="form-control"
																			id="firstName" name="firstName"
																			placeholder="${user.firstName}">
																	</div>
																	<div class="mb-3">
																		<label for="lastName" class="form-label">Last
																			Name</label> <input type="text" class="form-control"
																			id="lastName" name="lastName"
																			placeholder="${user.lastName}">
																	</div>
																	<div class="mb-3">
																		<label for="email" class="form-label">Email</label> <input
																			type="email" class="form-control" id="email"
																			name="email" placeholder="${user.email}"
																			>
																	</div>
																	<div class="mb-3">
																		<label for="address" class="form-label">Address</label>
																		<input type="text" class="form-control" id="address"
																			name="address"
																			placeholder="${user.address}">
																	</div>
																	<div class="mb-3">
																		<label for="phone" class="form-label">Phone</label> <input
																			type="text" class="form-control" id="phone"
																			name="phone" placeholder="${user.phone}">
																	</div>
																	<div class="mb-3">
																		<label for="dateOfBirth" class="form-label">Date
																			of Birth</label> <input type="date" class="form-control"
																			id="dateOfBirth" name="dateOfBirth"
																			placeholder="${user.dateOfBirth}">
																	</div>
																	<div class="mb-3">
																		<label for="password" class="form-label">Password</label>
																		<input type="password" class="form-control"
																			id="password" name="password"
																			placeholder="Enter password">
																	</div>
																	<input type="hidden" name="${_csrf.parameterName}"
																		placeholder="${_csrf.token}" />
																	<div class="container">
																		<div class="d-flex justify-content-end border-0">
																			<a type="button" href="/user/userProfile"
																				class="btn btn-danger float-end m-3">Back</a> <input
																				type="submit" class="btn btn-success float-end m-3"
																				placeholder="Submit">
																		</div>
																	</div>
																</form>
															</td>
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
			</div>
		</div>
	</div>


</body>

<!-- JS LINK -->

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