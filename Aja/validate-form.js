
$("document").ready(function() {
						//name of the method to be assigned on field
	$.validator.addMethod("atLeastOneLowercaseLetter", function (value, element) {
    return this.optional(element) || /[a-z]+/.test(value);
	}, "Must have at least one lowercase letter");
	 

	$.validator.addMethod("atLeastOneUppercaseLetter", function (value, element) {
	    return this.optional(element) || /[A-Z]+/.test(value);
	}, "Must have at least one uppercase letter");
	 
	$.validator.addMethod("atLeastOneNumber", function (value, element) {
	    return this.optional(element) || /[0-9]+/.test(value);
	}, "Must have at least one number");

	$.validator.addMethod("atLeastOneSymbol", function (value, element) {
	    return this.optional(element) || /[!@#$%^&*()]+/.test(value);
	}, "Must have at least one symbol");

	$("#frmRegister").validate({
		s: {
			txtuname: {
				required: true,
				minlength: 8,
			},
			txtemail:  {
				required: true,
				email: true
			},
			txtpwd: {
				required: true,
				minlength: 8,
				atLeastOneLowercaseLetter: true,
				atLeastOneUppercaseLetter: true,
				atLeastOneNumber: true,
				atLeastOneSymbol: true
			}
		},
		messages: {
			txtuname: {
				required: "Please enter username..",
				minlength: "User name must be at least 8 characters"
			},
			txtemail: {
				required: "Please enter your email",
				email: "Please enter a valid email."
			},
			txtpwd: {
				required: "Please enter your password",
				minlength: "Must be at least 8 characters",
				atLeastOneLowercaseLetter: "Your password must have at least 1 lower case "
			}
		}

	});

	$("#show").on('click', function() {
		alert('Hey');
		var pwd = $("#txtPassword");

		pwd.prop('type','text');
		$("#txtPassword").prop('type','text');
	});

});