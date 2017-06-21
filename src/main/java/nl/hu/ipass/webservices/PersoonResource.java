package nl.hu.ipass.webservices;

//import java.io.InputStream;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
//import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

import nl.hu.ipass.model.Persoon;
import nl.hu.ipass.model.PersoonService;
import nl.hu.ipass.model.ServiceProvider;

@Path("/personen")
public class PersoonResource {
	private PersoonService service = ServiceProvider.getPersoonService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPersonen() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Persoon p : service.getAllPersonen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
						
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			job.add("persoonsid", p.getPersoonsid())
					.add("voornaam", p.getVoornaam())
					.add("achternaam", p.getAchternaam())
					.add("straat", p.getStraat())
					.add("huisnummer", p.getHuisNummer())
					.add("woonplaats", p.getWoonplaats())
					.add("postcode", p.getPostcode())
					.add("email", p.getEmail())
					.add("gbdatum", df.format(p.getGbdatum()))
					.add("geslacht", p.getGeslacht())
					.add("telefoonnummer", p.getTelnummer())
					.add("wachtwoord", p.getWachtwoord())
					.add("aanwezig", p.isAanwezig());
			jab.add(job);
		}
		
		return jab.build().toString();
	}
	
	@GET
	@Path("/extrainfo")
	@Produces(MediaType.APPLICATION_JSON)
	public String getExtraInfoPersonen() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Persoon p : service.getAllPersonen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			JsonObjectBuilder job2 = Json.createObjectBuilder();
			JsonObjectBuilder job3 = Json.createObjectBuilder();
			JsonObjectBuilder job4 = Json.createObjectBuilder();
			
			job2.add("functieid", p.getFunctie().getFunctieid())
					.add("functienaam", p.getFunctie().getNaam());
			
			job3.add("sleutelid", p.getSleutel().getSleutelid())
					.add("sleutelcode", p.getSleutel().getSleutelcode());
			
			job4.add("bedrijfsid", p.getBedrijf().getBedrijfsid())
					.add("naam", p.getBedrijf().getNaam())
					.add("locatie", p.getBedrijf().getLocatie());
			
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			job.add("persoonsid", p.getPersoonsid())
					.add("voornaam", p.getVoornaam())
					.add("achternaam", p.getAchternaam())	
					
//					option 1:
					.add("functie", job2)
//					option 2:
//					.add("functienaam", p.getFunctie().getNaam());
					
					.add("sleutel", job3)
					.add("bedrijf", job4);
			jab.add(job);
		}
		
		return jab.build().toString();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPersoonById(@PathParam("id") int id) {
		Persoon p = service.getPersoonById(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		job.add("persoonsid", p.getPersoonsid())
				.add("voornaam", p.getVoornaam())
				.add("achternaam", p.getAchternaam())
				.add("straat", p.getStraat())
				.add("huisnummer", p.getHuisNummer())
				.add("woonplaats", p.getWoonplaats())
				.add("postcode", p.getPostcode())
				.add("email", p.getEmail())
				.add("gbdatum", df.format(p.getGbdatum()))
				.add("geslacht", p.getGeslacht())
				.add("telefoonnummer", p.getTelnummer())
				.add("wachtwoord", p.getWachtwoord())
				.add("aanwezig", p.isAanwezig());
		return job.build().toString();
	}
	
	@GET
	@Path("/aanwezigen")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAanwezigen() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Persoon p : service.getAanwezigen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			JsonObjectBuilder job2 = Json.createObjectBuilder();
			
			job2.add("bedrijfsid", p.getBedrijf().getBedrijfsid())
					.add("bedrijfsnaam", p.getBedrijf().getNaam());
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			job.add("persoonsid", p.getPersoonsid())
					.add("voornaam", p.getVoornaam())
					.add("achternaam", p.getAchternaam())
					.add("straat", p.getStraat())
					.add("huisnummer", p.getHuisNummer())
					.add("woonplaats", p.getWoonplaats())
					.add("postcode", p.getPostcode())
					.add("email", p.getEmail())
					.add("gbdatum", df.format(p.getGbdatum()))
					.add("geslacht", p.getGeslacht())
					.add("telefoonnummer", p.getTelnummer())
					.add("wachtwoord", p.getWachtwoord())
					.add("aanwezig", p.isAanwezig());
			
			job.add("bedrijf", job2);
			
			jab.add(job);
		}
		return jab.build().toString();
	}
	
	@POST
	@Produces("application/json")
	public String addPersoon(
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
			@FormParam("telnummer") String telnummer) throws ParseException {
//		System.out.println("komt hier" + gbdatum);
		Persoon persoon = new Persoon(nVoor, nAchter, straat, huisNummer,
				woonplaats, postcode, email, gbdatum, geslacht, telnummer);
//		System.out.println(persoon);
		service.addPersoon(persoon);
		
		return persoonToJson(persoon).build().toString();
	}
	
	private JsonObjectBuilder persoonToJson(Persoon p) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		
//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		job.add("voornaam", p.getVoornaam())
			.add("achternaam", p.getAchternaam())
			.add("straat", p.getStraat())
			.add("huisnummer", p.getHuisNummer())
			.add("woonplaats", p.getWoonplaats())
			.add("postcode", p.getPostcode())
			.add("email", p.getEmail())
			.add("gbdatum", p.getGbdatumS())
			.add("geslacht", p.getGeslacht())
			.add("telefoonnummer", p.getTelnummer())
			.add("bedrijfsid", p.getBedrijfsid());
		return job;
	}
}
