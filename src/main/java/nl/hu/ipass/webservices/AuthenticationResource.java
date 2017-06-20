package nl.hu.ipass.webservices;

import java.security.Key;
import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.ipass.persistence.PersoonDAO;

@Path("/authentication")
public class AuthenticationResource {
	final static public Key key = MacProvider.generateKey();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("email") String email, @FormParam("psw") String psw) {
		try {
			// Authenticate the user against the database
			PersoonDAO dao = new PersoonDAO();
			String role = dao.findRoleForEmailAndPassword(email, psw);
			
			if (role == null) { 
//				throw new IllegalArgumentException("No user found!");
//				System.out.println("no user found"); 
				return Response.status(Status.NOT_FOUND).build();
			}
//			System.out.println(role);
			// Issue a token for the user
			Calendar expiration = Calendar.getInstance();
			expiration.add(Calendar.MINUTE, 30);
			String token = Jwts.builder().setSubject(email).claim("role", role).setExpiration(expiration.getTime())
					.signWith(SignatureAlgorithm.HS512, key).compact();
			
			String tokenandrole = token + "roleName:" + role;
			
//			System.out.println(token);
//			System.out.println("user found!");
			
			// Return the token on the response
			return Response.ok(tokenandrole).build();
			
		} catch (JwtException | IllegalArgumentException e) {
//			System.out.println("unauthorized");
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}
