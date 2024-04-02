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
</head>
<body>
	<div class="mainWrapper">
		<div class="filterBar">
			<jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-mm-dd" />
			Check in: <input type="date" id="checkin_date" name="checkin_date" min="2024-04-02">
			Check out: <input type="date" id="checkout_date" name="checkout_date" min="2024-04-02">
			<input type="button" value= "check availability">
		</div>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>