(function ($) {
	$('.cancelButton').on('click', function(){
		let booking_id = $(this).attr('data-bs-booking_id');
		$('#cancel-booking-button').unbind('click');
		
		$('#cancel-booking-button').bind( "click", function() {
		 	$.ajax({
				type:'POST',
				url: 'userDashboard/cancel/'+booking_id
			})
		});
	})
	
	$('#CardPayment').on('click', function(){
		$('#payment-fields').html(
			`
				<div class="payment-field">Enter Card Number: <input type="number"/></div>
				<div class="payment-field">Enter Expiration: 
					<select>
						<option selected>Month</option>
						<option>01</option>
						<option>02</option>
						<option>03</option>
						<option>04</option>
						<option>05</option>
						<option>07</option>
						<option>08</option>
						<option>09</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select>
					<select>
						<option selected>Year</option>
						<option>2024</option>
						<option>2025</option>
						<option>2026</option>
						<option>2027</option>
					</select>
				</div>
			`
		);
	})
	
	$('#Gcash').on('click', function(){
		$('#payment-fields').html(
			`
				<div class="payment-field">Enter OTP <input type="number"/><div>
				<div class="payment-field">Enter MPIN <input type="number"/></div>
			`
		);
	})
	
	$('#Paymaya').on('click', function(){
		$('#payment-fields').html(
			`
				<div class="payment-field">Enter OTP <input type="number"/><div>
				<div class="payment-field">Enter MPIN <input type="number"/></div>
			`
		);
	})
	
	$('.payment-button').on('click', function(){
		$('#confirm-payment').unbind('click');
		
		let booking_id = $(this).attr('data-bs-booking_id');
		let total_price = $(this).attr('data-bs-price');
		
		$('#payment-price').text(total_price);
		$('#payment-price-hidden').text(total_price);
		
		$('#confirm-payment').bind( "click", function() {
			let paymentMethod;
			let loyalty_payment = Number( $('#loyalty-select').val() );
			
			$('.payment-radio-name').each(function () {
				if($(this).attr('checked', 'checked') ){
					paymentMethod = $(this).attr('value');
				}
			})
			
			let voucherInput = $('#voucherField').val();
			if (voucherInput == ''){
				voucherInput = 'none';
			}
			console.log(voucherInput)
			console.log(booking_id);
		 	$.ajax({
				type:'POST',
				url: 'userDashboard/confirmPayment/'+booking_id+'/'+ paymentMethod +'/'+voucherInput+'/'+loyalty_payment,
				success: function(dat){
					console.log(dat);
					location.reload();
				}
			})
			
		});
	})
	
	$('#check-voucher').on('click', function(){
		let voucherInput = $('#voucherField').val();
		let total_price = Number( $('#payment-price-hidden').text() );
		$.ajax({
			type:'POST',
			url: 'userDashboard/checkVoucher/'+voucherInput+"/"+total_price,
			success: function (dat) {
				$('#payment-price').text(dat);
			}
		})
		
		
	})
})(jQuery);