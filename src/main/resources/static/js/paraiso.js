$(document).ready(function() {
    // Check if there's a button to be disabled
    var disabledButtonInfo = localStorage.getItem('disabledButtonInfo');
    if (disabledButtonInfo) {
        disabledButtonInfo = JSON.parse(disabledButtonInfo); // Parse the JSON string
        var selector = "[data-booking-id='" + disabledButtonInfo.bookingId + "']." + disabledButtonInfo.buttonClass;
        $(selector).prop('disabled', true);
        localStorage.removeItem('disabledButtonInfo'); // Clean up
    }

    $(".approve-btn, .disapprove-btn").click(function() {
        var bookingId = $(this).data("booking-id");
        var status = $(this).hasClass("approve-btn") ? "Approved" : "Disapproved";
        var buttonClass = $(this).hasClass("approve-btn") ? "approve-btn" : "disapprove-btn";
        var button = $(this); // Save a reference to the clicked button
        updateStatus(bookingId, status, buttonClass, button);
    });

    function updateStatus(bookingId, status, buttonClass, button) {
        $.ajax({
            type: "POST",
            url: "/updateStatus/" + bookingId + "?status=" + status,
            success: function(response) {
                console.log("Status updated successfully");
                // Store the bookingId and button class in local storage before reloading
                var disabledButtonInfo = { bookingId: bookingId, buttonClass: buttonClass };
                localStorage.setItem('disabledButtonInfo', JSON.stringify(disabledButtonInfo));
                // Refresh the page
                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Failed to update status: " + error);
            }
        });
    }
});

