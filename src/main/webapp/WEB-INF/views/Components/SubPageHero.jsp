
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/styles/SubPageHero.css">
</head>
<body>
    <section class="sub-hero-banner relative" style="background: url('/images/SubPageHero/hero-bg.jpg');">
        <div class="overlay overlay-bg"></div>
        <div class="container sub-hero-text">
            <div class="row d-flex align-items-center justify-content-center">
                <div class="sub-hero-content col-lg-12" style="margin-top:80px;">
                    <h1 class="text-white">${pageTitle}</h1>
                    <p class="text-white link-nav">
                        <a href="/home" class="text-decoration-none">Home </a> 
                        <span class="fa-solid fa-arrow-right p-2"></span> 
                        <a href="${pageLink}" class="text-decoration-none"> ${pageTitle}</a>
                    </p>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
