(function ($) {
    'use strict';

    var browserWindow = $(window);
 
    if ($.fn.owlCarousel) {
        var welcomeSlide = $('.hero-slides');
        var testimonial = $('.testimonial-slides');

        welcomeSlide.owlCarousel({
            items: 1,
            margin: 0,
            loop: true,
            nav: false,
            dots: true,
            autoplay: true,
            autoplayTimeout: 7000,
            smartSpeed: 1000,
            animateIn: 'fadeIn',
            animateOut: 'fadeOut'
        });

        welcomeSlide.on('translate.owl.carousel', function () {
            var slideLayer = $("[data-animation]");
            slideLayer.each(function () {
                var anim_name = $(this).data('animation');
                $(this).removeClass('animated ' + anim_name).css('opacity', '0');
            });
        });

        welcomeSlide.on('translated.owl.carousel', function () {
            var slideLayer = welcomeSlide.find('.owl-item.active').find("[data-animation]");
            slideLayer.each(function () {
                var anim_name = $(this).data('animation');
                $(this).addClass('animated ' + anim_name).css('opacity', '1');
            });
        });

        $("[data-delay]").each(function () {
            var anim_del = $(this).data('delay');
            $(this).css('animation-delay', anim_del);
        });

        $("[data-duration]").each(function () {
            var anim_dur = $(this).data('duration');
            $(this).css('animation-duration', anim_dur);
        });

    }

    $('a[href="#"]').on('click', function ($) {
        $.preventDefault();
    });

    
    // Smooth scrolling for anchor links
    $(".nav-menu a, #mobile-nav a, .scrollto").on("click", function () {
        if (
            location.pathname.replace(/^\//, "") == this.pathname.replace(/^\//, "") &&
            location.hostname == this.hostname
        ) {
            var target = $(this.hash);
            if (target.length) {
                var top_space = 0;
                if ($("#header").length) {
                    top_space = $("#header").outerHeight();
                    if (!$("#header").hasClass("header-fixed")) {
                        top_space = top_space;
                    }
                }
                $("html, body").animate(
                    {
                        scrollTop: target.offset().top - top_space,
                    },
                    1500,
                    "easeInOutExpo"
                );
                // Update active menu item on click
                if ($(this).parents(".nav-menu").length) {
                    $(".nav-menu .menu-active").removeClass("menu-active");
                    $(this).closest("li").addClass("menu-active");
                }
                // Close mobile navigation after selecting an item
                if ($("body").hasClass("mobile-nav-active")) {
                    $("body").removeClass("mobile-nav-active");
                    $("#mobile-nav-toggle i").toggleClass("fa-solid fa-xmark fa-solid fa-bars");
                    $("#mobile-body-overly").fadeOut();
                }
                return false;
            }
        }
    });

    // Additional document.ready functions for handling specific navigation and layout adjustments
    $(document).ready(function () {
        // Hide the page initially, show it once everything is loaded correctly
        $("html, body").hide();
        if (window.location.hash) {
            setTimeout(function () {
                $("html, body").scrollTop(0).show();
                $("html, body").animate(
                    {
                        scrollTop: $(window.location.hash).offset().top - 108,
                    },
                    1000
                );
            }, 0);
        } else {
            $("html, body").show();
        }
    });

    // Highlight the active menu item based on the current page
    jQuery(document).ready(function ($) {
        var path = window.location.pathname.split("/").pop();
        if (path == "") {
            path = "index.html";
        }
        var target = $('nav a[href="' + path + '"]');
        target.addClass("menu-active");
    });

    // Ensure parent menu items remain highlighted when a child item is active
    $(document).ready(function () {
        if ($(".menu-has-children ul>li a").hasClass("menu-active")) {
            $(".menu-active")
                .closest("ul")
                .parentsUntil("a")
                .addClass("parent-active");
        }
    });

    // Add or remove a class to the header based on the scroll position
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $("#header").addClass("header-scrolled");
        } else {
            $("#header").removeClass("header-scrolled");
        }
    });

})(jQuery);