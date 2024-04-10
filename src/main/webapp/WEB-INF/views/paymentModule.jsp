<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Paraiso Hotel User Dashboard</title>
<!-- BOOTSTRAP LINK -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<!-- CSS LINK -->
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css" />
<style>
html, body {
	height: 100vh;
	margin: 0;
	padding: 0;
}

.full-height {
	height: 100%;
}

.bg-success {
	background-color: green;
	color: white;
}

.bg-danger {
	background-color: red;
	color: white;
}

.d-flex {
	display: flex;
	align-items: center;
	justify-content: center;
}

.card {
	border-radius: 20px;
}

.hidden {
	display: none;
}

.main {
	max-height: 650px;
	overflow-y: auto;
}
</style>
</head>

<body>

	<div
		class="full-height d-flex justify-content-center align-items-center bg-success">
		<div class="card p-3 mx-auto border-success main col-7">
			<div class="card-body text-black">
				<div class="container-fluid overlay-container">
					<div class="row">
						<div class="col">
							<div class="card p-3 mx-5 h-100 border-0">
								<div class="card-body">
									<h4 class="card-text">PERSONAL DETAILS</h4>
									<hr>
									<div
										class="d-flex align-items-center justify-content-between mb-4">
										<div class="input-group">
											<span class="input-group-text">First name</span> <input
												type="text" class="form-control"> <span
												class="input-group-text">Last name</span> <input type="text"
												class="form-control">
										</div>
									</div>
									<div
										class="d-flex align-items-center justify-content-between mb-4">
										<div class="input-group">
											<span class="input-group-text">Email Address</span> <input
												type="email" class="form-control">
										</div>
									</div>
									<div
										class="d-flex align-items-center justify-content-between mb-4">
										<div class="input-group">
											<span class="input-group-text">Password</span> <input
												type="password" class="form-control">
										</div>
									</div>
									<h4 class="card-text">PAYMENT METHOD</h4>
									<hr>
									<h6>E-WALLET PAYMENT</h6>
									<div class="d-inline align-items-center mb-4">
										<div class="form-check">
											<input class="form-check-input" type="radio"
												name="paymentMethod" id="gcashRadio"
												onclick="generateReferenceNumber()"> <label
												class="form-check-label" for="gcashRadio"> GCash </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio"
												name="paymentMethod" id="mayaRadio"
												onclick="generateReferenceNumber()"> <label
												class="form-check-label" for="mayaRadio"> MAYA </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio"
												name="paymentMethod" id="gotymeRadio"
												onclick="generateReferenceNumber()"> <label
												class="form-check-label" for="gotymeRadio"> GoTYME </label>
										</div>
									</div>


								</div>
							</div>
						</div>



					</div>
				</div>

				<div class="card p-3 mx-5 h-100 border-0 hidden"
					id="paymentDetailsGcash">
					<div class="card-body">
						<!-- GCash payment details content here -->
						<div class="d-flex justify-content-center">
							<img src="/images/logo/gcashLogo.png">
						</div>

						<div class="form-group p-3 m-3">
							<label for="gcashAmount">GCash Number:</label> <input
								type="number" class="form-control" id="gcashAmount" required>
						</div>
						<div class="form-group p-3 m-3">
							<label for="gcashAmount">Amount to be paid:</label> <input
								type="number" class="form-control" id="gcashAmount" required>
						</div>
						<div class="form-group p-3 m-3">
							<label for="referenceNumberInputGcash">Reference number:</label>
							<input type="number" class="form-control"
								id="referenceNumberInputGcash" disabled>
						</div>
						<div class="d-flex justify-content-center">
							<button type="button" class="btn btn-success">Pay</button>
						</div>
					</div>
				</div>

				<div class="card p-3 mx-5 h-100 border-0 hidden"
					id="paymentDetailsMaya">
					<div class="card-body">
						<!-- Maya payment details content here -->
						<div class="d-flex justify-content-center">
							<img src="/images/logo/mayaLogo.png">
						</div>
						<div class="form-group p-3 m-3">
							<label for="mayaAmount">Maya Number:</label> <input type="number"
								class="form-control" id="mayaAmount" required>
						</div>
						<div class="form-group p-3 m-3">
							<label for="mayaAmount">Amount to be paid:</label> <input
								type="number" class="form-control" id="mayaAmount" required>
						</div>
						<div class="form-group p-3 m-3">
							<label for="referenceNumberInputMaya">Reference number:</label> <input
								type="number" class="form-control" id="referenceNumberInputMaya"
								disabled>
						</div>
						<div class="d-flex justify-content-center">
							<button type="button" class="btn btn-success">Pay</button>
						</div>
					</div>
				</div>

				<div class="card p-3 mx-5 h-100 border-0 hidden"
					id="paymentDetailsGotyme">
					<div class="card-body">
						<!-- GoTYME payment details content here -->
						<div class="d-flex justify-content-center">
							<img src="/images/logo/gotymeLogo.png">
						</div>
						<div class="form-group p-3 m-3">
							<label for="gotymeAmount">GoTYME Number:</label> <input
								type="number" class="form-control" id="gotymeAmount" required>
						</div>
						<div class="form-group p-3 m-3">
							<label for="gotymeAmount">Amount to be paid:</label> <input
								type="number" class="form-control" id="gotymeAmount" required>
						</div>
						<div class="form-group p-3 m-3">
							<label for="referenceNumberInputGotyme">Reference number:</label>
							<input type="number" class="form-control"
								id="referenceNumberInputGotyme" disabled>
						</div>
						<div class="d-flex justify-content-center">
							<button type="button" class="btn btn-success">Pay</button>
						</div>
					</div>


				</div>


			</div>

		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script>
    document.addEventListener('DOMContentLoaded', function () {
        const paymentDetailsGcash = document.getElementById('paymentDetailsGcash');
        const paymentDetailsMaya = document.getElementById('paymentDetailsMaya');
        const paymentDetailsGotyme = document.getElementById('paymentDetailsGotyme');

        document.querySelectorAll('input[type="radio"]').forEach(radio => {
            radio.addEventListener('click', function () {
                if (this.checked && this.id === 'gcashRadio') {
                    paymentDetailsGcash.classList.remove('hidden');
                    paymentDetailsMaya.classList.add('hidden');
                    paymentDetailsGotyme.classList.add('hidden');
                } else if (this.checked && this.id === 'mayaRadio') {
                    paymentDetailsGcash.classList.add('hidden');
                    paymentDetailsMaya.classList.remove('hidden');
                    paymentDetailsGotyme.classList.add('hidden');
                } else if (this.checked && this.id === 'gotymeRadio') {
                    paymentDetailsGcash.classList.add('hidden');
                    paymentDetailsMaya.classList.add('hidden');
                    paymentDetailsGotyme.classList.remove('hidden');
                } else {
                    paymentDetailsGcash.classList.add('hidden');
                    paymentDetailsMaya.classList.add('hidden');
                    paymentDetailsGotyme.classList.add('hidden');
                }
            });
        });

        document.querySelectorAll('.btn-success').forEach(button => {
            button.addEventListener('click', function () {
                const payButton = this;
                payButton.textContent = 'Pay';
                setTimeout(function () {
                    payButton.textContent = 'Paid';
                }, 2000);
            });
        });
    });

    function generateReferenceNumber() {
        const referenceNumberInputGcash = document.getElementById('referenceNumberInputGcash');
        const referenceNumberInputMaya = document.getElementById('referenceNumberInputMaya');
        const referenceNumberInputGotyme = document.getElementById('referenceNumberInputGotyme');

        const referenceNumber = Math.floor(100000 + Math.random() * 900000); // Generate a random 6-digit number

        if (document.getElementById('gcashRadio').checked) {
            referenceNumberInputGcash.value = referenceNumber;
        } else if (document.getElementById('mayaRadio').checked) {
            referenceNumberInputMaya.value = referenceNumber;
        } else if (document.getElementById('gotymeRadio').checked) {
            referenceNumberInputGotyme.value = referenceNumber;
        }
    }

    </script>
</body>

</html>
