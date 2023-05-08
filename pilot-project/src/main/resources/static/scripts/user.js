const TEMPLATE_BRAND = "<a class='dropdown-item btn-dropdown' data-id='<%=brandId%>' href='/productofbrand?brandid=<%=brandId%>'>"
	+ "<img src='<%= logo %>'></a>"

const TEMPLATE_PRODUCT = "<li class='product-info'>"
	+ "<div class='prod-avatar'>"
	+ "<a data-toggle='lightbox' data-max-width='1000' href='<%= image %>'><img src='<%= image %>'></a></div>"
	+ "<div class='prod-name'><%= productName %></div>"
	+ "<div class='prod-price'> <%= price %>"
	+ "</div>"
	+ "</li>"
var Brand = (function() {
	return function() {
		var _self = this;
		_self.currentPageNumber = 1;
		_self.$brandInfo = $('.brandInfo');
		_self.$productInfo = $('.productInfo');
		_self.$paginator = $('ul.pagination');

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
						_self.drawBrandContent(responseData.data);
					}
				},
			});
		};

		_self.getProduct = function() {
			// Search Brand by keyword
			let searchData = {
				keyword: $('#keyword').val(),
				currentPage: Number(_self.currentPageNumber),
			};

			$.ajax({
				url: 'home/api/getproduct',
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.drawProductContent(responseData.data);
					}
					console.log(responseData);
				},
			});
		};
		_self.drawBrandContent = function(data) {
			// Render table content
			$.each(data.brandsList, function(key, value) {
				_self.$brandInfo.append(_self.templateList.brandInfoRowTemplate(value));
			});
		}

		_self.drawProductContent = function(data) {
			_self.$paginator.empty();
			_self.$productInfo.empty();

			$.each(data.productsListUser, function(key, value) {
				_self.$productInfo.append(_self.templateList.productInfoRowTemplate(value));
			});

			// Render paginator
			let paginationInfo = data.paginationInfo;
			if (paginationInfo.pageNumberList.length > 0) {
				_self.$paginator.append(_self.templateList.paginatorTemplate(paginationInfo));
			}
		};

		_self.bindEvent = function() {
			$('.pagination').on('click', '.page-item', function() {
				_self.currentPageNumber = $(this).attr("data-index");
				_self.getProduct();
			});
		};
		_self.templateList = {
			brandInfoRowTemplate: _.template(TEMPLATE_BRAND),
			paginatorTemplate: _.template(TEMPLATE_PAGINATOR),
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT),
		};
		_self.initialize = function() {
			// Show brands list when opening page
			_self.searchBrands();
			_self.getProduct();
			_self.bindEvent();
		};
	};
})();
(function(brand) {
	$(document).ready(function() {
		brand.initialize();
	});
})(new Brand());