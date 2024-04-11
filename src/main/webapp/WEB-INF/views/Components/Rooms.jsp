<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" href="/styles/Rooms.css" />
</head>
<body>
    <section class="rooms-section pb-0 mb-30">
        <div class="container-fluid room-container px-0">
            <c:forEach var="room_type" items="${room_types}">
                <div class="roomsContainer">
                    <div class="row no-gutters">
                        <div class="col-lg-12">
                            <div class="room-wrap d-md-flex">
                                <div class="half right-arrow d-flex">
                                    <div class="text p-4" style="margin: 0 25px; margin-top: 20px">
                                        <p class="star mb-2">
                                            <span class="fa-solid fa-star"></span>
                                            <span class="fa-solid fa-star"></span>
                                            <span class="fa-solid fa-star"></span>
                                            <span class="fa-solid fa-star"></span>
                                            <span class="fa-solid fa-star"></span>
                                        </p>
                                        <p class="mb-2">
                                            <span class="price mr-1">${room_type.price_per_night}</span>
                                            <span class="per">per night</span>
                                        </p>
                                        <h3 class="mb-3"><a href="rooms.html">${room_type.name}</a></h3>
                                        <p class="mb-4 roomsDesc">${room_type.description}</p>
                                        <p class="pt-1 d-md-flex align-items-center justify-content-center">
                                            <a href="rooms-single.html" class="btn-custom px-3 py-2 rounded">View Details <span class="icon-long-arrow-right"></span></a>
                                        </p>
                                    </div>
                                </div>                                                                                
								 <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(room_type.roomImage)}" alt="" style="max-width: 100px; max-height: 100px;">                            
							</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</body>
</html>
