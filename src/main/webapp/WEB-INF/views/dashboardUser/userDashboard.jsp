<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Paraiso Hotel Dashboard</title>

  <!-- BOOTSTRAP LINK -->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

  <!-- CSS LINK -->

  <link rel="stylesheet" href="/styles/dashboardUser/dashboard.css" />
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
              <h1 class="display-3">Bookings!</h1>
              <hr />

              <div class="row mb-4">
                <div class="col-md-12 b-4">
                	<div class="bookings-wrapper">
                		<div>Loyalty points: ${loyaltyPoints}</div>
                		<c:forEach var="bookinglist" items="${bookingsAndRooms}">
                			<c:forEach items="${bookinglist}" var="Map">
                				<c:choose>
								    <c:when test = "${Map.key == 'booking'}">
								        <c:set value="${Map.value}" var="booking"/>
								    </c:when>
								    <c:otherwise>
								        <c:set value="${Map.value}" var="room_types"/>
								    </c:otherwise>
								</c:choose>
                			</c:forEach>
                			<div class="booking-card">
                				<div class="booking-body">
                					<div class="booking-id">
                						<p>Booking ID: ${booking.booking_id}</p>
                					</div>
                					<div class="date-range">
	                					<div>
	                						Check in Day: <fmt:formatDate value="${booking.checkin_date}" pattern="MMMM dd, yyyy" />
	                					</div>
	                					<div>
	                						Check out Day: <fmt:formatDate value="${booking.checkout_date}" pattern="MMMM dd, yyyy" />
	                					</div>
                					</div>
                					<div class="booking-details">
                						<p>Arrival Time: ${booking.arrival_time}</p>
                						<p>Adult Guests: ${booking.adults}</p>
                						<p>Children: ${booking.children}</p>
                					</div>
                					<div class="booking-price-wrapper">
                						<div class="booking-price"><fmt:formatNumber type="number" pattern="0,000.00" value="${booking.total_price}" /></div><p>Php</p>
                					</div>
                					<div class="booked-rooms">
                						<c:forEach items="${room_types}" var="roomType">
                							<div class="booked-room">
                								<p>${roomType.name}: </p>
                								<img 
                									src="data:image/jpeg;base64,${roomType.roomImageEncoded}" 
                									alt="${roomType.name}" 
                									class="booked-room-image"
                								/>
                							</div>
                						</c:forEach>
                					</div>
                				</div>
                				<div class="booking-footer">
                					<div><p>Status: ${booking.status}</p></div>
                					<div class="booking-actions">
                						<c:choose>
										    <c:when test = "${booking.status == 'PENDING'}">
										        <button
										        	type="button" 
										        	class="cancelButton"
										        	data-bs-toggle="modal" 
										        	data-bs-target="#CancelModal" 
										        	data-bs-booking_id="${booking.booking_id}"
										        >Cancel</button>
										    </c:when>
										    <c:when test = "${booking.status == 'Approved'}">
										        <button
										        	type="button" 
										        	class="cancelButton"
										        	data-bs-toggle="modal" 
										        	data-bs-target="#CancelModal" 
										        	data-bs-booking_id="${booking.booking_id}"
										        >Cancel</button>
										        <button 
										        	type="button" 
										        	data-bs-toggle="modal" 
										        	data-bs-target="#payment-modal" 
										        	data-bs-booking_id="${booking.booking_id}" 
										        	data-bs-price="${booking.total_price}" 
										        	class="payment-button"
										        >Pay</button>
										    </c:when>
										    <c:when test = "${booking.status == 'Cancelled'}">
										        <div>Booking is Cancelled</div>
										    </c:when>
										    <c:when test = "${booking.status == 'Disapproved'}">
										   		<div>Booking is not Approved</div>
										    </c:when>
										    <c:otherwise>
										        <div>Paid</div>
										    </c:otherwise>
										</c:choose>
                					</div>
                				</div>
                			</div>
                		</c:forEach>
                	</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Modals -->
  <!-- Cancel Modal -->
 <div class="modal fade" id="CancelModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Are you Sure?</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button data-bs-dismiss="modal" id="cancel-booking-button" type="button" class="btn cancel-booking-button btn-danger">Cancel</button>
      </div>
    </div>
  </div>
</div>

<!-- Payment Modal -->
<div class="modal fade" id="payment-modal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Payment</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<div class="payment-content">
      		<div hidden id="payment-price-hidden"><!-- hidden price --></div>
      		<div class="payment-price-container">
	      		<div id="payment-price">
	      			<!-- container for price -->
	      		</div><p>Php</p>
      		</div>
      		<div class="voucher-container">
      			<input type="text" id="voucherField" />
      			<button id="check-voucher">Check Voucher</button>
      		</div>
      		<div class="loyalty-container">
      			<select id="loyalty-select">
      				<option value="0" selected>Use Loyalty Points</option>
      				<option value="500">500</option>
      				<option value="1000">1000</option>
      				<option value="2000">2000</option>
      				<option value="3000">3000</option>
      			</select>
      		</div>
      		<div class="payment-options">
      			<div class="payment-option">
      				<input checked type="radio" class="payment-radio" id="Gcash" name="payment-method" value="Gcash">
      				<label>Gcash</label>
      			</div>
      			<div class="payment-option">
      				<input type="radio" class="payment-radio" id="CardPayment" name="payment-method" value="Credit/Debit Card">
      				<label>Credit/Debit Card</label>
      			</div>
      			<div class="payment-option">
      				<input type="radio" class="payment-radio" id="Paymaya" name="payment-method" value="Paymaya">
      				<label>Paymaya</label>
      			</div>
      			<div id="payment-fields">
	      			<div class="payment-field">Enter OTP <input type="number"/><div>
					<div class="payment-field">Enter MPIN <input type="number"/></div>
      				<!-- Empty field for inserting fields -->
      			</div>
      		</div>
      	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button id="confirm-payment" type="button" class="btn btn-primary">Pay</button>
      </div>
    </div>
  </div>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script src="/scripts/UserDashboardBookings.js"></script>

</html>