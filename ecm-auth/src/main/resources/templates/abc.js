function register() {

	var obj = {
		username : $("#email").val(),
		password : $("#password").val(),
		fullName : $("#fullname").val(),
		company : $("#company").val(),
		address : $("#address").val(),
		region : $("#region").val()
	}

	$.ajax({
		type : "POST",
		url : "/userauth/postregister",
		data : obj,
		success : function(data) {
			alert("Registration Successful....");
		},
		dataType : "json"
	});

}