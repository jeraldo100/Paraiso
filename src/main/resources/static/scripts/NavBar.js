$(document).ready(function() {
    "use strict";
     // Calculate dimensions for responsive elements
    var window_width = $(window).width(),
        window_height = window.innerHeight,
        header_height = $(".default-header").height(),
        header_height_static = $(".site-header.static").outerHeight(),
        fitscreen = window_height - header_height;

    // Set fullscreen elements to match the window height and fitscreen elements to adjust according to the header
    $(".fullscreen").css("height", window_height);
    $(".fitscreen").css("height", fitscreen);
    
$(document).on("click", ".menu-has-children > a", function (e) {
    e.preventDefault();

    var $ul = $(this).siblings("ul");
    $ul.toggleClass("menu-item-active");
    $ul.slideToggle();

    // Find the <i> element inside the clicked anchor tag
    var $icon = $(this).find("i.fa-solid");

    // Toggle between "fa-chevron-down" and "fa-chevron-up"
    $icon.toggleClass("fa-chevron-down fa-chevron-up");
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

        $("body .main-menu").prepend(
            '<button type="button" id="mobile-nav-toggle"><span style="color:white;display:block;margin: 0 auto;" class="fa-solid fa-bars"></span></button>'
        );
 
 
        $("#mobile-nav")
            .find(".menu-has-children")
            
            .prepend('<i class="lnr fa-solid fa-chevron-down"></i>');
            
        $(document).on('click', '.menu-has-children i', function(e) {
            $(this).next().toggleClass('menu-item-active');
            $(this).nextAll('ul').eq(0).slideToggle();
            $(this).toggleClass("lnr-chevron-up lnr-chevron-down");
        });



        // Toggle the visibility of the mobile navigation and overlay
        $(document).on("click", "#mobile-nav-toggle", function (e) {
            $("body").toggleClass("mobile-nav-active");
            $("#mobile-nav-toggle i").toggleClass("fa-solid fa-xmark fa-solid fa-bars");

        });
        
        // Close the mobile navigation when clicking outside of it
        $(document).on("click", function (e) {
            var container = $("#mobile-nav, #mobile-nav-toggle");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                if ($("body").hasClass("mobile-nav-active")) {
                    $("body").removeClass("mobile-nav-active");
                    $("#mobile-nav-toggle i").toggleClass("fa-solid fa-xmark fa-solid fa-bars");
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
});