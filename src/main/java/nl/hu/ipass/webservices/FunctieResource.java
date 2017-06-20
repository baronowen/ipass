package nl.hu.ipass.webservices;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.hu.ipass.model.Functie;
import nl.hu.ipass.model.FunctieService;
import nl.hu.ipass.model.ServiceProvider;

@Path("/functies")
public class FunctieResource {
	private FunctieService service = ServiceProvider.getFunctieService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllFuncties() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Functie f : service.getAllFuncties()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			job.add("functieid", f.getFunctieid())
					.add("naam", f.getNaam());
			jab.add(job);
		}
		
		return jab.build().toString();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFunctieById(@PathParam("id") int id) {
		Functie f = service.getFunctieById(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("functieid", f.getFunctieid())
				.add("naam", f.getNaam());
		return job.build().toString();
	}
}
