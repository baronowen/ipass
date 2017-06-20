$("#button").click(function(event) {
	var data = $("#loginform").serialize();
//	console.log(data);
	
	$.post("restservices/authentication", data, function(response) {
//		console.log(response);
		
		var results = response.split('roleName:');
//		console.log(results);
		
		window.sessionStorage.setItem("sessionToken", results[0]);
		window.sessionStorage.setItem("sessionRole",results[1] )
				
//		console.log("Succesvol ingelogd!");
		if (results[1] == "moderator") {
			alert("Succesvol ingelogd");
			window.location.href="keuzemod.html";
		}
		else if (results[1] == "werkgever") {
			alert("Succesvol ingelogd");
			window.location.href="keuzewerk.html";
		}
		
	}).fail(function(jqXHR, textStatus, errorThrown) {
//		console.log("Inloggen mislukt!");
		alert("Verkeerde email of wachtwoord!");
//		window.location.href="inlog.html";
//		console.log(textStatus);
//		console.log(errorThrown);
	});
});