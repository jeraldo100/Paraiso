(function ($) {
  var carousel = function () {
    $(".carousel-testimony").owlCarousel({
      autoplay: true,
      loop: true,
      items: 2,
      margin: 100,
      stagePadding: 0,
      nav: false,
      navText: [
        '<span class="ion-ios-arrow-back">',
        '<span class="ion-ios-arrow-forward">',
      ],
      responsive: {
        0: {
          items: 1,
        },
        600: {
          items: 1,
        },
        1000: {
          items: 2,
        },
      },
    });
  };


	document.addEventListener('touchstart', function onTouchStart() {
	  }, { passive: true });

	  
  carousel();
})(jQuery);
