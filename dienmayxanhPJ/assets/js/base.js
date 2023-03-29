$(".btn-all-product ").click(function (e) {
  e.preventDefault();
  $(this).addClass("d-none");
});

// Ẩn hiện banner
$(window).on("scroll", function () {
  let height = window.scrollY;
  if (height > 397) {
    $(".banner-left").fadeIn(200);
    $(".banner-right").fadeIn(200);
  } else {
    $(".banner-left").fadeOut(200);
    $(".banner-right").fadeOut(200);
  }
});

// $(document).ready(function () {
//   $("#hover").hover(function () {
//     $(".submenu").css("display", "flex");
//   });
// });

// $("#hover").hover(
//   function () {
//     $(".submenu").css("display", "flex");
//     // $(".submenu").removeClass("d-none")
//   },
//   // function () {
//   //   $(".submenu").addClass("d-none");
//   // }
// );

// function gfg_Run() {
//   $('#div').off('mouseenter mouseleave');
//   $(".submenu").addClass("d-none");
// }

// gfg_Run()
