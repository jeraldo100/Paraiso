(function ($) {
    'use strict';

    var browserWindow = $(window);
    // Calculate dimensions for responsive elements
    var window_width = $(window).width(),
        window_height = window.innerHeight,
        header_height = $(".default-header").height(),
        header_height_static = $(".site-header.static").outerHeight(),
        fitscreen = window_height - header_height;

    // Set fullscreen elements to match the window height and fitscreen elements to adjust according to the header
    $(".fullscreen").css("height", window_height);
    $(".fitscreen").css("height", fitscreen);

    // Enhance the navigation menu with superfish plugin for smooth opening and closing animations
    $(".nav-menu").superfish({
        animation: { opacity: "show" },
        speed: 400,
    });

    // Mobile navigation setup: clone the main navigation, adjust its ID and classes, and append it to the main menu container
    if ($("#nav-menu-container").length) {
        var $mobile_nav = $("#nav-menu-container").clone().prop({
            id: "mobile-nav",
        });
        $mobile_nav.find("> ul").attr({
            class: "",
            id: "",
        });
        $("body .main-menu").append($mobile_nav);
        // Add a mobile navigation toggle button and an overlay for mobile view
        $("body .main-menu").prepend(
            '<button type="button" id="mobile-nav-toggle"><span id="lnr" style="color:white;display:block;margin: 0 auto;" class="fa-solid fa-bars"></span></button>'
        );
        $("body .main-menu").append('<div id="mobile-body-overly"></div>');
        // Add dropdown toggles to multi-level menus in the mobile navigation
        $("#mobile-nav")
            .find(".menu-has-children")
            .prepend('<i class="lnr lnr-chevron-down"></i>');
        // Toggle submenus in the mobile navigation
        $(document).on("click", ".menu-has-children i", function (e) {
            $(this).next().toggleClass("menu-item-active");
            $(this).nextAll("ul").eq(0).slideToggle();
            $(this).toggleClass("lnr-chevron-up lnr-chevron-down");
        });
        // Toggle the visibility of the mobile navigation and overlay
        $(document).on("click", "#mobile-nav-toggle", function (e) {
            $("body").toggleClass("mobile-nav-active");
            $("#mobile-nav-toggle i").toggleClass("lnr-cross lnr-menu");
            $("#mobile-body-overly").toggle();
        });
        // Close the mobile navigation when clicking outside of it
        $(document).on("click", function (e) {
            var container = $("#mobile-nav, #mobile-nav-toggle");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                if ($("body").hasClass("mobile-nav-active")) {
                    $("body").removeClass("mobile-nav-active");
                    $("#mobile-nav-toggle i").toggleClass("lnr-cross lnr-menu");
                    $("#mobile-body-overly").fadeOut();
                }
            }
        });
    } else if ($("#mobile-nav, #mobile-nav-toggle").length) {
        // Hide mobile navigation elements if they exist but the main container does not
        $("#mobile-nav, #mobile-nav-toggle").hide();
    }

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
                    $("#mobile-nav-toggle i").toggleClass("lnr-times lnr-bars");
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

})(jQuery);