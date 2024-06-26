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
	
	/**$("#checkAvailability").on("click",function(e){
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
	}) **/
		
	
})(jQuery);

// add room
function addRoom(type_id){
	let checkin_date_val = $("#checkin_date").val();
	let checkout_date_val = $("#checkout_date").val();
	
	let room_ids_val = '';
	$('.roomAdded-name').each(function () {
		let room_id = $(this).attr( "room_id" );
		room_ids_val += room_id+' ';
	});
	
	console.log(room_ids_val);
	
	$.ajax({
		type:'POST',			
		url: 'addRoom/' + type_id,
		contentType: "application/json",
		dataType: 'json',
		data: JSON.stringify({ 
			checkin_date: checkin_date_val, 
			checkout_date: checkout_date_val,
			room_ids: room_ids_val
	    }),
		success: function (dat) {
			console.log(dat)
			let roomAdded = `
				<div class="roomAdded">
					<div class="room-added-details">
						<div class="roomAdded-name" room_id='${dat.room_id}'>
							${dat.name} / room_id: ${dat.room_id}
						</div>
						<div id="roomAdded-price" class="roomAdded-price" price="${dat.price_per_night}">
							Price: ${dat.price_per_night}
						</div>
					</div>
					<div id="trash-btn" onclick="removeRoom(${dat.room_id})">
						<i class="fa-solid fa-trash"></i>
					</div>
				</div>
				
			`;
			
			let totalPrice = 0;
			$('.roomAdded-price').each(function () {
				let price = $(this).attr( "price" );
				totalPrice += Number(price);
			});
			
			totalPrice += dat.price_per_night;
			totalPrice = totalPrice * $('#total-days').attr( "days" )
			
			$( '#roomList-totalPrice').html(totalPrice);
			$( "#roomList-body" ).append( `${roomAdded}` );
		}
		
	})
}

// Remove Room
function removeRoom(room_id){
	
	let room_ids_val = [];
	$('.roomAdded-name').each(function () {
		let room_id = $(this).attr( "room_id" );
		room_ids_val.push(Number(room_id));
	});
	
	$.ajax({
		type:'POST',			
		url: 'removeRoom/' + room_id,
		contentType: "application/json",
		dataType: 'json',
		data: JSON.stringify({ 
			room_ids: room_ids_val
	    }),
	    success: function (dat) {
			console.log(dat);
			let roomsAddedHtml = '';
			let totalPrice = 0;
			for(i = 0;i<dat.length;i++){
				totalPrice += dat[i].price_per_night;
				roomsAddedHtml += `
					<div class="roomAdded">
						<div class="room-added-details">
							<div class="roomAdded-name" room_id='${dat[i].room_id}'>
								${dat[i].name} / room_id: ${dat[i].room_id}
							</div>
							<div id="roomAdded-price" class="roomAdded-price" price="${dat[i].price_per_night}">
								Price: ${dat[i].price_per_night}
							</div>
						</div>
						<div id="trash-btn" onclick="removeRoom(${dat[i].room_id})">
							<i class="fa-solid fa-trash"></i>
						</div>
					</div>
				
				`;
			}
			$( '#roomList-body' ).html(roomsAddedHtml);
			$( '#roomList-totalPrice').html(totalPrice);
		}
	})
}