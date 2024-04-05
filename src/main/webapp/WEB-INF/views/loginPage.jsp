<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
    />
    <link rel="stylesheet" href="/styles/LoginSignUp.css" />
</head>
<body>
 <div class="login-section">
      <div id="loginModal" class="login-signup-modal">
        <div class="login-container">
          <span class="close-btn fa-solid fa-x"></span>
          <div class="signin-signup">
            <form  class="sign-in-form" action="auth" method="post">
              <h2 class="login-title">Login</h2>
              <div class="login-signup-input">
                <i class="fas fa-user"></i>
                <input type="text" name="email" placeholder="Email" />
              </div>
              <div class="login-signup-input">
                <i class="fas fa-lock"></i>
                <input type="password" name="password" placeholder="Password" />
              </div>
              
              <input href="register" type="submit" value="Submit" class="login-signup-btn" />
              <h3 class="err-msg">${error}</h3>

              <p class="account-text">
                Don't have an account? <a href="#" id="sign-up-btn2">Sign up</a>
              </p>
            </form>

            <form action="" class="sign-up-form">
              <h2 class="signup-title">Sign up</h2>

              <div class="column-container">
                <div class="signup-input signup-col1">
                  <i class="fas fa-user"></i>
                  <input type="text" placeholder="First Name" />
                </div>

                <div class="signup-input signup-col2">
                  <i class="fas fa-user"></i>
                  <input type="text" placeholder="Last Name" />
                </div>
              </div>
              <div class="signup-input">
                <i class="fa-solid fa-envelope"></i>
                <input type="text" placeholder="Email" />
              </div>
              <div class="signup-input">
                <i class="fa-regular fa-user"></i>
                <input type="text" placeholder="Username" />
              </div>

              <div class="signup-input">
                <i class="fa-solid fa-location-dot"></i>
                <input type="text" placeholder="Address" />
              </div>

              <div class="column-container">
                <div class="signup-input signup-col1">
                  <i class="fa-solid fa-calendar"></i>
                  <input type="text" placeholder="Date of Birth" />
                </div>

                <div class="signup-input signup-col2">
                  <i class="fa-solid fa-phone"></i>
                  <input type="text" placeholder="Phone" />
                </div>
              </div>

              <div class="signup-input">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password" />
              </div>
              <div class="signup-input">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Confirm Password" />
              </div>
              <input type="submit" value="Sign up" class="signup-btn" />
              <p class="account-text">
                Already have an account?
                <a href="#" id="sign-in-btn2">Sign in</a>
              </p>
            </form>
          </div>

          <div class="panels-container">
            <div class="login-signup-panel left-panel">
              <div class="login-signup-content">
                <h3>Already have an account?</h3>
                <p>
                  Log in to your account to enjoy the ease of tracking your
                  bookings, receiving tailored recommendations, and unlocking
                  special offers reserved for our members.
                </p>
                <button class="login-signup-btn" id="sign-in-btn">Login</button>
              </div>
              <img
                src="/images/LoginSignUp/signin.svg"
                alt=""
                class="login-signup-image"
              />
            </div>
            <div class="login-signup-panel right-panel">
              <div class="login-signup-content">
                <h3>New here? Join us by signing up</h3>
                <p>
                  Sign up today to receive personalized offers, access exclusive
                  deals, and enjoy a faster Paraiso Hotel booking experience.
                </p>
                <button class="login-signup-btn" id="sign-up-btn">
                  Sign up
                </button>
                
              </div>
              <img
                src="/images/LoginSignUp/signup.svg"
                alt=""
                class="login-signup-image"
              />
            </div>
          </div>
        </div>
      </div>
      </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <script src="/scripts/LoginSignUp.js"></script>
</body>
</html>