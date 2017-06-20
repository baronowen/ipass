package nl.hu.ipass.webservices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.hu.ipass.model.Historie;
import nl.hu.ipass.model.HistorieService;
import nl.hu.ipass.model.ServiceProvider;

@Path("/histories")
public class HistorieResource {
	private HistorieService service = ServiceProvider.getHistorieService();

	@GET
	@RolesAllowed("moderator")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllHistories() {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Historie h : service.getAllHistories()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			JsonObjectBuilder job2 = Json.createObjectBuilder();
			JsonObjectBuilder job3 = Json.createObjectBuilder();

			job2.add("persoonsid", h.getPersoon().getPersoonsid()).add("voornaam", h.getPersoon().getVoornaam())
					.add("achternaam", h.getPersoon().getAchternaam())
					.add("telefoonnummer", h.getPersoon().getTelnummer()).add("email", h.getPersoon().getEmail())
					.add("aanwezig", h.getPersoon().isAanwezig());
			// .add("naam_bedrijf", h.getPersoon().getBedrijf().getNaam());

			job3.add("bedrijfsid", h.getPersoon().getBedrijf().getBedrijfsid()).add("bedrijfsnaam",
					h.getPersoon().getBedrijf().getNaam());

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			DateFormat tf = new SimpleDateFormat("HH:mm:ss");

			job.add("historieid", h.getHistorieid()).add("datum", df.format(h.getDatum()))
					.add("aankomst_tijd", tf.format(h.getAankomst_tijd()))
					.add("vertrek_tijd", tf.format(h.getVertrek_tijd()))

					.add("persoon", job2).add("bedrijf", job3);
			jab.add(job);
		}

		return jab.build().toString();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHistorieById(@PathParam("id") int id) {
		Historie h = service.getHistorieById(id);
		JsonObjectBuilder job = Json.createObjectBuilder();

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat tf = new SimpleDateFormat("HH:mm:ss");

		job.add("historieid", h.getHistorieid()).add("datum", df.format(h.getDatum()))
				.add("aankomst_tijd", tf.format(h.getAankomst_tijd()))
				.add("vertrek_tijd", tf.format(h.getVertrek_tijd()));
		return job.build().toString();
	}

	@GET
	@RolesAllowed("moderator")
	@Path("/aanwezigen")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAanwezigen() {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Historie h : service.getAanwezigen()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			JsonObjectBuilder job2 = Json.createObjectBuilder();
			JsonObjectBuilder job3 = Json.createObjectBuilder();

			job2.add("persoonsid", h.getPersoon().getPersoonsid())
					.add("voornaam", h.getPersoon().getVoornaam())
					.add("achternaam", h.getPersoon().getAchternaam())
					.add("telefoonnummer", h.getPersoon().getTelnummer()).add("email", h.getPersoon().getEmail())
					.add("aanwezig", h.getPersoon().isAanwezig());
			// .add("naam_bedrijf", h.getPersoon().getBedrijf().getNaam());

			job3.add("bedrijfsid", h.getPersoon().getBedrijf().getBedrijfsid()).add("bedrijfsnaam",
					h.getPersoon().getBedrijf().getNaam());

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			DateFormat tf = new SimpleDateFormat("HH:mm:ss");

			job.add("historieid", h.getHistorieid()).add("datum", df.format(h.getDatum()))
					.add("aankomst_tijd", tf.format(h.getAankomst_tijd()))
					.add("vertrek_tijd", tf.format(h.getVertrek_tijd()))

					.add("persoon", job2).add("bedrijf", job3);
			jab.add(job);
		}

		return jab.build().toString();
	}
}
