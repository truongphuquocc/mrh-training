

$(".nav-item").on("click", function () {
  $(".nav-item").removeClass("active");
  $(this).addClass("active");
});


$(function () {
  $(".datepicker").datepicker({
    language: "es",
    autoclose: true,
    format: "yyyy/mm/dd",
  });
});

$(".nav-item").on("click", function () {
  $(".nav-item").removeClass("active");
  $(this).addClass("active");
});
