<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Booking</title>
	<link rel="stylesheet" href="/styles/reset.css">
	<link rel="stylesheet" href="/styles/booking.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link
      rel="stylesheet"
      href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
	<link rel="stylesheet" href="/styles/booking.css" type="text/css" />
	<link rel="icon" href="/images/logo/logoo.png" sizes="any"
	type="image/png">
</head>
<body>
	<%@ include file = "/WEB-INF/views/Components/NavBar.jsp" %>
	<%@ include file = "/WEB-INF/views/Components/SubPageHero.jsp" %>
	<div class="mainWrapper mt-4 mb-5">
		<form class="filterBar mb-5" action="checkAvailability" method="POST">
			<div class="datePicker">
	            <p>Check In</p>
	            <div class="datePickerField">
	                <span class="fa-regular icon fa-calendar"></span>
	                <input name="checkin_date" id="checkin_date" type="text" class="datepicker-pop check-in" value="<c:out value="${checkin_date}"/>" />
	                <i class="fa-solid fa-angle-down"></i>
	             </div>
            </div>
            <div class="datePicker">
	            <p>Check Out</p>
	            <div class="datePickerField">
	            	<span class="fa-regular icon fa-calendar"></span>
	                <input name="checkout_date" id="checkout_date" type="text" class="datepicker-pop check-out" value="<c:out value="${checkout_date}"/>"/>
	            	<i class="fa-solid fa-angle-down"></i>
	            </div>
            </div>
            <div class="adults">
				<p>Adults</p>
				<div class="capacity-field">
					<i id="adults-minus" class="fa-solid fa-circle-minus"></i>
					<input name="adults" id="adults-number" value="${adults}" type="number" max="99" min="1">
					<i id="adults-add" class="fa-solid fa-circle-plus"></i>
				</div>
			</div>
			<div class="children">
				<p>Children</p>
				<div class="capacity-field">
					<i id="children-minus" class="fa-solid fa-circle-minus"></i>
					<input name="children" id="children-number" value="${children}" type="number" max="99" min="0">
					<i id="children-add" class="fa-solid fa-circle-plus"></i>
				</div>
			</div>
            <input type="submit" class="checkAvailabilityBtn" value="Check Availability" />
		</form>
		<div class="roomsAndList">
			<div id="roomsWrapper" class="roomsWrapper">
				<!-- Empty room for adding available rooms -->
			</div>
			<!-- Booking Interface and List of Added Rooms -->
			<div class="listWrapper ml-4">
				<div class="roomList-header">
					<div id="total-days" days="${days}">
						<div class="dateRange">
							<i class="fa-regular fa-calendar-days icon"></i> ${checkin_date} - ${checkout_date}
						</div>
						<div class="nights">
							<p>${days} <i style="color:#344955;" class="fa-solid fa-moon i"></i> Nights</p>
						</div>
					</div>
					<div class="roomList-totalPrice">
						<div id="roomList-totalPrice">0.00</div>Php
					</div>
				</div>
				<p class="addOnLabel"><i class="fa-solid fa-square-plus icon"></i> Add-ons:</p>
				<div class="addOns">
					<c:forEach var="addOn" items="${addOns}">
						<div class="mb-2 mr-3">
							<input onclick="addOnToggle(this)" class="addOnnCheck" type="checkbox" value="${addOn.add_on_id}" amount="${addOn.amount}">
							<label>${addOn.add_on_name} <span>${addOn.amount} Php</span></label>
						</div>
					</c:forEach>
				</div>
				<div class="arrivalTimeField">
					<p>Arrival Time: </p>
					<select id="arrivalTime" class="form-select">
						<option value="01:00-02:00">01:00 AM - 02:00 AM</option>
						<option value="02:00-03:00">02:00 AM - 03:00 AM</option>
						<option value="03:00-04:00">03:00 AM - 04:00 AM</option>
						<option value="04:00-05:00">04:00 AM - 05:00 AM</option>
						<option value="05:00-06:00">05:00 AM - 06:00 AM</option>
						<option value="06:00-07:00">06:00 AM - 07:00 AM</option>
						<option value="07:00-08:00">07:00 AM - 08:00 AM</option>
						<option value="08:00-09:00" selected="selected">08:00 AM - 09:00 AM</option>
						<option value="09:00-10:00">09:00 AM - 10:00 AM</option>
						<option value="10:00-11:00">10:00 AM - 11:00 AM</option>
						<option value="11:00-12:00">11:00 AM - 12:00 PM</option>
						<option value="12:00-13:00">12:00 PM - 01:00 PM</option>
						<option value="13:00-14:00">01:00 PM - 02:00 PM</option>
						<option value="14:00-15:00">02:00 PM - 03:00 PM</option>
						<option value="15:00-16:00">03:00 PM - 04:00 PM</option>
						<option value="16:00-17:00">04:00 PM - 05:00 PM</option>
						<option value="17:00-18:00">05:00 PM - 06:00 PM</option>
						<option value="18:00-19:00">06:00 PM - 07:00 PM</option>
						<option value="19:00-20:00">07:00 PM - 08:00 PM</option>
						<option value="20:00-21:00">08:00 PM - 09:00 PM</option>
						<option value="21:00-22:00">09:00 PM - 10:00 PM</option>
						<option value="22:00-23:00">10:00 PM - 11:00 PM</option>
					</select>
				</div>
				<div id="roomList-body" class="roomList-body">
					<!--Empty room for appending list of added rooms-->
				</div>
				<div class="roomList-footer">
					<div id="confirmBooking" class="confirmBooking">
						Confirm Booking
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file = "/WEB-INF/views/Components/Instagram.jsp" %>
	<%@ include file = "/WEB-INF/views/Components/Footer.jsp" %>
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="/scripts/booking/booking.js"></script>
</html>