<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Booking</title>
	<link rel="stylesheet" href="/styles/reset.css">
	<link rel="stylesheet" href="/styles/booking.css">
</head>
<body>
	<div class="mainWrapper">
		<div class="filterBar">
			Check in: <input type="date" id="checkin_date" name="checkin_date">
			Check out: <input type="date" id="checkout_date" name="checkout_date">
			<input type="button" value= "check availability">
		</div>
	</div>
</body>
</html>