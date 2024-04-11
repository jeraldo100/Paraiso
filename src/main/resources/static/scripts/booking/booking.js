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
							<div class="img-and-body">
								<div class="room-image-wrapper">
									<img src="data:image/jpeg;base64,${rooms[i].roomImage}" alt="${rooms[i].name}"/>
								</div>
								<div class="room-body">
									<div class='room-name'>
										${rooms[i].name}
									</div>
									<div class='room-details'>
										<div class="detail">
											<p>Capacity:</p>${rooms[i].capacity}<i class="fa-solid fa-user"></i>
										</div>
										<div class="detail">
											<p>Beds:</p>${rooms[i].beds}<i class="fa-solid fa-bed"></i>
										</div>
										<div class="detail">
											<p>Bathrooms:</p>${rooms[i].bathrooms}<i class="fa-solid fa-bath"></i>
										</div>
									</div>
									<div class="description">
										${rooms[i].description}
									</div>
								</div>
							</div>
							<div class="room-footer">
								<div class="room-footer-left">
									Rooms Available: ${rooms[i].available}
								</div>
								<div class="room-footer-right">
									<div>
										Price per night: ${rooms[i].price_per_night}
									</div>
									<div 
										id="addRoomBtn" 
										class="${rooms[i].available < 1 ? "noRoomBtn": "addRoomBtn"}" 
										${rooms[i].available > 0 ? "onclick='addRoom(" + rooms[i].type_id + ")'": ""} 
									>
										${rooms[i].available < 1 ? "No Rooms Available": "Add Room"}
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
		let checkoutMinDate = `${Number(checkinDate[2])}, ${Number(checkinDate[1])}, ${Number(checkinDate[0])} `;
		checkoutMinDate = new Date(checkoutMinDate);
		checkoutMinDate.setDate(checkoutMinDate.getDate() + 1);
		return checkoutMinDate
	 }
    
    $("#checkin_date").on('change', function(){
		let minDate = setMinDate();
		$('#checkout_date').datepicker('destroy');
		$("#checkout_date").datepicker({
			dateFormat: "dd/mm/yy",
        	minDate: minDate,
    	});
    	
    	let day = minDate.getDate();
    	let month = minDate.getMonth() + 1;
    	
    	if(day < 10){
			day = "0" + day;
		}
		if(month < 10){
			month = "0" + month;
		}
    	
    	let minDateToString = `${day}/${month}/${minDate.getFullYear()}`;
    	$("#checkout_date").val(minDateToString);
	})
	
	/*Adults controls*/
	$('#adults-add').on('click', function(){
		let adults = $('#adults-number').val();
		if(adults <= 98){
			$('#adults-number').val(Number(adults)+1);
		}
	})
	
	$('#adults-minus').on('click', function(){
		let adults = $('#adults-number').val();
		if(adults >= 2){
			$('#adults-number').val(Number(adults)-1);
		}
	})
	
	/*Children controls*/
	$('#children-add').on('click', function(){
		let children = $('#children-number').val();
		if(children <= 98){
			$('#children-number').val(Number(children)+1);
		}
	})
	
	$('#children-minus').on('click', function(){
		let children = $('#children-number').val();
		if(children >= 1){
			$('#children-number').val(Number(children)-1);
		}
	})
	
	/* Confirm Booking button */
	$('#confirmBooking').on('click', function(){
		let checkin_date_val = $("#checkin_date").val();
		let checkout_date_val = $("#checkout_date").val();
		let adults_val = $('#adults-number').val();
		let children_val = $('#children-number').val();
		let arrival_time_val = $('#arrivalTime').val();
		
		let total_capacity = 0;
		let room_ids_val = '';
		$('.roomAdded-name').each(function () {
			let room_id = $(this).attr( "room_id" );
			total_capacity += Number( $(this).attr( "capacity" ) );
			room_ids_val += room_id+' ';
		});
		let add_ons_val = '';
		$('.addOnnCheck').each(function () {
			if( $(this).is(':checked') ){
				add_ons_val += $(this).val() + ' ';
			}
		});
		
		if ( !(room_ids_val == '') ){
			if( total_capacity >= (Number(adults_val) + Number(children_val)) ){
				$.ajax({
					type:'POST',			
					url: 'confirmBooking/',
					contentType: "application/json",
					dataType: 'json',
					data: JSON.stringify({ 
						checkin_date: checkin_date_val, 
						checkout_date: checkout_date_val,
						room_ids: room_ids_val,
						arrival_time: arrival_time_val,
						adults: adults_val,
						children: adults_val,
						add_ons: add_ons_val
				    }),
				    success: function (dat) {
						console.log(dat);
					}
				});
			}else{
				$('.booking-warning').html("Not Enough Rooms for Guests");
			}
		} else{
			$('.booking-warning').html('Please select a Room')
		}
	})
	
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
						<div class="roomAdded-name" room_id='${dat.room_id}' capacity='${dat.capacity}'>
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
			$('.addOnnCheck').each(function(){
				if($(this).is(':checked')){
					totalPrice += Number( $(this).attr( "amount" ) );
				}
			})
			
			totalPrice += dat.price_per_night;
			totalPrice = totalPrice * $('#total-days').attr( "days" );
			
			const options = {
				style: 'decimal',
				minimumFractionDigits: 2,
				maximumFractionDigits: 2,
			};
			$( '#roomList-totalPrice').html(totalPrice.toLocaleString('en-US', options));
			$( "#roomList-body" ).append( `${roomAdded}` );
		}
		
	})
}

// Add On Checkbox Toggle Button
function addOnToggle(addOn){
	let nights = $('#total-days').attr( "days" );
	let total_price = Number($('#roomList-totalPrice').text().replace(/\,/g, ''));
	let amount = $(addOn).attr( "amount" );
	const options = {
		style: 'decimal',
		minimumFractionDigits: 2,
		maximumFractionDigits: 2,
	};
	if( $(addOn).is(':checked') ){
		let newTotal_price = ( total_price + (amount * nights) ).toLocaleString('en-US', options);
		$('#roomList-totalPrice').html( newTotal_price );
	}else{
		let newTotal_price = ( total_price - (amount * nights) ).toLocaleString('en-US', options);
		$('#roomList-totalPrice').html( newTotal_price );
	}
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
							<div class="roomAdded-name" room_id='${dat[i].room_id}' capacity='${dat.capacity}'>
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
			
			$('.addOnnCheck').each(function(){
				if($(this).is(':checked')){
					totalPrice += Number( $(this).attr( "amount" ).replace(/\,/g, '') );
				}
			})
			
			totalPrice = totalPrice * $('#total-days').attr( "days" );
			
			$( '#roomList-body' ).html(roomsAddedHtml);
			const options = {
				style: 'decimal',
				minimumFractionDigits: 2,
				maximumFractionDigits: 2,
			};
			$( '#roomList-totalPrice').html(totalPrice.toLocaleString('en-US', options));
		}
	})
}