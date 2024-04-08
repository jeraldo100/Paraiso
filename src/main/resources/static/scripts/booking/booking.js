(function ($) {
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
		console.log(contextPath + 'checkAvailability');
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