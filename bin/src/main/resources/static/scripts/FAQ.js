$(document).ready(function() {
    // Add click event listener to collapsed items
    $('.collapsed').on('click', function() {
        // Toggle the 'collapsed' class to change the arrow direction
        $(this).toggleClass('collapsed');

        // Get the target collapsible content by data-target attribute
        var target = $($(this).data('target'));

        // Toggle the 'show' class to collapse or expand the content
        target.collapse('toggle');
    });

});
