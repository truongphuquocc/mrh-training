const DEFAULT_IMAGE_PREVIEW = "/images/common/image-demo.png";
const TEMPLATE_PAGINATOR =
	"	<li class='page-item <% if (firstPage == 0) { %> disabled <% } %>' data-index='<%= firstPage %>' title='First'> << </li>"
	+ "<li class='page-item <% if (previousPage == 0) { %> disabled <% } %>' data-index='<%= previousPage %>' title='Previous'> < </li>"
	+ "<% _.each(pageNumberList, function(item) { %>"
	+ "<li class='page-item <% if (item == currentPage) { %> active <% } %>' data-index='<%= item %>'><%= item %></li>"
	+ "<% }); %>"
	+ "<li class='page-item <% if (nextPage == 0) { %> disabled <% } %>' data-index='<%= nextPage %>' title='Next'> > </li>"
	+ "<li class='page-item <% if (lastPage == 0) { %> disabled <% } %>' data-index='<%= lastPage %>' title='Last'> >> </li>"
$(document).ready(function() {

	// Add "active" class for link in Header
	$(document).ready(function() {
		$(".nav-item a")
			.on("click", function() {
				$(".nav-item.active").removeClass("active");
				$(this).parent().addClass("active");
			})
			.filter(function() {
				return window.location.href.indexOf($(this).attr("href").trim()) > -1;
			})
			.click();
	});

	// Upload image preview
	$('input.upload-image').on('change', function() {
		var url = window.URL || window.webkitURL;
		var file = this.files[0];
		var fileUrl;
		var $parent = $(this).parent();
		if (file) {
			fileUrl = url.createObjectURL(file);
			$parent.find(".error-message-invalid").removeClass("error-message-invalid");
		} else {
			var oldImagePath = $parent.find(".old-img").val();
			if (oldImagePath) {
				fileUrl = oldImagePath;
			} else {
				fileUrl = "/images/image-demo.png";
			}
		}
		$parent.find('.preview-image-upload img').attr('src', fileUrl);
	});

	// Open image in full size
	$(document).on('click', '[data-toggle="lightbox"]', function(event) {
		event.preventDefault();
		$(this).ekkoLightbox({
			alwaysShowClose: true
		});
	});
});

/**
 * Add title for selected modal after that show modal
 * @param $selectedModal
 * @param title
 */
function showModalWithCustomizedTitle($selectedModal, title) {
	$selectedModal.find(".modal-title").text(title);
	$selectedModal.modal('show');
}

/**
 * Reset form of modal before open modal
 * @param $formElement
 */
function resetFormModal($formElement) {

	$formElement[0].reset();
	$formElement.find("input[type*='file']").val("");
	$formElement.validate().destroy();
	$formElement.find(".error-message-invalid").remove();
	$formElement.find("img").attr('src', '');
}

/**
 * Show notification common 
 * 
 * @param isSuccess	show notify is success
 * @param message display on notify
 */
function showNotification(isSuccess, message) {

	if (isSuccess) {
		$.notify({
			icon: 'glyphicon glyphicon-ok',
			message: message
		}, {
			type: 'info',
			delay: 3000
		});
	} else {
		$.notify({
			icon: 'glyphicon glyphicon-warning-sign',
			message: message
		}, {
			type: 'danger',
			delay: 6000
		});
	}
}

/**
 * Show message on popup 
 * 
 * @param $element
 *				element show error message
 * @param isSuccessMsg
 *				true if message is a inform message
 *				false if message is error message
 * @param message
 */
function showMsgOnForm($element, message, isSuccessMsg) {

	var className = isSuccessMsg ? "alert-info" : "error-message-invalid";
	$element.find(".form-msg").remove();
	$element.prepend("<div class='" + className + " form-msg'>" + message + "</div>");
}

/**
 * Show message below input field
 * 
 * @param $element
 *				element show error message
 * @param isSuccessMsg
 *				true if message is a inform message
 *				false if message is error message
 * @param message
 */
function showMsgOnField($element, message, isSuccessMsg) {

	var className = isSuccessMsg ? "alert-info" : "error-message-invalid";
	$element.find(".form-msg").remove();
	$element.parent().append("<div class='" + className + " form-msg'>" + message + "</div>");
}