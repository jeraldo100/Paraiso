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

    // Format today's date as "DD MM YYYY"
    var today = dd + "/" + mm + "/" + yyyy;


    // Set formatted date as value for check-in and check-out inputs
    $(".check-in").val(today);
    $(".check-out").val(today);

    // Initialize datepicker with specific format and disallow past dates
    $("#checkin_date").datepicker({
        dateFormat: "dd/mm/yy",
        minDate: 1,
    });
    
     $("#checkout_date").attr('disabled','disabled');
     
     function setMinDate(){
		let checkinDate = $("#checkin_date").val().split('/');
		let checkoutMinDate = `${Number(checkinDate[2])}, ${Number(checkinDate[1])}, ${Number(checkinDate[0]) + 1} `;
		console.log(checkoutMinDate)
		return new Date(checkoutMinDate)
	 }
    
    $("#checkin_date").on('change', function(){
		/*let checkinDate = $("#checkin_date").val().split('/');*/
		console.log('changed');
		$("#checkout_date").removeAttr('disabled');
		$('#checkout_date').datepicker('destroy');
		$("#checkout_date").datepicker({
        	minDate: setMinDate(),
    	});
	})
})(jQuery);