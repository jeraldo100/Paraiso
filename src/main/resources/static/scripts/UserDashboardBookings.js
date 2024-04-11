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
				Enter Card Number: <input type="number"/>
				Enter Expiration: <input type="text"/>
			`
		);
	})
	
	$('#Gcash').on('click', function(){
		$('#payment-fields').html(
			`
				Enter OTP <input type="number"/>
				Enter MPIN <input type="number"/>
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
				url: 'userDashboard/confirmPayment/'+booking_id+'/'+ paymentMethod +'/'+voucherInput,
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