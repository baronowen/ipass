$("#add").click(function(response) {
//	var checkForm = checkForm();
	if (checkForm()) {
		console.log("geldige code ingevoerd");
//		alert("geldige code ingevoerd");
		var data = $("#addSleutel").serialize();
//		console.log(data);
//		$.ajax({
//			url: "restservices/sleutels",
//			method: "POST",
//			beforeSend: function (xhr) {
//				var token = window.sessionStorage.getItem("sessionToken");
//				xhr.setRequestHeader( 'Authorization', 'Bearer ' + token);
//			},
//			succes: function (response) {
//				console.log(JSON.stringify(response));
//				alert("Sleutel toegevoegd!");
//				$("#code").val('');
//			}
//		})
		$.post("restservices/sleutels", data, function(response) {
//			console.log(JSON.stringify(response));
			alert("Sleutel toegevoegd!");
			$("#code").val('');
			
		});
	}
});

function checkForm() {
	var code = document.forms["addSleutel"]["code"].value;
	console.log("Code: " + code);
	
	if (code == "") {
		alert("Code moet ingevuld worden");
		
		return false;
		
	} else if (isNaN(code) || code.toString().length != 5) {
//		console.log("code is geen number, of heeft geen lengte van 5!");
		alert("Code is niet geldig");
		
		return false;
		
	} else {
		return true;
	}
}