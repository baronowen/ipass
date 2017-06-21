package nl.hu.ipass.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.model.Verzoek;

public class VerzoekDAO extends BaseDAO {
	
	public List<Verzoek> findAll() {
		List<Verzoek> verzoeken = new ArrayList<Verzoek>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM verzoek");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int verzoekid = rs.getInt("verzoekid");
				String naam_bedrijf = rs.getString("naam_bedrijf");
				String voornaam = rs.getString("voornaam");
				String achternaam = rs.getString("achternaam");
				String straat = rs.getString("straat");
				String huisnummer = rs.getString("huisnummer");
				String woonplaats = rs.getString("woonplaats");
				String postcode = rs.getString("postcode");
				String email = rs.getString("email");
				Date gbdatum = rs.getDate("gbdatum");
				String geslacht = rs.getString("geslacht");
				String telnummer = rs.getString("telefoonnummer");
//				String wachtwoord = rs.getString("wachtwoord");
				boolean aanwezig = rs.getBoolean("aanwezig");
				Date datum_ontvangen = rs.getDate("datum_ontvangen");
				
				verzoeken.add(new Verzoek(verzoekid, naam_bedrijf,
						voornaam, achternaam, straat, 
						huisnummer, woonplaats, postcode,
						email, gbdatum, geslacht, telnummer,
						aanwezig, datum_ontvangen));
				
			}
			rs.close();
			pstat.close();
			
		} catch(SQLException s) {
			s.printStackTrace();
		}
		return verzoeken;
	}
	
	public Verzoek findVerzoekById(int id) {
		List<Verzoek> verzoeken = new ArrayList<Verzoek>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM verzoek WHERE verzoekid = '" + id + "'");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int verzoekid = rs.getInt("verzoekid");
				String naam_bedrijf = rs.getString("naam_bedrijf");
				String voornaam = rs.getString("voornaam");
				String achternaam = rs.getString("achternaam");
				String straat = rs.getString("straat");
				String huisnummer = rs.getString("huisnummer");
				String woonplaats = rs.getString("woonplaats");
				String postcode = rs.getString("postcode");
				String email = rs.getString("email");
				Date gbdatum = rs.getDate("gbdatum");
				String geslacht = rs.getString("geslacht");
				String telnummer = rs.getString("telefoonnummer");
//				String wachtwoord = rs.getString("wachtwoord");
				boolean aanwezig = rs.getBoolean("aanwezig");
				Date datum_ontvangen = rs.getDate("datum_ontvangen");
				
				verzoeken.add(new Verzoek(verzoekid, naam_bedrijf,
						voornaam, achternaam, straat, 
						huisnummer, woonplaats, postcode,
						email, gbdatum, geslacht, telnummer,
						aanwezig, datum_ontvangen));
			}
			
			if (verzoeken.size() > 0) {
				rs.close();
				pstat.close();
				return verzoeken.get(0);
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
	}
	
	public void saveVerzoek(Verzoek verzoek) throws ParseException {
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("INSERT INTO "
					+ "verzoek (naam_bedrijf, voornaam, achternaam, "
					+ "straat, huisnummer, woonplaats, "
					+ "postcode, email, gbdatum, "
					+ "geslacht, telefoonnummer, datum_ontvangen) "
					+ "VALUES(?,?,?,	?,?,?,		?,?,?,		?,?,?)");
			
			pstat.setString(1, verzoek.getNaam_bedrijf());
			pstat.setString(2, verzoek.getVoornaam());
			pstat.setString(3, verzoek.getAchternaam());
			pstat.setString(4, verzoek.getStraat());
			pstat.setString(5, verzoek.getNummer());
			pstat.setString(6, verzoek.getWoonplaats());
			pstat.setString(7, verzoek.getPostcode());
			pstat.setString(8, verzoek.getEmail());
			pstat.setDate(9, fromStringToDate(verzoek.getGbdatumS()));
			pstat.setString(10, verzoek.getGeslacht());
			pstat.setString(11, verzoek.getTelnummer());
//			pstat.setString(12, verzoek.getWachtwoord());
			pstat.setDate(12, fromStringToDate(verzoek.getDatum_ontvangenS()));
			
//			System.out.println("komt hier");
			
			pstat.executeUpdate();
			
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void deleteVerzoekById(int verzoekid) {
		try (Connection conn = super.getConnection()) {
			PreparedStatement p = conn.prepareStatement("DELETE FROM verzoek "
					+ " WHERE verzoekid = ?");
			
			p.setInt(1, verzoekid);
			
			p.executeUpdate();
//			System.out.println("Verzoek verwijderd!");
			
			p.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	private java.sql.Date fromStringToDate(String s) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate = sdf.parse(s);
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		
		return sqlDate;
	}

}
