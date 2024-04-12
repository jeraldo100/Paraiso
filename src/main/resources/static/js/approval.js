$(document).ready(function() {

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

                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Failed to update status: " + error);
            }
        });
    }
});

