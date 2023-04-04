
$(function() {
	$(".datepicker").datepicker({
		language: "es",
		autoclose: true,
		format: "yyyy/mm/dd",
	});
});

$(document).ready(function() {
	$(".nav-item a").on("click", function() {
		$(".nav-item.active").removeClass("active");
		$(this).parent().addClass("active");
	}).filter(function() {
		return window.location.href.indexOf($(this).attr('href').trim()) > -1;
	}).click();
});