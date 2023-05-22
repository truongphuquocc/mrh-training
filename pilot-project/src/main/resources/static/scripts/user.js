const TEMPLATE_BRAND = "<a class='dropdown-item btn-dropdown hrefCustom' data-id='<%=brandId%>' href='/dtdd/<%=brandName%>'>"
	+ "<img src='<%= logo %>'></a>"
const BRANCH_SEARCH = "<label class='brandtips'>"
	+ "<input type='checkbox' name='brand' value=<%= brandId %> />"
	+ "<span class='brandtips_wrap'>"
	+ "<img class='brandtips_tip' src='<%= logo %>'>"
	+ "</span>"
	+ "</label>"
const TEMPLATE_PRODUCT = "<li class='product-info'> <a class='hrefCustom' href='/dtdd-detail/<%=productName%>'>"
	+ "<div class='prod-avatar'>"
	+ "<img src='<%= image %>'></div>"
	+ "<div class='prod-name'><%= productName %></div>"
	+ "<div class='prod-price'> <%= price %>"
	+ "</div>"
	+ "</a></li>"
const LIVE_SEARCH_PRODUCT = "<li class='product_suggest'>"
	+ "<a href='/dtdd-detail/<%=productName%>'>"
	+ "<div class='item-img'>"
	+ "<img src='<%= image %>' alt=''>"
	+ "</div>"
	+ "<div class='item-info'>"
	+ "<h3><%= productName %></h3>"
	+ "<strong class='price'><%= price %></strong>"
	+ "</div>"
	+ "</a></li>"
const TITTLE_SEARCH = "<li class='ttitle'><div class='viewed'>Sản phẩm gợi ý</div></li>"
var HomePage = (function() {
	return function() {
		var _self = this;
		_self.currentPageNumber = 1;
		_self.$brandInfo = $('.brandInfo');
		_self.$brandSearch = $('.brandSearch');
		_self.$productInfo = $('.productInfo');
		_self.$paginator = $('ul.pagination');
		_self.$suggestSearch = $('.suggest_search');
		var brandIdFilter = [];
		var priceFilter = [];
		var brandForm = [];
		var priceForm = [];
		let min = 300000;
		const MIN = 300000;
		let max = 42000000;
		const MAX = 42000000;
		let minStr = ""
		let maxStr = ""

		const calcLeftPosition = (value) => (100 / (42000000 - 300000)) * (value - 300000);
		var rangeBalance;

		_self.searchBrands = function() {
			// Search Brand by keyword
			let searchData = {
				keyword: $('#keyword').val(),
			};

			$.ajax({
				url: 'dtdd/api/getall',
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
				priceFrom: minStr,
				priceTo: maxStr,
				currentPage: Number(_self.currentPageNumber),
				sortBy: Number($("#sortBy").val())
			};
			$.ajax({
				url: 'dtdd/api/getproduct',
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.countProduct(responseData.data.count)
						_self.drawProductContent(responseData.data);
						_self.customHref()
					}
					console.log(responseData.data);
				},
			});
		};

		_self.getProductLiveSearch = function() {
			// Search Brand by keyword
			let searchData = {
				keyword: $('#keyword').val(),
			};
			$.ajax({
				url: 'dtdd/api/LiveSearch',
				type: 'POST',
				dataType: 'json',
				data: JSON.stringify(searchData),
				contentType: 'application/json',
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.drawSuggestSearch(responseData.data);
					}
					console.log(responseData.data);
				},
			});
		};
		//Reload price range
		_self.reloadRangePrice = function() {
			$('.line').css({
				left: '0%',
				right: '0%',
			});
			$('.thumbMin').css('left', '0%');
			$('.thumbMax').css('left', '100%');
			$(".rangeMin").val(MIN);
			$(".rangeMax").val(MAX);
			$(".min").html(Number(MIN).toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }));
			$(".max").html(Number(MAX).toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }));
			min = MIN;
			max = MAX;
		}

		_self.customHref = function() {
			$(".hrefCustom").each(function(key, value) {
				$(value).attr("href", $(value).attr("href").replaceAll(" ", "-"))
			})
		}

		_self.drawBrandContent = function(data) {
			// Render table content
			$.each(data.brandsList, function(key, value) {
				_self.$brandInfo.append(_self.templateList.brandInfoRowTemplate(value));
			});

			$.each(data.brandsList, function(key, value) {
				_self.$brandSearch.append(_self.templateList.brandSearch(value));
			});

			$(".hrefCustom").each(function(key, value) {
				$(value).attr("href", $(value).attr("href").replaceAll(" ", "-"))
			})

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
		}

		_self.drawProductContent = function(data) {
			_self.$paginator.empty();
			_self.$productInfo.empty();

			//Render product content

			$.each(data.productsListUser, function(key, value) {
				value.price = value.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })
				_self.$productInfo.append(_self.templateList.productInfoRowTemplate(value));
			});
			// Render paginator
			let paginationInfo = data.paginationInfo;
			if (paginationInfo.pageNumberList.length > 0) {
				_self.$paginator.append(_self.templateList.paginatorTemplate(paginationInfo));
			}

			_self.customHref();
		};

		_self.drawSuggestSearch = function(data) {
			_self.$suggestSearch.empty()
			//Render product content
			//		if (data.productsListLiveSearch.length != 0) {
			/*				_self.$suggestSearch.append(_self.templateList.titleSearch());
						}*/
			$.each(data.productsListLiveSearch.slice(0, 5), function(key, value) {
				value.price = value.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })
				_self.$suggestSearch.append(_self.templateList.liveSearchProduct(value));
			});

		};

		//Count Product
		_self.countProduct = function(data) {
			$(".countProduct").html(data)
		}

		let debounce = (func, delay) => {
			let timerId;
			return function() {
				clearTimeout(timerId)
				timerId = setTimeout(() => func.apply(this, arguments), delay)
			};
		};

		_self.debounceLiveSearch = function() {

			let delay = 500;
			_self.callbackDebounce = debounce(function() {
				_self.getProductLiveSearch();
			}, delay);

			$('#keyword').on('input', function() {
				if ($('#keyword').val().length >= 3)
					_self.callbackDebounce();
				else
					_self.$suggestSearch.empty()
			})
		}

		_self.bindEvent = function() {
			// Show products list when clicking pagination button
			$('.pagination').on('click', '.page-item', function() {
				_self.currentPageNumber = $(this).attr("data-index");
				_self.getProduct();
			});

			// Search brand with search fields when click search button
			$('#searchBrandBtn').on('click', function() {
				_self.currentPageNumber = 1;
				_self.getProduct();
			});

			$('#keyword').on('keydown', function(e) {
				if (e.key === 'Enter' || e.keyCode === '13') {
					_self.currentPageNumber = 1;
					_self.getProduct();
				}
			});

			$("#keyword").on("focus", function() {
				$("#search-result").addClass("d-block")
			});

			// Search product after search fields when click clear search field button
			$('#clear').on('click', function() {
				$("#keyword").val("");
				_self.currentPageNumber = 1;
				_self.getProduct();
			});

			//var ul = $('#active-result');
			var liSelected;
			var index = -1;

			$(document).on('keyup', function() {
				if ($(".product_suggest").hasClass("selected"))
					$("#keyword").val($(".product_suggest.selected h3").text())
			})


			document.addEventListener('keyup', function(event) {
				var len = $('#active-result .product_suggest').length - 1;
				/*				if ($(".product_suggest").hasClass("selected")) {
									let $db = $(".product_suggest.selected").prev()
									console.log($db)
									var contextsg = $(".product_suggest.selected h3").text();
									$("#keyword").val(contextsg)
									console.log($(".product_suggest.selected h3").text())
								}*/

				//var contextsg = $(".product_suggest.selected h3").text();

				if (event.which === 40) {
					index++;
					//down 
					if (liSelected) {
						removeClass(liSelected, 'selected');
						next = $('#active-result .product_suggest')[index];
						if (typeof next !== undefined && index <= len) {
							liSelected = next;
						} else {
							index = 0;
							liSelected = $('#active-result .product_suggest')[0];
						}
						addClass(liSelected, 'selected');

					} else {
						index = 0;
						liSelected = $('#active-result .product_suggest')[0];
						addClass(liSelected, 'selected');
					}
				} else if (event.which === 38) {
					//up
					if (liSelected) {
						removeClass(liSelected, 'selected');
						index--;
						console.log(index);
						next = $('#active-result .product_suggest')[index];
						if (typeof next !== undefined && index >= 0) {
							liSelected = next;
						} else {
							index = len;
							liSelected = $('#active-result .product_suggest')[len];
						}
						addClass(liSelected, 'selected');
					} else {
						index = 0;
						liSelected = $('#active-result .product_suggest')[len];
						addClass(liSelected, 'selected');
					}
				}
			}, false);

			function removeClass(el, className) {
				if (el.classList) {
					el.classList.remove(className);
				} else {
					el.className = el.className.replace(new RegExp('(^|\\b)' + className.split(' ').join('|') + '(\\b|$)', 'gi'), ' ');
				}
			};

			function addClass(el, className) {
				if (el.classList) {
					el.classList.add(className);
				} else {
					el.className += ' ' + className;
				}
			};

			//show result search product when click readmore button
			$(".btn-filter-readmore").on('click', function() {
				_self.getProduct();
				_self.unCheck();
				if ($(".dropdown-menu").hasClass("show")) {
					$(".dropdown-menu").removeClass("show")
				}
				else {
					$(".dropdown-menu").addClass("show")
				}
			});

			// Search product after check checkbox when click Bo Chon search field button
			$(".btn-filter-close").on('click', function() {
				location.reload(true);
			})

			$("#sortBy").on("change", function() {
				_self.getProduct();
			})

			//Range min price search
			$('.rangeMin').on('input', function(e) {
				let newValue = parseFloat(e.target.value);
				if (newValue === parseFloat($(".rangeMax").val()))
					rangeBalance = newValue
				if (newValue >= rangeBalance)
					$('.rangeMin').val(rangeBalance)
				if (newValue > max) return;
				min = newValue;
				minStr = newValue.toString()
				$('.thumbMin').css('left', calcLeftPosition(newValue) + '%');
				$('.min').html(newValue.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }));
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

			//range max price search
			$('.rangeMax').on('input', function(e) {
				let newValue = parseFloat(e.target.value);
				if (newValue === parseFloat($(".rangeMin").val()))
					rangeBalance = newValue
				if (newValue <= rangeBalance)
					$('.rangeMax').val(rangeBalance)
				if (newValue < min) return;
				max = newValue;
				maxStr = newValue.toString()
				$('.thumbMax').css('left', calcLeftPosition(newValue) + '%');
				$('.max').html(newValue.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }));
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
				minStr = '';
				maxStr = '';
			});

			//Show hide search range price product
			$(".range-toggle").on('click', function(e) {
				e.preventDefault();
				priceFilter = [];
				_self.reloadRangePrice();
				$(":input[name='price']").prop('checked', false)
				if (($(".range-price").hasClass("d-none")) === true) {
					$(".range-price").removeClass("d-none")
					$(".down").removeClass("fa-caret-up")
					$(".down").addClass("fa-caret-down")
				}
				else if (($(".range-price").hasClass("d-none")) === false) {
					$(".range-price").addClass("d-none")
					$(".down").addClass("fa-caret-up")
					$(".down").removeClass("fa-caret-down")
				}
			})
		};

		_self.templateList = {
			brandInfoRowTemplate: _.template(TEMPLATE_BRAND),
			paginatorTemplate: _.template(TEMPLATE_PAGINATOR),
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT),
			brandSearch: _.template(BRANCH_SEARCH),
			liveSearchProduct: _.template(LIVE_SEARCH_PRODUCT),
			titleSearch: _.template(TITTLE_SEARCH),
		};

		_self.initialize = function() {
			// Show brands list when opening page
			_self.searchBrands();
			//Show product list when opening page
			_self.getProduct();
			_self.bindEvent();
			_self.customHref();
			_self.debounceLiveSearch();
		};
	};
})();
(function(homePage) {
	$(document).ready(function() {
		homePage.initialize();
	});
})(new HomePage());

