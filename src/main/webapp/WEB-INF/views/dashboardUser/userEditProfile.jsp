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
							<h1 class="display-3">Good morning, User!</h1>
							<hr />
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
												<form action="/user/updateUser/${user.user_id }"
													method="post">
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">First Name</span> <input
															type="text" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Last Name</span> <input
															type="text" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Email</span> <input
															type="email" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Username</span> <input
															type="text" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Address</span> <input
															type="text" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Date of Birth</span> <input
															type="date" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Phone</span> <input
															type="number" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="input-group mb-3">
														<span class="input-group-text"
															id="inputGroup-sizing-default">Password</span> <input
															type="password" class="form-control"
															aria-label="Sizing example input"
															aria-describedby="inputGroup-sizing-default">
													</div>
													<div class="container">
														<div class="d-flex justify-content-end">
															<a type="button" href="/user/userProfile"
																class="btn btn-danger float-end m-3">Back</a> <input
																type="submit" class="btn btn-success float-end m-3"
																value="Submit">
														</div>
													</div>
												</form>
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