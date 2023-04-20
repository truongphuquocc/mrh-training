var Login = (function() {
	return function() {
		var _self = this;
		_self.$formSigning = $("#formSigning");
		_self.save = function() { // Submit login

			$("#formSigning").validate({
				onfocusout: false,
				onkeyup: false,
				onclick: false,
				rules: {
					"username": {
						required: true,
						maxlength: 15
					},
					"password": {
						required: true,
						minlength: 8
					}
				},
				messages: {
					"username": {
						required: "Please input User Name",
						maxlength: "The User Name must be less than 15 characters"
					},
					"password": {
						required: "Please Password",
						minlength: "The Password must be more than 8 characters"
					}
				}
			});
		};
		_self.bindEvent = function() {
			_self.save();
		}

		_self.initialize = function() {
			_self.bindEvent();
		};
	};

})();

(function(login) {
	$(document).ready(function() {
		login.initialize();
	});
})(new Login());

