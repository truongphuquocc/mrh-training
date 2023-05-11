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
		var url = new URL(window.location.href)
		var brandId2 = url.searchParams.get("brandid").toString()

		_self.getProduct = function() {
			// Search Brand by keyword
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

		_self.searchBrands = function() {
			// Search Brand by keyword
			let searchData = {
				keyword: $('#keyword').val(),
			};

			$.ajax({
				url: 'home/api/getall',
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.renderTitle(responseData.data);
					}
				},
			});
		};

		_self.drawProductContent = function(data) {
			$.each(data.productsListUser2, function(key, value) {
				value.price = value.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })
				_self.$productInfo.append(_self.templateList.productInfoRowTemplate(value));
			});

		};

		_self.renderTitle = function(data) {
			// Render title
			$.each(data.brandsList, function(key, value) {
				if (Number(brandId2) === value.brandId) {
					$(document).attr("title", `Điện thoại ${value.brandName} giảm từ 14-27% chính hãng, giá rẻ`);
				}
			});
		}


		_self.templateList = {
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT),
		};
		_self.initialize = function() {
			_self.getProduct();
			_self.searchBrands();
		};
	};
})();
(function(productOfBrand) {
	$(document).ready(function() {
		productOfBrand.initialize();
	});
})(new ProductOfBrand());