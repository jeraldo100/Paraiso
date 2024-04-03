<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

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
	<div class="mainWrapper">
		<div class="filterBar">
			<div class="datePicker">
	            <p>Check In</p>
	                <span class="fa-regular icon fa-calendar"></span>
	                <input id="checkin_date" type="text" class="datepicker-pop check-in" />
	                <i class="fa-solid fa-angle-down"></i>
            </div>
            <div class="datePicker">
	            <p>Check Out</p>
	            <div>
	            	<span class="fa-regular icon fa-calendar"></span>
	                <input id="checkout_date" type="text" class="datepicker-pop check-out" />
	            	<i class="fa-solid fa-angle-down"></i>
	            </div>
	                
            </div>
	</div>
</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="/scripts/booking/booking.js"></script>
</html>