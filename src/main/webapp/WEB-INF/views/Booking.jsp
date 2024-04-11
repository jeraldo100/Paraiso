<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paraiso Hotel</title>
<link rel="icon" href="/images/logo/logoo.png" sizes="any"
	type="image/png">
</head>
<body>
<%@ include file = "/WEB-INF/views/Components/CSSPlugins.jsp" %>
<%@ include file = "/WEB-INF/views/Components/NavBar.jsp" %>
<%@ include file = "/WEB-INF/views/Components/SubPageHero.jsp" %>

       <div class="row no-gutters justify-content-center mt-5">
          <div class="col-md-7 room-heading-section text-center">
            <span class="subheading">Experience Hotel Greatness</span>
            <h2 class="mb-4">Paraiso Hotel Rooms</h2>
          </div>
        </div>
        
<%@ include file = "/WEB-INF/views/Components/HomeBooking.jsp" %>
<%@ include file = "/WEB-INF/views/booking/Booking.jsp" %>
<%@ include file = "/WEB-INF/views/Components/Instagram.jsp" %>
<%@ include file = "/WEB-INF/views/Components/Footer.jsp" %>
</body>
</html>