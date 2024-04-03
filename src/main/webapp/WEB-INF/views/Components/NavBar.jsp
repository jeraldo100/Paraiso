<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta charset="UTF-8">
		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
		<link rel="stylesheet" href="/styles/NavBar.css">
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
				        <a href="index.html"><img src=" " alt="" title="" /></a>
				      </div>
				      <nav id="nav-menu-container">
				        <ul class="nav-menu">
							<li><a href="/home">Home</a></li>
							<li><a href="/about">About</a></li>
							<li><a href="/rooms">Our Rooms</a></li>
							<li><a href="/services">Services</a></li>
							<li><a href="/contact">Contact</a></li>
							<li><a class="login" id="loginBtn">Login</a></li>
              				<li><a class="ml-1 mr-2 signup" id="signUpBtn">Sign Up</a></li>
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
                    <form action="" class="sign-in-form">
                        <h2 class="login-title">Login</h2>
                        <div class="login-signup-input">
                            <i class="fas fa-user"></i>
                            <input type="text" placeholder="Username" />
                        </div>
                        <div class="login-signup-input">
                            <i class="fas fa-lock"></i>
                            <input type="password" placeholder="Password" />
                        </div>
                        <input type="submit" value="Login" class="login-signup-btn" />

                        <p class="account-text">
                            Don't have an account? <a href="#" id="sign-up-btn2">Sign up</a>
                        </p>
                    </form>
                    <form action="" class="sign-up-form">
                        <h2 class="login-title">Sign up</h2>
                        <div class="login-signup-input">
                            <i class="fas fa-user"></i>
                            <input type="text" placeholder="Username" />
                        </div>
                        <div class="login-signup-input">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Email" />
                        </div>
                        <div class="login-signup-input">
                            <i class="fas fa-lock"></i>
                            <input type="password" placeholder="Password" />
                        </div>
                        <input type="submit" value="Sign up" class="login-signup-btn" />
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
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque
                                accusantium dolor, eos incidunt minima iure?
                            </p>
                            <button class="login-signup-btn" id="sign-in-btn">Login</button>
                        </div>
                        <img src="/images/LoginSignUp/signin.svg" alt="" class="login-signup-image" />
                    </div>
                    <div class="login-signup-panel right-panel">
                        <div class="login-signup-content">
                            <h3>New here? Join us by signing up</h3>
                            <p>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque
                                accusantium dolor, eos incidunt minima iure?
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
			
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/superfish/1.7.10/js/superfish.min.js"></script>					
			<script src="/scripts/NavBar.js"></script>	
			<script src="/scripts/LoginSignUp.js"></script>	
		</body>
	</html>