$(document).ready(initPage());

function initPage() {
	console.log("Initializing page!");
	
	loadVerzoeken();
}

function loadVerzoeken() {
	$.ajax({
		url: "restservices/verzoeken",
		method: "GET",
		beforeSend: function (xhr) {
			var token = window.sessionStorage.getItem("sessionToken");
			xhr.setRequestHeader( 'Authorization', 'Bearer ' + token);
		},
		success: function(data) {
			$.each(data, function(i, verzoek) {
				$("#verzoekTable").append("<tr id=row_id" + verzoek.verzoekid +"> " +
						"<td colspan='1' id='verzoekid'>" + verzoek.verzoekid +
						"</td> <td colspan='1'>" + verzoek.achternaam + ', ' + verzoek.voornaam +
						"</td> <td colspan='1'>" + verzoek.naam_bedrijf + 
						"</td> <td colspan='1'>" + verzoek.datum_ontvangen +
						"</td> </tr>" +
						"<tr id=hiddenid" + verzoek.verzoekid + "> <td colspan='4'> <div id='wrapper'>" + $("#container").html() + '</div>' +
						"</td> </tr>");				
			});
			hideShow();
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
			getVerzoek($target.closest("tr").find("#verzoekid").text());
			console.log($target.closest("tr").find("#verzoekid").text());
		}
	});
}



function getVerzoek(id) {
	$.get("restservices/verzoeken/" + id, function(data) {
		$("#hiddenid" + id).find("#nBedrijf").val(data.naam_bedrijf);
		$("#hiddenid" + id).find("#nVoor").val(data.voornaam);
		$("#hiddenid" + id).find("#nAchter").val(data.achternaam);
		$("#hiddenid" + id).find("#straat").val(data.straat);
		$("#hiddenid" + id).find("#huisNummer").val(data.huisnummer);
		$("#hiddenid" + id).find("#woonplaats").val(data.woonplaats);
		$("#hiddenid" + id).find("#postcode").val(data.postcode);
		$("#hiddenid" + id).find("#email").val(data.email);
		$("#hiddenid" + id).find("#gbdatum").val(data.gbdatum);
		$("#hiddenid" + id).find("#geslacht").val(data.geslacht);
		$("#hiddenid" + id).find("#telnummer").val(data.telefoonnummer);		
	});
	
	$("#hiddenid" + id).find("#submit").click(function(response) {
//		console.log("works");
		verzendVerzoek(id);
	})
}



function verzendVerzoek(id) {
	var bedrijf = $("#hiddenid" + id).find("#nBedrijf").val();
	var voornaam = $("#hiddenid" + id).find("#nVoor").val();
	var achternaam = $("#hiddenid" + id).find("#nAchter").val();
	var straat = $("#hiddenid" + id).find("#straat").val();
	var huisnummer = $("#hiddenid" + id).find("#huisNummer").val();
	var woonplaats = $("#hiddenid" + id).find("#woonplaats").val();
	var postcode = $("#hiddenid" + id).find("#postcode").val();
	var email = $("#hiddenid" + id).find("#email").val();
	var gbdatum = $("#hiddenid" + id).find("#gbdatum").val();
	var geslacht = $("#hiddenid" + id).find("#geslacht").val();
	var telnummer = $("#hiddenid" + id).find("#telnummer").val();
	
//	if (checkForm() == true) {
	var data = { "nBedrijf": bedrijf,
			"nVoor": voornaam,
			"nAchter": achternaam,
			"straat": straat,
			"huisNummer": huisnummer,
			"woonplaats": woonplaats,
			"postcode": postcode,
			"email": email,
			"gbdatum": gbdatum,
			"geslacht": geslacht,
			"telnummer": telnummer,
	}
	console.log(data);
	var JSONdata = JSON.stringify(data);
//	console.log(JSONdata);
	
	$.post("restservices/personen", data, function(response) {
		console.log("works");
		alert("Persoon toegevoegd!");
		
		$.ajax("restservices/verzoeken/" + id, {
			type: "delete",
			success: function(response) {
				alert("verzoek verwijderd!");
			},
			error: function(response) {
				console.log("Verwijderen mislukt!");
			}
		})
		
	})
//	}	
}

function checkForm() {
	if (bedrijf == "") {
		alert("Bedrijfsnaam moet worden ingevuld!");
		return false;
	}
	else if (voornaam == "") {
		alert("voornaam moet worden ingevuld!");
		return false;
	}
	else if (achternaam == "") {
		alert("Achternaam moet worden ingevuld!");
		return false;
	} 
	else if (straat == "") {
		alert("Straat moet worden ingevuld!");
		return false;
	}
	else if (huisnummer == "") {
		alert("Huisnummer moet worden ingevuld!");
		return false;
	}
	else if (woonplaats == "") {
		alert("Woonplaats moet worden ingevuld!");
		return false;
	}
	else if (postcode == "") {
		alert("Postcode moet worden ingevuld!");
		return false;
	}
	else if (postcode.length != 6) {
		alert("Postcode moet uit 6 cijfers bestaan");
		return false;
	} 
	else if (email == "") {
		alert("Email moet worden ingevuld!");
		return false;
	}
	else if (gbdatum == "") {
		alert("Gbdatum moet worden ingevuld!");
		return false;
	} 
	else if (geslacht == "") {
		alert("Geslacht moet worden ingevuld!");
		return false;
	} 
	else if (geslacht.length > 1) {
		alert("Geslacht moet een \'m\' of een \'v'\ zijn!");
		return false;
	}
	else if (telefoonnummer == "") {
		alert("Telefoonnummer moet worden ingevuld!");
		return false;
	}
	else if (telefoonnummer.toString().length != 10) {
		alert("Telefoonnummer MOET uit 10 cijfers bestaan!");
		return false;
	}
	return true;
}

