const TEMPLATE_PRODUCT_INFO_ROW = "<tr>"
	+ "<td class='text-center'><%= productId %></td>"
	+ "<td class='text-center'><%= productName %></td>"
	+ "<td class='text-center'><%= quantity %></td>"
	+ "<td class='text-center'><%= price %></td>"
	+ "<td class='text-center'><%= brand.brandName %></td>"
	+ "<td class='text-center'><%= saleDate %></td>"
	+ "<td class='text-center'><a href='<%= image %>' data-toggle='lightbox' data-max-width='1000'><img class='img-fluid' src='<%= image %>'></td>"
	+ "<td class='action-btns text-center'>"
	+ "<a class='edit-btn btn-sm btn-primary' data-id='<%= productId %>'><i class='fas fa-edit text-white'></i></a> | <a class='delete-btn btn-sm btn-danger' data-name='<%= productName %>' data-id='<%= productId %>'><i class='fas fa-trash-alt text-white'></i></a>"
	+ "</td>"
	+ "</tr>";
const TEMPLATE_BRANDNAME = '<option value=<%= brandId %>><%= brandName %></option>';
var Product = (function() {
	return function() {
		var _self = this;
		_self.currentPageNumber = 1;
		_self.$productInfoForm = $("#productInfoForm");
		_self.$productInfoModal = $("#productInfoModal");
		_self.$productInfoTable = $("#productInfoTable");
		_self.$productInfoTableBody = _self.$productInfoTable.find("tbody");
		_self.$paginator = $("ul.pagination");

		_self.$brandNamelist = $("#brand");

		_self.searchProducts = function() {

			// Search Product by keyword
			let searchData = {
				keyword: $("#keyword").val(),
				priceFrom: $("#priceFrom").val(),
				priceTo: $("#priceTo").val(),
				currentPage: Number(_self.currentPageNumber),
			};
			$.ajax({
				url: "/product/api/search",
				type: "POST",
				dataType: "json",
				data: JSON.stringify(searchData),
				contentType: "application/json",
				success: function(responseData) {
					if (responseData.responseCode == 100) {
						_self.drawProductTableContent(responseData.data);
					}
				},
			});
		};
		_self.drawProductTableContent = function(data) {
			_self.$productInfoTableBody.empty();
			_self.$paginator.empty();

			// Render table content
			$.each(data.productsList, function(key, value) {
				_self.$productInfoTableBody.append(
					_self.templateList.productInfoRowTemplate(value)
				);
			});

			//Render select brandName
			$.each(data.brandsList, function(key, value) {
				_self.$brandNamelist.append(
					_self.templateList.brandNameTemplate(value)
				);
			});

			// Render paginator
			let paginationInfo = data.paginationInfo;
			if (paginationInfo.pageNumberList.length > 0) {
				_self.$paginator.append(
					_self.templateList.paginatorTemplate(paginationInfo)
				);
			}
		};
		_self.add = function() { // Show add brand modal
			$('#addProductInfoModal').on('click', function() {
				$('#productId').closest(".form-group").addClass("d-none");
				resetFormModal(_self.$productInfoForm);
				showModalWithCustomizedTitle(_self.$productInfoModal, "Add Product");
				$(".image-upload-wrap").show();
				$(".file-upload-content").hide();
				$(".file-upload-image").attr("src", e.target.result);
				$("#productLogo .required-mask").removeClass("d-none");
			});
		};
		_self.edit = function() { // Show update product modal
			_self.$productInfoTable.on('click', '.edit-btn', function() {
				$("#productLogo .required-mask").addClass("d-none");

				// Get brand info by brand ID
				$.ajax({
					url: "/product/api/findById?id=" + $(this).data("id"),
					type: 'GET',
					dataType: 'json',
					contentType: 'application/json',
					success: function(responseData) {
						if (responseData.responseCode == 100) {
							var productInfo = responseData.data;
							resetFormModal(_self.$productInfoForm);
							showModalWithCustomizedTitle(_self.$productInfoModal, "Edit Product");

							$('#productId').val(productInfo.productId);
							$('#productName').val(productInfo.productName);
							$('#price').val(productInfo.price);
							$('#description').val(productInfo.description);
							$('#saleDate').val(productInfo.saleDate);
							$('#brand').val(productInfo.brand.brandId);
							$('#quantity').val(productInfo.quantity);

							var productLogo = productInfo.image;
							$(".image-upload-wrap").hide();
							$(".file-upload-content").show();
							$(".file-upload-content").css({
								display: "flex",
								"justify-content": "start",
								"align-items": "center",
							});
							$(".file-upload-image").attr("src", productLogo);
							$("#image").val(productLogo);
							$('#productId').closest(".form-group").removeClass("d-none");
						}
					}
				});
			});
		};
		_self.save = function() { // Submit add and update product

			$('#saveProductBtn').on('click', function(event) {

				event.preventDefault();
				var formData = new FormData(_self.$productInfoForm[0]);
				var productId = formData.get("productId");
				var isAddAction = (productId == undefined) || productId == "";
				_self.$productInfoForm.validate({
					ignore: [],
					rules: {
						productName: {
							required: true,
							maxlength: 100
						},
						price: {
							required: true,
							number: true,
							digits: true
						},
						brand: {
							 required: true
						},
						quantity: {
							required: true,
							number: true,
							digits: true
						},
						saleDate: {
							required: true,
							maxlength: 100
						},
						imageFiles: {
							required: isAddAction,
						}
					},
					messages: {
						productName: {
							required: "Please input Product Name",
							maxlength: "The Product Name must be less than 100 characters",
						},
						price: {
							required: "Please input Price",
							number: "number"
						},
						brand: {
							required: "Please select brand",
						},
						quantity: {
							required: "Please input quantity",
						},
						saleDate: {
							required: "Please input Opening For Sale",
						},
						imageFiles: {
							required: "Please upload Product Logo",
						}
					},
					errorElement: "div",
					errorClass: "error-message-invalid"
				});

				if (_self.$productInfoForm.valid()) {

					// POST data to server-side by AJAX
					$.ajax({
						url: "/product/api/" + (isAddAction ? "add" : "update"),
						type: 'POST',
						enctype: 'multipart/form-data',
						processData: false,
						contentType: false,
						cache: false,
						timeout: 10000,
						data: formData,

						success: function(responseData) {
							console.log("responseData: " + responseData)
							// Hide modal and show success message when save successfully
							// Else show error message in modal
							if (responseData.responseCode == 100) {
								_self.$productInfoModal.modal('hide');
								if (isAddAction) {
									_self.currentPageNumber = 1;
								}
								_self.searchProducts();
								showNotification(true, responseData.responseMsg);
							} else {
								showMsgOnField(_self.$productInfoForm.find("#productName"), responseData.responseMsg);
							}
						}
					});
				}
			});
		};
		_self.remove = function() {
			// Show delete brand confirmation modal
			_self.$productInfoTable.on('click', '.delete-btn', function() {
				$("#deletedBrandName").text($(this).data("name"));
				$("#deleteSubmitBtn").attr("data-id", $(this).data("id"));
				$('#confirmDeleteModal').modal('show');
			});

			// Submit delete brand
			$("#deleteSubmitBtn").on('click', function() {
				$.ajax({
					url: "/product/api/delete/" + $(this).attr("data-id"),
					type: 'DELETE',
					dataType: 'json',
					contentType: 'application/json',
					success: function(responseData) {
						$('#confirmDeleteModal').modal('hide');
						showNotification(responseData.responseCode == 100, responseData.responseMsg);
						_self.searchProducts();
					}
				});
			});
		};
		_self.bindEvent = function() {
			_self.add();
			_self.edit();
			_self.remove();
			_self.save();

			// Show brands list when clicking pagination button
			$('.pagination').on('click', '.page-item', function() {
				_self.currentPageNumber = $(this).attr("data-index");
				_self.searchProducts();
				_self.$brandNamelist.empty()
			});

			// Search brand with search fields when click search button
			$('#searchProductBtn').on('click', function() {
				_self.currentPageNumber = 1;
				_self.searchProducts();
			});

			$('#keyword').on('keydown', function(e) {
				if (e.key === 'Enter' || e.keyCode === '13') {
					_self.currentPageNumber = 1;
					_self.searchProducts();
				}
			});

			// Search brand after search fields when click clear search field button
			$('#clearSearchFieldBtn').on('click', function() {
				$("#keyword").val("");
				$("#priceTo").val("");
				$("#priceFrom").val("");
				_self.currentPageNumber = 1;
				_self.searchProducts();
			});
		}
		_self.templateList = {
			productInfoRowTemplate: _.template(TEMPLATE_PRODUCT_INFO_ROW),
			paginatorTemplate: _.template(TEMPLATE_PAGINATOR),
			brandNameTemplate: _.template(TEMPLATE_BRANDNAME),
		};

		_self.initialize = function() {
			// Show products list when opening page
			_self.searchProducts();
			_self.bindEvent();
		};
	};

})();

(function(product) {
	$(document).ready(function() {
		product.initialize();
	});
})(new Product());


