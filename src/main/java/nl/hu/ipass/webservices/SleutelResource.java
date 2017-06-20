package nl.hu.ipass.webservices;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import nl.hu.ipass.model.ServiceProvider;
import nl.hu.ipass.model.Sleutel;
import nl.hu.ipass.model.SleutelService;

@Path("/sleutels")
public class SleutelResource {
	
	private SleutelService service = ServiceProvider.getSleutelService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSleutels() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Sleutel s : service.getAllSleutels()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			job.add("sleutelid", s.getSleutelid())
					.add("sleutelcode", s.getSleutelcode());
			jab.add(job);
		}
		
		return jab.build().toString();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSleutelById(@PathParam("id") int id) {
		Sleutel s = service.getSleutelById(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("sleutelid", s.getSleutelid())
				.add("sleutelcode", s.getSleutelcode());
		return job.build().toString();
	}
	
	@POST
//	@RolesAllowed("moderator")
	@Produces("application/json")
	public String addSleutel(@FormParam("code") int code) {
		Sleutel newSleutel = new Sleutel(code);
		
		service.addSleutel(newSleutel);
		
		return sleutelToJson(newSleutel).build().toString();
	}
	
	private JsonObjectBuilder sleutelToJson(Sleutel s) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", s.getSleutelid());
		job.add("code", s.getSleutelcode());
		
		return job;
	}

}
