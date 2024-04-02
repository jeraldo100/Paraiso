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

    // Array of month names for conversion
    var mS = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    var month;

    // Convert month number to month name
    for (let i = 0; i <= 12; i++) {
        const element = mS[i];
        if (mm == mS.indexOf(mS[i])) {
            month = mS[i - 1];
        }
    }

    // Format today's date as "DD MMM YYYY"
    var today = dd + " " + month + " " + yyyy;

    // Set formatted date as value for check-in and check-out inputs
    $(".check-in").val(today);
    $(".check-out").val(today);

    // Initialize datepicker with specific format and disallow past dates
    $(".datepicker-pop").datepicker({
        dateFormat: "dd M yy",
        minDate: 0,
    });
})(jQuery);