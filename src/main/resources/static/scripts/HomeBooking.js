(function ($) {
    // Enhance select elements with nicer styling
    $("select").niceSelect();

    // Initialize today's date variables
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; 
    var yyyy = today.getFullYear();
    
    // Add leading zero to day if less than 10
    if (dd < 10) {
        dd = "0" + dd;
    }
    if (mm < 10){
		mm = "0" + mm;
	}

    // Format today's date as "DD MM YYYY"
    var today = dd + "/" + mm + "/" + yyyy;


    // Set formatted date as value for check-in and check-out inputs
    $(".check-in").val(today);
    $(".check-out").val(today);

    // Initialize datepicker with specific format and disallow past dates
    $(".datepicker-pop").datepicker({
        dateFormat: "dd/mm/yy",
        minDate: 1,
    });
    
     $("#checkout_date").attr('disabled','disabled');
     
     function setMinDate(){
		let checkinDate = $("#checkin_date").val().split('/');
		let checkoutMinDate = `${Number(checkinDate[2])}, ${Number(checkinDate[1])}, ${Number(checkinDate[0])} `;
		checkoutMinDate = new Date(checkoutMinDate);
		checkoutMinDate.setDate(checkoutMinDate.getDate() + 1);
		return checkoutMinDate
	 }
    
    $("#checkin_date").on('change', function(){
		let minDate = setMinDate();
		$("#checkout_date").removeAttr('disabled');
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
})(jQuery);