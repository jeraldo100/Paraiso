<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Paraiso Hotel Dashboard</title>

  <!--BOOTSTRAP LINK-->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

  <!-- CSS LINK -->

  <link rel="stylesheet" href="/styles/dashboardAdmin/dashboard.css" />
  
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
              <h1 class="display-3">Good morning, Admin!</h1>
              <hr />
              <div class="d-flex align-items-center justify-content-between mb-4">
                <h1>Bookings</h1>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                  <a href="#" type="button" class="btn btn-success">Print</a>
                  <a href="addBooking" type="button" class="btn btn-success">Add</a>
                </div>
              </div>

              <div class="row mb-4">
                <div class="col-md-12 b-4">
                    <div class="card text-center p-3 text-success table-responsive"
                      style="max-height: 100%; overflow-y: auto">
                      <table class="table table-hover">
                        <thead>
                          <tr>
                            <th></th>
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
	                            <td><input type="checkbox" /></td>
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
	                              <button class="btn btn-success m-1">Approve</button>
	                              <button class="btn btn-danger m-1">
	                                Disapprove
	                              </button>
	                            </td>
	                            <td>
	                              <a href="/editBooking/${bookings.booking_id }" type="button" class="btn btn-success m-1">
	                                Edit
	                              </a>
	                              <a href="/deleteBooking/${bookings.booking_id }" type="button" class="btn btn-danger m-1">
	                                Delete
	                              </a>
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

  <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script> -->
</body>

<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
  integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
  integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script> -->

<!-- IONICONS LINK -->
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script src="paraiso.js"></script>

</html>