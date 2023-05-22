const TEMPLATE_PRODUCT = "<li class='product-info'>"
	+ "<a class='hrefCustom' href='/dtdd-detail/<%=productName%>'>"
	+ "<div class='prod-avatar'>"
	+ "<img src='/<%= image %>'></div>"
	+ "<div class='prod-name'><%= productName %></div>"
	+ "<div class='prod-price'> <%= price %>"
	+ "</div>"
	+ "</a>"
	+ "</li>"

var ProductOfBrand = (function() {
	return function() {
		var _self = this;
		_self.$productInfo = $('.productInfo');
		_self.$paginator = $('ul.pagination');
		_self.currentPageNumber = 1;
		var url = new URL(window.location.href)
		var urlPathName = url.pathname.split("/")
		var brandName = urlPathName[urlPathName.length - 1]
		_self.getProduct = function() {
			let searchData = {
				brandName: brandName.replaceAll("-", " "),
				currentPage: Number(_self.currentPageNumber),
				sortBy: Number($("#sortBy").val())
			};
			console.log(searchData.brandId + "brandid")
			$.ajax({
				url: url.pathname,
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.drawProductContent(responseData.data);
						_self.countProduct(responseData.data)
					}
					console.log(responseData)
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

		//render Product Content
		_self.drawProductContent = function(data) {
			_self.$paginator.empty();

			_self.$productInfo.empty();

			$.each(data.productsListUser, function(key, value) {
				value.price = value.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })
				_self.$productInfo.append(_self.templateList.productInfoRowTemplate(value));
			});

			$(".hrefCustom").each(function(key, value) {
				$(value).attr("href", $(value).attr("href").replaceAll(" ", "-"))
			})

			// Render paginator
			let paginationInfo = data.paginationInfo;
			if (paginationInfo.pageNumberList.length > 0) {
				_self.$paginator.append(_self.templateList.paginatorTemplate(paginationInfo));
			}
		};
		//Count Product
		_self.countProduct = function(data) {
			$(".countProduct").html(data.count)
			$(".brandName").html(brandName.replaceAll("-", " "))
		}

		// Render title
		_self.renderTitle = function(data) {
			$.each(data.brandsList, function(key, value) {
				if (Number(brandId2) === value.brandId) {
					$(document).attr("title", `Điện thoại ${value.brandName} giảm từ 14-27% chính hãng, giá rẻ`);
				}
			});
		}

		_self.bindEvent = function() {
			// Show products list when clicking pagination button
			$('.pagination').on('click', '.page-item', function() {
				_self.currentPageNumber = $(this).attr("data-index");
				_self.getProduct();
			});

			$("#sortBy").on("change", function() {
				_self.getProduct();
			})
		}

		_self.templateList = {
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT),
			paginatorTemplate: _.template(TEMPLATE_PAGINATOR),
		};
		_self.initialize = function() {
			_self.getProduct();
			_self.bindEvent();
		};
	};
})();
(function(productOfBrand) {
	$(document).ready(function() {
		productOfBrand.initialize();
	});
})(new ProductOfBrand());