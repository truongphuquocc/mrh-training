const TEMPLATE_PRODUCT = "<li class='product-info'>"
	+ "<a href='/detailproduct?id=<%=productId%>'>"
	+ "<div class='prod-avatar'>"
	+ "<img src='<%= image %>'></div>"
	+ "<div class='prod-name'><%= productName %></div>"
	+ "<div class='prod-price'> <%= price %>"
	+ "</div>"
	+ "</a>"
	+ "</li>"
var ProductOfBrand = (function() {
	return function() {
		var _self = this;
		_self.$productInfo = $('.productInfo');

		_self.getProduct = function() {
			// Search Brand by keyword
			var url = new URL(window.location.href)
			console.log(url + "url")
			let searchData = {
				brandId: url.searchParams.get("brandid").toString()
			};
			console.log(searchData.brandId + "brandid")
			$.ajax({
				url: '/productofbrand/api/getall',
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.drawProductContent(responseData.data);
					}
				},
			});
		};

		_self.drawProductContent = function(data) {
			$.each(data.productsListUser2, function(key, value) {
				_self.$productInfo.append(_self.templateList.productInfoRowTemplate(value));
			});

		};


		_self.templateList = {
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT),
		};
		_self.initialize = function() {
			_self.getProduct();
		};
	};
})();
(function(productOfBrand) {
	$(document).ready(function() {
		productOfBrand.initialize();
	});
})(new ProductOfBrand());