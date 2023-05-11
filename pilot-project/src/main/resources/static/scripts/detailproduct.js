var Detail = (function() {
	return function() {
		var _self = this;
		_self.$price = $(".price");

		_self.$price.each(function(key, value) {
			$(value).text(Number($(value).text()).toLocaleString('Vn-VN', {style: 'currency', currency: 'VND'}));
		});
	};

}());
(function(detail) {
	$(document).ready(function() {
		detail.initialize();
	});
})(new Detail());