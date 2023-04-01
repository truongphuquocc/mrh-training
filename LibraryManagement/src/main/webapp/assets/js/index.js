$(function () {
  $(".datepicker").datepicker({
    language: "es",
    autoclose: true,
    format: "dd/mm/yyyy",
  });
});

$(".nav-item").on("click", function () {
  $(".nav-item").removeClass("active");
  $(this).addClass("active");
});
