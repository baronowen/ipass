package nl.hu.ipass.webservices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.security.RolesAllowed;
import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.ipass.model.ServiceProvider;
import nl.hu.ipass.model.Verzoek;
import nl.hu.ipass.model.VerzoekService;

@Path("/verzoeken")
public class VerzoekResource {
	
	private VerzoekService service = ServiceProvider.getVerzoekService();
	
	@GET
	@RolesAllowed("moderator")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllVerzoeken() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Verzoek v : service.getAllVerzoeken()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			job.add("verzoekid", v.getVerzoekid())
					.add("naam_bedrijf", v.getNaam_bedrijf())
					.add("voornaam", v.getVoornaam())
					.add("achternaam", v.getAchternaam())
					.add("straat", v.getStraat())
					.add("huisnummer", v.getNummer())
					.add("woonplaats", v.getWoonplaats())
					.add("postcode", v.getPostcode())
					.add("email", v.getEmail())
					.add("gbdatum", df.format(v.getGbdatum()))
					.add("geslacht", v.getGeslacht())
					.add("telefoonnummer", v.getTelnummer())
//					.add("wachtwoord", v.getWachtwoord())
					.add("aanwezig", v.isAanwezig())
					.add("datum_ontvangen", df.format(v.getDatum_ontvangen()));
			jab.add(job);
		}
		
		return jab.build().toString();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVerzoekById(@PathParam("id") int id) {
		Verzoek v = service.getVerzoekById(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		job.add("verzoekid", v.getVerzoekid())
				.add("naam_bedrijf", v.getNaam_bedrijf())
				.add("voornaam", v.getVoornaam())
				.add("achternaam", v.getAchternaam())
				.add("straat", v.getStraat())
				.add("huisnummer", v.getNummer())
				.add("woonplaats", v.getWoonplaats())
				.add("postcode", v.getPostcode())
				.add("email", v.getEmail())
				.add("gbdatum", df.format(v.getGbdatum()))
				.add("geslacht", v.getGeslacht())
				.add("telefoonnummer", v.getTelnummer())
//				.add("wachtwoord", v.getWachtwoord())
//				.add("aanwezig", v.isAanwezig())
				.add("datum_ontvangen", df.format(v.getDatum_ontvangen()));
		return job.build().toString();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteVerzoek(@PathParam("id") int id) {
//		System.out.println(id);
//		Verzoek verzoek = service.getVerzoekById(id);
//		System.out.println(verzoek);
		service.deleteVerzoek(id);
		
		return Response.ok().build();
	}
	
	@POST
	@Produces("application/json")
	public String addVerzoek(
//			InputStream is,
			@FormParam("nBedrijf") String nBedrijf,
			@FormParam("nVoor") String nVoor,
			@FormParam("nAchter") String nAchter,
			@FormParam("straat") String straat,
			@FormParam("huisNummer") String huisNummer,
			@FormParam("woonplaats") String woonplaats,
			@FormParam("postcode") String postcode,
			@FormParam("email") String email,
			@FormParam("gbdatum") String gbdatum,
			@FormParam("geslacht") String geslacht,
			@FormParam("telnummer") String telnummer,
			@FormParam("datum_ontvangen") String datum_ontvangen) throws ParseException {
		
		Verzoek newVerzoek = new Verzoek(nBedrijf, nVoor, nAchter, straat, huisNummer,
				woonplaats, postcode, email, gbdatum, geslacht, telnummer, datum_ontvangen);
//		System.out.println(newVerzoek);
		service.addVerzoek(newVerzoek);
//		
		return verzoekToJson(newVerzoek).build().toString();
//		return null; 	
	}
	
	private JsonObjectBuilder verzoekToJson(Verzoek v) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		
//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		job.add("id", v.getVerzoekid())
			.add("nBedrijf", v.getNaam_bedrijf())
			.add("nVoor", v.getVoornaam())
			.add("nAchter", v.getAchternaam())
			.add("straat", v.getStraat())
			.add("huisNummer", v.getNummer())
			.add("woonplaats", v.getWoonplaats())
			.add("postcode", v.getPostcode())
			.add("email", v.getEmail())
			.add("gbdatum", v.getGbdatumS())
			.add("geslacht", v.getGeslacht())
			.add("telnummer", v.getTelnummer())
			.add("datum_ontvangen", v.getDatum_ontvangenS());
//		System.out.println(job);
		return job;
	}
}
