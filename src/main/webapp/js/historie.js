$(document).ready(initPage());

function initPage() {
//	console.log("Initializing page!");
	
	loadHistorie();
}

function loadHistorie() {
	$.ajax({
		url: "restservices/histories",
		method: "GET",
		beforeSend: function (xhr) {
			var token = window.sessionStorage.getItem("sessionToken");
			xhr.setRequestHeader( 'Authorization', 'Bearer ' + token);
		},
		success: function(data) {		
			$.each(data, function(i, historie) {
				$("#historieTable").append("<tr id=row_id" + (i+1)+ "> " +
						"<td colspan='1' id='persoonsid'>" + historie.persoon.persoonsid + 
						"</td> <td colspan='1'>" + historie.persoon.achternaam + ', ' + historie.persoon.voornaam + 
						"</td> <td colspan='1'>" + historie.bedrijf.bedrijfsnaam + 
						"</td> <td colspan='1'>" + historie.datum + 
						"</td> <td colspan='1'>" + historie.aankomst_tijd +
						"</td> <td colspan='1'>" + historie.vertrek_tijd + 
						"</td> </tr>" +
						"<tr id=hiddenid" + (i+1) + "> <td colspan='6'> <div id='wrapper'>" + $("#container").html() + '</div>' +
						"</td> </tr>");
			});
			hideShow();
		},
		error: function(textStatus, errorThrown) {
			console.log(textStatus);
		}
	})
}

function hideShow() {
	$("td[colspan='6']").find("#wrapper").hide();
	$("td[colspan='1']").click(function(event) {
		event.stopPropagation();
		var $target = $(event.target);
		if ($target.closest("td").attr("colspan") > 1) {
			$target.slideUp();
		} else {
			$target.closest("tr").next().find("#wrapper").slideToggle();
			getGegevens($target.closest("tr").find("#persoonsid").text());
		}
	});
}

function getGegevens(id) {
	$.get("restservices/personen/" + id, function(data) {
		$("#hiddenid" + id).find("#straat").text(data.straat);
		$("#hiddenid" + id).find("#huisNummer").text(data.huisnummer);
		$("#hiddenid" + id).find("#woonplaats").text(data.woonplaats);
		$("#hiddenid" + id).find("#postcode").text(data.postcode);
		$("#hiddenid" + id).find("#email").text(data.email);
		$("#hiddenid" + id).find("#telnummer").text(data.telefoonnummer);
		
	})
}




