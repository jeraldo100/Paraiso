(function ($) {
    'use strict';

    if ($.fn.datepicker) {
        $('.input-daterange').datepicker({
            format: "dd/mm/yy",
            multidate: true,
            keyboardNavigation: false,
            forceParse: false,
            daysOfWeekHighlighted: "0,1,2,3,4,5,6",
            todayHighlight: true
        });
    }

})(jQuery);