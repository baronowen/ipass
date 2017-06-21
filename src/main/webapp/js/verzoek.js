$(document).ready(function() {
	var now = new Date();
	// console.log(now);
	var month = (now.getMonth() + 1);
	// console.log(month);
	var day = now.getDate();
	// console.log(day);
	if (month < 10) {
		month = "0" + month;
	}
	if (day < 10) {
		day = "0" + day;
	}
	var today = day + '-' + month + '-' + now.getFullYear();

	$("#datum_ontvangen").val(today);
});

$("#indienen").click(function(response) {
	if (checkForm() == true) {
//		console.log("comes her");
		var data = { "nBedrijf": $("#nBedrijf").val(), 
				"nVoor": $("#nVoor").val(),
				"nAchter": $("#nAchter").val(),
				"straat": $("#straat").val(),
				"huisNummer": $("#huisNummer").val(),
				"woonplaats": $("#woonplaats").val(),
				"postcode": $("#postcode").val(),
				"email": $("#email").val(),
				"gbdatum": $("#gbdatum").val(),
				"geslacht": $("#geslacht").val(),
				"telnummer": $("#telnummer").val(),
				"datum_ontvangen": $("#datum_ontvangen").val(),
		}
//		console.log(data);
//		console.log("comes here too");
		var JSONdata = JSON.stringify(data);
//		console.log(JSONdata);
				
		$.post("restservices/verzoeken", data, function(response) {
//			console.log(JSONdata);
			alert("Verzoek ingediend!");
			$("#nBedrijf").val('');
			$("#nVoor").val('');
			$("#nAchter").val('');
			$("#straat").val('');
			$("#huisNummer").val('');
			$("#woonplaats").val('');
			$("#postcode").val('');
			$("#email").val('');
			$("#gbdatum").val('');
			$("#geslacht").val('');
			$("#telnummer").val('');
			
		})
	}
})

function checkForm() {
	var bedrijf = document.forms["addVerzoek"]["nBedrijf"].value;
	var voornaam = document.forms["addVerzoek"]["nVoor"].value;
	var achternaam = document.forms["addVerzoek"]["nAchter"].value;
	var straat = document.forms["addVerzoek"]["straat"].value;
	var huisnummer = document.forms["addVerzoek"]["huisNummer"].value;
	var woonplaats = document.forms["addVerzoek"]["woonplaats"].value;
	var postcode = document.forms["addVerzoek"]["postcode"].value;
	var email = document.forms["addVerzoek"]["email"].value;
	var gbdatum = document.forms["addVerzoek"]["gbdatum"].value;
	var geslacht = document.forms["addVerzoek"]["geslacht"].value;
	var telefoonnummer = document.forms["addVerzoek"]["telnummer"].value;

	console.log(bedrijf + "-" + voornaam + "-" + achternaam + "-" + straat
			+ "-" + huisnummer + "-" + woonplaats + "-" + postcode + "-"
			+ email + "-" + gbdatum + "-" + geslacht + "-" + telefoonnummer);
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
//	console.log("done checking");
	return true;

}
