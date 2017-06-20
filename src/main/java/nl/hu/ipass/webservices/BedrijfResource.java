package nl.hu.ipass.webservices;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.hu.ipass.model.Bedrijf;
import nl.hu.ipass.model.BedrijfService;
import nl.hu.ipass.model.ServiceProvider;

@Path("/bedrijven")
public class BedrijfResource {
	private BedrijfService service = ServiceProvider.getBedrijfService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllBedrijven() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Bedrijf b : service.getAllBedrijven()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			job.add("bedrijfsid", b.getBedrijfsid())
					.add("naam", b.getNaam())
					.add("locatie", b.getLocatie());
			jab.add(job);
		}
		
		return jab.build().toString();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBedrijfById(@PathParam("id") int id) {
		Bedrijf b = service.getBedrijfById(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("bedrijfsid", b.getBedrijfsid())
				.add("naam", b.getNaam())
				.add("locatie", b.getLocatie());
		return job.build().toString();
	}
}
