$(document).ready(function() {
	var modal = $("#loginModal");
	var loginBtn = $("#loginBtn");
	var signUpBtn = $("#signUpBtn");
	var sign_in_btn = $("#sign-in-btn");
	var sign_up_btn = $("#sign-up-btn");
	var container = $(".login-container");
	var sign_in_btn2 = $("#sign-in-btn2");
	var sign_up_btn2 = $("#sign-up-btn2");
	var closeButton = $(".close-btn");


	loginBtn.click(function() {
		modal.css("display", "block");
		container.removeClass("loginSignUpMode");
		container.removeClass("loginSignUpMode2");
	});

	signUpBtn.click(function() {
		modal.css("display", "block");
		container.addClass("loginSignUpMode");
		container.addClass("loginSignUpMode2");
	});

	$(window).click(function(event) {
		if (event.target == modal[0]) {
			modal.css("display", "none");
		}
	});

	sign_up_btn.click(function() {
		container.addClass("loginSignUpMode");
		$("#confirmPassword").attr("placeholder", "Confirm Password");
		$("#confirmPassword").val("");
		$("#password").attr("placeholder", "Password");
		$("#password").val("");
		$("#username").attr("placeholder", "Username");
		$("#username").val("");
		$("#phone").attr("placeholder", "Phone");
		$("#phone").val("");
		$("#email").attr("placeholder", "Email");
		$("#email").val("");
		$("#dateOfBirth").attr("placeholder", "Date Of Birth");
		$("#dateOfBirth").val("");
		$("#lastName").attr("placeholder", "Last Name");
		$("#lastName").val("");
		$("#firstName").attr("placeholder", "First Name");
		$("#firstName").val("");
		$("#address").attr("placeholder", "Address");
		$("#address").val("");
		$(".signup-input").css("border-color", "grey")
		$('#signupMessage').text("");

	});

	sign_in_btn.click(function() {
		container.removeClass("loginSignUpMode");

		$('#message').text("");
	});

	sign_up_btn2.click(function() {
		container.addClass("loginSignUpMode2");
		$("#confirmPassword").attr("placeholder", "Confirm Password");
		$('#signupMessage').text("");
	});

	sign_in_btn2.click(function() {
		container.removeClass("loginSignUpMode2");
		$('#message').text("");
	});

	closeButton.click(function() {
		$('#message').text("");
		$('#signupMessage').text("");
		modal.css("display", "none");
	});


	function validateForm() {
		var isValid = true;
		var emailRegex = /\S+@\S+\.\S+/;
		var passwordRegex = /^.{8,}$/;
		var firstName = $("#firstName").val();
		if (firstName === "") {
			$("#firstName").attr("placeholder", "Must be filled out");
			$("#firstName").closest(".signup-input").css("border-color", "red");
			$("#firstName").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}

		var lastName = $("#lastName").val();
		if (lastName === "") {
			$("#lastName").attr("placeholder", "Must be filled out");
			$("#lastName").closest(".signup-input").css("border-color", "red");
			$("#lastName").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}


		var email = $("#email").val();
		if (email === "") {
			$("#email").attr("placeholder", "Must be filled out");
			$("#email").closest(".signup-input").css("border-color", "red");
			$("#email").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}
		else if (!emailRegex.test(email)) {
			$("#email").val("");
			$("#email").attr("placeholder", "Invalid email address");
			$("#email").closest(".signup-input").css("border-color", "red");
			$("#email").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}

		var username = $("#username").val();
		if (username === "") {
			$("#username").attr("placeholder", "Must be filled out");
			$("#username").closest(".signup-input").css("border-color", "red");
			$("#username").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});

			isValid = false;
		}


		var address = $("#address").val();
		if (address === "") {
			$("#address").attr("placeholder", "Must be filled out");
			$("#address").closest(".signup-input").css("border-color", "red");
			$("#address").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});

			isValid = false;
		}


		var dateOfBirth = $("input[name='dateOfBirth']").val();
		if (dateOfBirth === "") {
			$("input[name='dateOfBirth']").attr("placeholder", "Must be filled out");
			$("#dateOfBirth").closest(".signup-input").css("border-color", "red");
			$("#dateOfBirth").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}


		var phone = $("#phone").val();
		if (phone === "") {
			$("#phone").attr("placeholder", "Must be filled out");
			$("#phone").closest(".signup-input").css("border-color", "red");
			$("#phone").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});

			isValid = false;
		}



		var password = $("#password").val();
		if (password === "") {
			$("#password").attr("placeholder", "Must be filled out");
			$("#password").closest(".signup-input").css("border-color", "red");
			$("#password").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		} else if (!passwordRegex.test(password)) {
			$("#password").val("");
			$("#password").attr("placeholder", "Password must be at least 8 characters long").css("border-color", "red");
			$("#password").closest(".signup-input").css("border-color", "red");
			$("#password").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}


		var confirmPassword = $("#confirmPassword").val();
		if (confirmPassword === "") {
			$("#confirmPassword").attr("placeholder", "Must be filled out");
			$("#confirmPassword").closest(".signup-input").css("border-color", "red");
			$("#confirmPassword").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		} else if (confirmPassword !== password) {
			$("#confirmPassword").val("");
			$("#confirmPassword").attr("placeholder", "Passwords do not match");
			$("#confirmPassword").closest(".signup-input").css("border-color", "red");
			$("#confirmPassword").on("input", function() {
				$(this).closest(".signup-input").css("border-color", "");
			});
			isValid = false;
		}

		return isValid;
	}

	function showModal(message) {
		var modal = $("#loginBtn");
		$('#message').text(message);
		modal.css("display", "block");
		container.removeClass("loginSignUpMode");
		container.removeClass("loginSignUpMode2");
	}

	function showSignUpModal(message) {
		var modal = $("#signUpBtn");
		$('#signupMessage').text(message);
		modal.css("display", "block");
	}


	$('#registrationForm').submit(function(event) {
		event.preventDefault();

		if (validateForm() === true) {
			var formData = $(this).serialize();
			$.ajax({
				type: 'POST',
				url: $(this).attr('action'),
				data: formData,
				success: function(response) {
					console.log(response);
					showModal(response);
					$('#registrationForm')[0].reset();
				},
				error: function(xhr, status, error) {
					var errorMessage = xhr.responseText;
					showSignUpModal(errorMessage);
				}
			});
		}
	});


	$('#loginForm').submit(function(event) {

		event.preventDefault();


		var formData = $(this).serialize();

		$.ajax({
			type: 'POST',
			url: 'auth',
			data: formData,
			success: function(response) {
				
				if (response.redirectUrl) {
					window.location.href = response.redirectUrl;
				} else {
					$('#message').text(response.error);
				}
			},
			error: function() {
				$('#message').text('Invalid credentials. Please try again.');
			}
		});
	});
});