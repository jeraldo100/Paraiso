(function ($) {
	// Get all rooms on page load
    $(window).on('load', function() {
		console.log("reached");
		let checkin_date_val = $("#checkin_date").val();
		let checkout_date_val = $("#checkout_date").val();
		
		$.ajax({
			type:'POST',
			url: 'booking/getRooms',
			contentType: "application/json",
			dataType: 'json',
			data: JSON.stringify({ 
		        checkin_date: checkin_date_val, 
		        checkout_date: checkout_date_val
      		}),
      		success: function (dat) {
				// fetch all data from controller and display into html
		        console.log(dat);
		        let rooms = dat;
				console.log(dat[0].name);
				let roomsHtml = '';
				
				for(i = 0;i<rooms.length;i++){
					roomsHtml += `
						<div class='room'>
							<div class='room-name'>
								${rooms[i].name}
							</div>
							<div class='room-details'>
								<div class="detail">
									Capacity: ${rooms[i].capacity}
								</div>
								<div class="detail">
									Beds: ${rooms[i].beds}
								</div>
								<div class="detail">
									Bathrooms: ${rooms[i].bathrooms}
								</div>
							</div>
							<div class="description">
								${rooms[i].description}
							</div>
							<div class="room-footer">
								<div class="room-footer-left">
									Rooms Available: ${rooms[i].available}
								</div>
								<div class="room-footer-right">
									<div>
										Price per night: ${rooms[i].price_per_night}
									</div>
									<div id="addRoomBtn" onclick="addRoom(${rooms[i].type_id})">
										Add Room
									</div>
								</div>
							</div>
						</div>
					`;
					
				}
				$('#roomsWrapper').html(roomsHtml);
		    }
		})
	});
    
    // Initialize datepicker with specific format and disallow past dates
    $("#checkin_date").datepicker({
        dateFormat: "dd/mm/yy",
        minDate: 1,
    });
    
    $("#checkout_date").datepicker({
		dateFormat: "dd/mm/yy",
        minDate: setMinDate(),
    });
     
     function setMinDate(){
		let checkinDate = $("#checkin_date").val().split('/');
		let checkoutMinDate = `${Number(checkinDate[2])}, ${Number(checkinDate[1])}, ${Number(checkinDate[0]) + 1} `;
		return new Date(checkoutMinDate)
	 }
    
    $("#checkin_date").on('change', function(){
		$('#checkout_date').datepicker('destroy');
		$("#checkout_date").datepicker({
			dateFormat: "dd/mm/yy",
        	minDate: setMinDate(),
    	});
    	$("#checkout_date").val($("#checkin_date").val());
	})
	
	$("#checkAvailability").on("click",function(e){
		e.preventDefault();
		let checkin_date = $("#checkin_date").val();
		let checkout_date = $("#checkout_date").val();
		$.ajax({
			type:'POST',
			url: contextPath + 'checkAvailability',
			data: { 
		        'checkin_date': checkin_date, 
		        'checkout_date': checkout_date
      		},
		})
	})
		
	
})(jQuery);

// add room
function addRoom(type_id){
	let checkin_date_val = $("#checkin_date").val();
	let checkout_date_val = $("#checkout_date").val();
	
	$.ajax({
		type:'POST',			
		url: 'addRoom/' + type_id,
		contentType: "application/json",
		dataType: 'json',
		data: JSON.stringify({ 
			checkin_date: checkin_date_val, 
			checkout_date: checkout_date_val
	    }),
		success: function (dat) {
			console.log(dat)
		}
		
	})
}