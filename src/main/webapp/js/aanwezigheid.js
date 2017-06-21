$(document).ready(initPage());

function initPage() {
//	console.log("Initialize page");
	
	loadAanwezigen();
}

function loadAanwezigen() {
	$.ajax({
		url: "restservices/histories/aanwezigen",
		method: "GET",
		beforeSend: function (xhr) {
			var token = window.sessionStorage.getItem("sessionToken");
			xhr.setRequestHeader( 'Authorization', 'Bearer ' + token);
		},
		success: function(data) {
			$.each(data, function(i, aanwezigen) {
				$("#aanwezigenTable").append("<tr id=row_i" + (i+1) + ">" +
						"<td colspan='1' id='persoonsid'>" + aanwezigen.persoon.persoonsid + 
						"</td><td colspan='1'>" + aanwezigen.persoon.achternaam + ', ' + aanwezigen.persoon.voornaam +
						"</td> <td colspan='1'>" + aanwezigen.bedrijf.bedrijfsnaam + 
						"</td> <td colspan='1'>" + aanwezigen.aankomst_tijd + 
						"</td> </tr>" +
						"<tr id=hiddenid" + (i+1) + "> <td colspan='4'> <div id='wrapper'>" + $("#container").html() + '</div>' +
						"</td> </tr>");
			});
			hideShow();
		},
		error: function(textStatus, errorThrown) {
//			console.log(textStatus);
		}
	})
}

function hideShow() {
	$("td[colspan='4']").find("#wrapper").hide();
	$("td[colspan='1']").click(function(event) {
		event.stopPropagation();
		var $target = $(event.target);
		if ($target.closest("td").attr("colspan") > 1) {
			$target.slideUp();
		} else {
			$target.closest("tr").next().find("#wrapper").slideToggle();
			getGegevens($target.closest("tr").find("#persoonsid").text());
//			console.log($target.closest("tr").find("#persoonsid").text());
		}
	});
}

function getGegevens(id) {
	$.get("restservices/personen/" + id, function (data) {
//		console.log(data.email);
//		console.log(data.telefoonnummer);
		$("#hiddenid" + id).find("#email").text(data.email);
		$("#hiddenid" + id).find("#telnummer").text(data.telefoonnummer);
	})
}



