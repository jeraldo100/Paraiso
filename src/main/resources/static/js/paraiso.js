$(document).ready(function() {

    var disabledButtonInfo = localStorage.getItem('disabledButtonInfo');
    if (disabledButtonInfo) {
        disabledButtonInfo = JSON.parse(disabledButtonInfo); 
        var selector = "[data-booking-id='" + disabledButtonInfo.bookingId + "']." + disabledButtonInfo.buttonClass;
        $(selector).prop('disabled', true);
        localStorage.removeItem('disabledButtonInfo'); 
    }

    $(".approve-btn, .disapprove-btn").click(function() {
        var bookingId = $(this).data("booking-id");
        var status = $(this).hasClass("approve-btn") ? "Approved" : "Disapproved";
        var buttonClass = $(this).hasClass("approve-btn") ? "approve-btn" : "disapprove-btn";
        var button = $(this);
        updateStatus(bookingId, status, buttonClass, button);
    });

    function updateStatus(bookingId, status, buttonClass, button) {
        $.ajax({
            type: "POST",
            url: "/admin/updateStatus/" + bookingId + "?status=" + status,
            success: function(response) {
                console.log("Status updated successfully");

                var disabledButtonInfo = { bookingId: bookingId, buttonClass: buttonClass };
                localStorage.setItem('disabledButtonInfo', JSON.stringify(disabledButtonInfo));

                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Failed to update status: " + error);
            }
        });
    }
});

