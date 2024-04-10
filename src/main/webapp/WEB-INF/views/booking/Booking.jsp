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
</head>
<body>
	<%@ include file = "/WEB-INF/views/Components/NavBar.jsp" %>
	<%@ include file = "/WEB-INF/views/Components/SubPageHero.jsp" %>
	<div class="mainWrapper">
		<form class="filterBar" action="checkAvailability" method="POST">
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
			<div class="listWrapper">
				<div class="roomList-header">
					<div id="total-days" days="${days}">
						<div class="dateRange">
							<i class="fa-regular fa-calendar-days icon"></i> ${checkin_date} - ${checkout_date}
						</div>
						<div class="nights">
							<p>${days} <i style="color:#344955;" class="fa-solid fa-moon i"></i> Nights</p>
						</div>
					</div>
					<div id="roomList-totalPrice" class="roomList-totalPrice">
						<!--Empty room for updating list total Price-->
					</div>
				</div>
				<p class="addOnLabel" style="margin-bottom: 0.8rem"><i class="fa-solid fa-square-plus icon"></i> Add-ons:</p>
				<div class="addOns">
					<div>
						<input type="checkbox" id="vehicle1" name="vehicle1" value="Breakfast">
						<label for="vehicle1">Breakfast</label>
					</div>
					<div>
						<input type="checkbox" id="vehicle1" name="vehicle1" value="extraLinen">
						<label for="vehicle1">Extra Linen</label>
					</div>
					<div>
						<input type="checkbox" id="vehicle1" name="vehicle1" value="extraPilows">
						<label for="vehicle1">Extra Pilows</label>
					</div>
					<div>
						<input type="checkbox" id="vehicle1" name="vehicle1" value="dinner">
						<label for="vehicle1">Dinner</label>
					</div>
				</div>
				<div id="roomList-body" class="roomList-body">
					<!--Empty room for appending list of added rooms-->
				</div>
				<div class="roomList-footer">
					<div id="confirmBooking" href="/home" class="confirmBooking">
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