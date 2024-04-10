<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <meta charset="UTF-8" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
      <link rel="stylesheet" href="/styles/NavBar.css" />
      <link rel="stylesheet" href="/styles/LoginSignUp.css" />
    </head>

    <body>
      <header id="header">
        <div class="header-top">
          <div class="container">
            <div class="align-items-center">
              <div class="col-lg-6 col-sm-6 col-6 header-top-left">
                <ul>
                  <li><a href="#"></a></li>
                  <li><a href="#"></a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="container main-menu">
          <div class="align-items-center justify-content-between d-flex">
            <div id="logo">
              <a href="/home"><img src=" " alt="" /></a>
            </div>
            <nav id="nav-menu-container">
              <ul class="nav-menu">
                <li><a href="/home">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/rooms">Our Rooms</a></li>
                <li><a href="/services">Services</a></li>
                <li><a href="/contact">Contact</a></li>


                <c:choose>
                  <c:when test="${loggedIn}">
                    <li class="menu-has-children">
                      <a class=" fa-solid fa-user text-white"><i class="fa-solid fa-chevron-down ml-1"></i></a>
                      <ul>
                        <div class="container">
                          <div class="row justify-content-center align-items-center text-center mb-2 mt-2">
                            <div class="col-12">
                              <img src="/images/NavBar/profile-icon.png" class="profile-icon" alt="" />
                              <div class="mt-1 profile-name">${username}</div>
                            </div>
                          </div>
                        </div>
                        <li><a href="/userDashboard">User Dashboard</a></li>
                        <li><a href="/logout">Logout</a></li>
                      </ul>
                    </li>
                  </c:when>
                  <c:otherwise>

                    <li><a class="login" id="loginBtn">Login</a></li>
                    <li><a class="ml-1 mr-2 signup" id="signUpBtn">Sign Up</a></li>
                  </c:otherwise>
                </c:choose>

              </ul>
            </nav>
          </div>
        </div>
      </header>

      <div class="login-section">
        <div id="loginModal" class="login-signup-modal">
          <div class="login-container">
            <span class="close-btn fa-solid fa-x"></span>
            <div class="signin-signup">
              <form class="sign-in-form" action="auth" method="post">
                <h2 class="login-title">Login</h2>
                <p id="message"></p>
                <div class="login-signup-input">
                  <i class="fas fa-user"></i>
                  <input type="text" name="email" placeholder="Email" />
                </div>
                <div class="login-signup-input">
                  <i class="fas fa-lock"></i>
                  <input type="password" name="password" placeholder="Password" />
                </div>

                <input href="register" type="submit" value="Submit" class="login-signup-btn" />


                <p class="account-text">
                  Don't have an account? <a href="#" id="sign-up-btn2">Sign up</a>
                </p>
              </form>

            <form id="registrationForm" action="registration" method="post" role="form" class="sign-up-form">
                <h2 class="signup-title">Sign up</h2>
                

                <div class="column-container">
                  <div class="signup-input signup-col1">
                    <i class="fas fa-user"></i>
                    <input type="text" name="firstName" id="firstName" placeholder="First Name"
                      value="${user.firstName}" />
                  </div>

                  <div class="signup-input signup-col2">
                    <i class="fas fa-user"></i>
                    <input type="text" name="lastName" id="lastName" placeholder="Last Name" value="${user.lastName}" />
                  </div>
                </div>
                <div class="signup-input">
                  <i class="fa-solid fa-envelope"></i>
                  <input type="text" name="email" id="email" placeholder="Email" />
                </div>
                <div class="signup-input">
                  <i class="fa-regular fa-user"></i>
                  <input type="text" name="username" id="username" placeholder="Username" />
                </div>
                <div class="signup-input">
                  <i class="fa-solid fa-location-dot"></i>
                  <input type="text" name="address" id="address" placeholder="Address" />
                </div>

                <div class="column-container">
                  <div class="signup-input signup-col1">
                    <i class="fa-solid fa-calendar"></i>
                    <input type="text" name="dateOfBirth" placeholder="Date of Birth" onfocus="(this.type='date')" />
                  </div>

                  <div class="signup-input signup-col2">
                    <i class="fa-solid fa-phone"></i>
                    <input type="text" name="phone" id="phone" placeholder="Phone" />
                  </div>
                </div>

                <div class="signup-input">
                  <i class="fas fa-lock"></i>
                  <input type="password" name="password" id="password" placeholder="Password" />
                </div>
                <input type="submit" value="Submit" class="signup-btn" />
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
                <img src="/images/LoginSignUp/signin.svg" alt="" class="login-signup-image" />
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
                <img src="/images/LoginSignUp/signup.svg" alt="" class="login-signup-image" />
              </div>
            </div>
          </div>
        </div>
      </div>


      <script src="https://cdnjs.cloudflare.com/ajax/libs/superfish/1.7.10/js/superfish.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="/scripts/NavBar.js"></script>
      <script src="/scripts/LoginSignUp.js"></script>
      <script>

</script>
      
    </body>

    </html>