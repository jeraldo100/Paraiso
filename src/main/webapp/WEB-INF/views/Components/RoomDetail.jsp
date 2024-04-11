<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <link rel="stylesheet" href="/styles/RoomDetail.css" />
</head>

<body>
  <div class="room-name mb-4 mt-5 pb-3">
    <div class="col-md-7 heading-section text-center">
      <h2>${room_type.name}</h2>
      <span class="subheading">₱${room_type.price_per_night} <span class="price-subheading">/ Per Night</span></span>
    </div>
  </div>

  <div class="container roomdetail">
    <div class="row">
      <div class="col-12">
        <div class="single-room-details-area mb-50">
          <div class="room-image mb-50 align-item-center">
  		   <img src="/images/RoomDetail/SuperiorKing/sp1.jpg" style="width: 700px; height: 400px;" alt="" />
          </div>
		<div class="room-features-area d-flex flex-wrap justify-content-center align-items-center mb-5 mt-5">
    			<h6>Capacity: <span>Max ${room_type.capacity} persons</span></h6>
   				 <h6>Bed: <span>${room_type.beds} beds</span></h6>
  				  <h6>Bathroom: <span>${room_type.bathrooms} bathroom</span></h6>
				</div>
          <p>
			${room_type.description}
          </p>

        </div>

        <div class="room-service mb-5 mt-5">
          <h4>Room Services</h4>

          <ul>
            <li>
              <img src="/images/RoomDetail/icon1.png" alt="" /> Air Conditioning
            </li>
            <li><img src="/images/RoomDetail/icon2.png" alt="" /> Free drinks</li>
            <li>
              <img src="/images/RoomDetail/icon3.png" alt="" /> Restaurant quality
            </li>
            <li><img src="/images/RoomDetail/icon4.png" alt="" /> Cable TV</li>
            <li>
              <img src="/images/RoomDetail/icon5.png" alt="" /> Unlimited Wifi
            </li>
            <li><img src="/images/RoomDetail/icon6.png" alt="" /> Service 24/7</li>
          </ul>
        </div>
      </div>
  </div>
  </div>

  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/superfish/1.7.10/js/superfish.min.js"></script>					
</body>

</html>