const TEMPLATE_BRAND = "<a class='dropdown-item btn-dropdown' data-id='<%=brandId%>' href='/productofbrand?brandid=<%=brandId%>'>"
	+ "<img src='<%= logo %>'></a>"

const BRANCH_SEARCH = "<label class='brandtips'>"
	+ "<input type='checkbox' name='brand' value=<%= brandId %> />"
	+ "<span class='brandtips_wrap'>"
	+ "<img class='brandtips_tip' src='<%= logo %>'>"
	+ "</span>"
	+ "</label>"

const TEMPLATE_PRODUCT = "<li class='product-info'>"
	+ "<div class='prod-avatar'>"
	+ "<a data-toggle='lightbox' data-max-width='1000' href='<%= image %>'><img src='<%= image %>'></a></div>"
	+ "<div class='prod-name'><%= productName %></div>"
	+ "<div class='prod-price'> <%= price %>"
	+ "</div>"
	+ "</li>"
var HomePage = (function() {
	return function() {
		var _self = this;
		_self.currentPageNumber = 1;
		_self.$brandInfo = $('.brandInfo');
		_self.$brandSearch = $('.brandSearch');
		_self.$productInfo = $('.productInfo');
		_self.$paginator = $('ul.pagination');
		var brandIdFilter = [];
		var priceFilter = [];
		var brandForm = [];
		var priceForm = [];
		let min = 300000;
		let max = 42000000;
		var countProduct = 0;

		const calcLeftPosition = (value) => (100 / (42000000 - 300000)) * (value - 300000);
		var rangeBalance;

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
				brandIdFilter: [...brandIdFilter],
				priceFilter: [...priceFilter],
				priceFrom: min.toString(),
				priceTo: max.toString(),
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

			$.each(data.brandsList, function(key, value) {
				_self.$brandSearch.append(_self.templateList.brandSearch(value));
			});

			function showValues() {
				var fields = $(":input[name='brand']").serializeArray();
				var fieldsPrice = $(":input[name='price']").serializeArray();
				priceForm = fieldsPrice;
				brandForm = fields;
				brandIdFilter = [];
				priceFilter = [];
				brandForm.forEach(item => brandIdFilter.push(item.value))
				priceForm.forEach(item => priceFilter.push(item.value))
			}

			$(":checkbox").on("click", showValues);

			$(":input[name='brand']").on('click', function() {
				_self.getProduct();
			});
		}

		_self.drawProductContent = function(data) {
			_self.$paginator.empty();
			_self.$productInfo.empty();

			$.each(data.productsListUser, function(key, value) {
				value.price = value.price.toLocaleString('vi-VN', {style : 'currency', currency : 'VND'})
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


			$(".btn-filter-readmore").on('click', function() {
				_self.getProduct();
			});

			$('.rangeMin').on('input', function(e) {
				let newValue = parseFloat(e.target.value);
				if (newValue === parseFloat($(".rangeMax").val()))
					rangeBalance = newValue
				if (newValue >= rangeBalance)
					$('.rangeMin').val(rangeBalance)
				if (newValue > max) return;
				min = newValue;
				$('.thumbMin').css('left', calcLeftPosition(newValue) + '%');
				$('.min').html(newValue);
				$('.line').css({
					left: calcLeftPosition(newValue) + '%',
					right: 100 - calcLeftPosition(max) + '%',
				});
				if (newValue === $('.rangeMax').val()) {
					$('.rangeMax').hide()
				}
				else {
					$('.rangeMax').show()
				}
			});

			$('.rangeMax').on('input', function(e) {
				let newValue = parseFloat(e.target.value);
				if (newValue === parseFloat($(".rangeMin").val()))
					rangeBalance = newValue
				if (newValue <= rangeBalance)
					$('.rangeMax').val(rangeBalance)
				if (newValue < min) return;
				max = newValue;
				$('.thumbMax').css('left', calcLeftPosition(newValue) + '%');
				$('.max').html(newValue);
				$('.line').css({
					left: calcLeftPosition(min) + '%',
					right: 100 - calcLeftPosition(newValue) + '%',
				});
				if (newValue === $('.rangeMin').val()) {
					$('.rangeMin').hide()
				}
				else {
					$('.rangeMin').show()
				}
			});

			//Hide search range price product
			$(":input[name='price']").on('click', function() {
				if (($(".range-price").hasClass("d-none")) === false) {
					$(".range-price").addClass("d-none")
				}
				min = '';
				max = '';
			});

			//Show hide search range price product
			$(".range-toggle").on('click', function(e) {
				e.preventDefault();
				priceFilter = []
				if (($(".range-price").hasClass("d-none")) === true) {
					$(".range-price").removeClass("d-none")
				}
				else if (($(".range-price").hasClass("d-none")) === false) {
					$(".range-price").addClass("d-none")
				}
				$(":input[name='price']").prop('checked', false)
			})
		};

		_self.templateList = {
			brandInfoRowTemplate: _.template(TEMPLATE_BRAND),
			paginatorTemplate: _.template(TEMPLATE_PAGINATOR),
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT),
			brandSearch: _.template(BRANCH_SEARCH),
		};

		_self.initialize = function() {
			// Show brands list when opening page
			_self.searchBrands();
			//Show product list when opeing page
			_self.getProduct();
			_self.bindEvent();
		};
	};
})();
(function(homePage) {
	$(document).ready(function() {
		homePage.initialize();
	});
})(new HomePage());

