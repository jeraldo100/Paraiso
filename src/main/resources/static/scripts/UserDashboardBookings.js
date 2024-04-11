(function ($) {
	$('.cancelButton').on('click', function(){
		let booking_id = $(this).attr('data-bs-booking_id');
		$('#cancel-booking-button').unbind('click');
		
		$('#cancel-booking-button').bind( "click", function() {
		 	$.ajax({
				type:'POST',
				url: 'userDashboard/cancel/'+booking_id
			})
			
			$.ajax({
				type:'GET',
				url: 'userDashboard'
			})
		});
	})
	
	$('.paymentButton').on('click', function(){
		let booking_id = $(this).attr('data-bs-booking_id');
		let total_price = $(this).attr('data-bs-price');
		
		$('.payment-price').text(total_price);
		
	})
})(jQuery);