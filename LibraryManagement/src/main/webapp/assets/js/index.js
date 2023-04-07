/*===Format data picker*/
$(function() {
	$(".datepicker").datepicker({
		language: "es",
		autoclose: true,
		format: "yyyy/mm/dd",
	});
});

/*=== Open modal ===*/
$(document).ready(function() {
	$('.openmodal').on("click", function(e) {
		e.preventDefault();
		var $text = $(this).closest('tr').find(".name-item").html();
		$('#modaldelete').modal('show')
		var id = $(this).data("id");
		var href2 = `book?action=delete&id=${id}`;
		$("#deleteitem").prop("href", href2);
		$(".item_modal-title").html($text);
		var idItem = $(this).data("id");
		$("#idhidden").val(idItem)
		$(".modal-body").html(`Do you want delete <strong>${$text}</strong> ?`)
		$(this).parent().parent().prop("id", "idmodaldelete")
	});
});

/*===Active navbar===*/
$(document).ready(function() {
	$(".nav-item a").on("click", function() {
		$(".nav-item.active").removeClass("active");
		$(this).parent().addClass("active");
	}).filter(function() {
		return window.location.href.indexOf($(this).attr('href').trim()) > -1;
	}).click();
});

/*===display student name from selectid===*/
function select() {
	var d = document.getElementById("studentid");
	var displayValue = d.options[d.selectedIndex]
		.getAttribute("data-name");
	document.getElementById("studentname").value = displayValue;
}

function selectBook() {
	var d = document.getElementById("bookid");
	var displayValue = d.options[d.selectedIndex]
		.getAttribute("data-book");
	document.getElementById("quantitybook").value = displayValue;
}

/*===Validation data===*/
$(function() {
	const regexName = /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s|_]+$/;
	jQuery.validator.addMethod("validName", function(value, element) {
		return this.optional(element) || regexName.test(value);
	}, 'Please Enter a name in the correct format.');
	/*=== Validation studnet ===*/
	$("form[name='student']").validate({
		rules: {
			name: {
				required: true,
				maxlength: 50,
				validName: true,
			},
			age: {
				required: true,
				number: true,
				min: 6,
				max: 999,
				digits: true,
			},
			gender: {
				required: true,
			}
		},
		messages: {
			name: {
				required: "Please provide name",
				maxlength: "Name up to 50 characters",
				validName: "Please Enter a name in the correct format",
			},
			age: {
				required: "Please provide age",
				number: "Number must be entered",
				min: "Age must be greater than 5",
				max: "Age exceeding the permissible",
				digits: "Please enter only positive integer digits"
			},
			gender: {
				required: "Please select gender",
			}
		},
	});
	/*=== Validation book ===*/
	$("form[name='book']").validate({
		rules: {
			name: {
				required: true,
				maxlength: 50,
			},
			totalpage: {
				number: true,
				digits: true,
			},
			quantity: {
				number: true,
				required: true,
			},
			type: {
				maxlength: 50,
			}
		},
		messages: {
			name: {
				required: "Please provide name",
				maxlength: "Name up to 50 characters",
			},
			totalpage: {
				number: "Number must be entered",
				digits: "Please enter only positive integer digits"
			},
			quantity: {
				number: "Number must be entered",
				required: "Please provide quantity",
			},
			type: {
				maxlength: "Name up to 50 characters",
			}
		},
	});
	/*=== Validation borrow ===*/
	$("form[name='borrow']").validate({
		rules: {
			studentid: {
				required: true,
			},
			bookid: {
				required: true,
			},
			quantity: {
				required: true,
				number: true,
				digits: true,
			}
		},
		messages: {
			studentid: {
				required: "Please select student id",
			},
			bookid: {
				required: "Please select student id",
			},
			quantity: {
				number: "Number must be entered",
				required: "Please provide quantity",
				digits: "Please enter only positive integer digits"
			}
		},
	});

	/*=== validation book name ===*/
	$("form[name='book']").submit(function(e) {
		e.preventDefault();
		var data = $(this).serializeArray();
		var link = $(this).prop("action");
		$.ajax({
			url: link,
			type: "POST",
			data: data,
			error: function() {
			},
			success: function(result) {
				console.log(result)
				if (result === "book") {
					window.location.href = result
				} else
					$(".error-name").html(result)
			}
		});
	});

	/* === Delete dont load page ===*/
	$('#deleteitem').on("click", function(e) {
		e.preventDefault();
		var link = $(this).prop("href");
		var idItem = $("#idhidden").val();
		console.log(idItem)
		$.ajax({
			url: link,
			type: "POST",
			data: { id: idItem },
			error: function() {

			},
			success: function() {
				$("#idmodaldelete").fadeOut()
				$('#modaldelete').modal('hide')
			}
		})
	})
});

$(document).ready(function() {
	/*=== validation quantity book borow ===*/
	$("#formborrow").submit(function(e) {
		e.preventDefault();
		var data = $(this).serializeArray();
		var link = $(this).prop("action");
		$.ajax({
			url: link,
			type: "POST",
			data: data,
			error: function() {
			},
			success: function(result) {
				if (result === "borrow") {
					window.location.href = result
				}
				else
					$(".error-quantity").html(result)
			}
		});
	});
});

$(document).ready(function() {
	$("#formborrowsearch").submit(function(e) {
		e.preventDefault();
		var data = $(this).serializeArray();
		var link = $(this).prop("action");
		$.ajax({
			url: link,
			type: "POST",
			data: data,
			error: function() {
			},
			success: function(result) {
				$("#searchborrow").html(result)
			}
		})
	})
});

