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

import nl.hu.ipass.model.Bedrijf;
import nl.hu.ipass.model.Functie;
import nl.hu.ipass.model.Persoon;
import nl.hu.ipass.model.Sleutel;

public class PersoonDAO extends BaseDAO {
	
	public List<Persoon> findAll() {
		List<Persoon> personen = new ArrayList<Persoon>();
		
		FunctieDAO fdao = new FunctieDAO();
		SleutelDAO sdao = new SleutelDAO();
		BedrijfDAO bdao = new BedrijfDAO();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM persoon");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int persoonsid = rs.getInt("persoonsid");
				String voornaam = rs.getString("voornaam");
				String achternaam = rs.getString("achternaam");
				String straat = rs.getString("straat");
				String nummer = rs.getString("huisnummer");
				String woonplaats = rs.getString("woonplaats");
				String postcode = rs.getString("postcode");
				String email = rs.getString("email");
				Date gbdatum = rs.getDate("gbdatum");
				String geslacht = rs.getString("geslacht");
				String telnummer = rs.getString("telefoonnummer");
				String wachtwoord = rs.getString("wachtwoord");
				boolean aanwezig = rs.getBoolean("aanwezig");
				
				int functieid = rs.getInt("functieid");
				int sleutelid = rs.getInt("sleutelid");
				int bedrijfsid = rs.getInt("bedrijfsid");
				
				Functie f = fdao.findFunctieById(functieid);
				Sleutel s = sdao.findSleutelById(sleutelid);
				Bedrijf b = bdao.findBedrijfById(bedrijfsid);
				
				personen.add(new Persoon(persoonsid, voornaam, achternaam,
						straat, nummer, woonplaats, postcode, email,
						gbdatum, geslacht, telnummer, wachtwoord, aanwezig, f, s, b));
			}
			
			rs.close();
			pstat.close();
						
		} catch(SQLException s) {
			s.printStackTrace();
		}
		return personen;
	}
	
	public Persoon findPersoonById(int id) {
		List<Persoon> personen = new ArrayList<Persoon>();
		
		FunctieDAO fdao = new FunctieDAO();
		SleutelDAO sdao = new SleutelDAO();
		BedrijfDAO bdao = new BedrijfDAO();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM persoon WHERE persoonsid = ?");
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int persoonsid = rs.getInt("persoonsid");
				String voornaam = rs.getString("voornaam");
				String achternaam = rs.getString("achternaam");
				String straat = rs.getString("straat");
				String nummer = rs.getString("huisnummer");
				String woonplaats = rs.getString("woonplaats");
				String postcode = rs.getString("postcode");
				String email = rs.getString("email");
				Date gbdatum = rs.getDate("gbdatum");
				String geslacht = rs.getString("geslacht");
				String telnummer = rs.getString("telefoonnummer");
				String wachtwoord = rs.getString("wachtwoord");
				boolean aanwezig = rs.getBoolean("aanwezig");
				
				int functieid = rs.getInt("functieid");
				int sleutelid = rs.getInt("sleutelid");
				int bedrijfsid = rs.getInt("bedrijfsid");
				
				Functie f = fdao.findFunctieById(functieid);
				Sleutel s = sdao.findSleutelById(sleutelid);
				Bedrijf b = bdao.findBedrijfById(bedrijfsid);
				
				personen.add(new Persoon(persoonsid, voornaam, achternaam,
						straat, nummer, woonplaats, postcode, email,
						gbdatum, geslacht, telnummer, wachtwoord, aanwezig, f, s, b));
			}
			
			if (personen.size() > 0) {
				rs.close();
				pstat.close();
				return personen.get(0);
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
	}
	
	public List<Persoon> findAanwezigen() {
		List<Persoon> personen = new ArrayList<Persoon>();
		
		FunctieDAO fdao = new FunctieDAO();
		SleutelDAO sdao = new SleutelDAO();
		BedrijfDAO bdao = new BedrijfDAO();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM persoon WHERE aanwezig = 1");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int persoonsid = rs.getInt("persoonsid");
				String voornaam = rs.getString("voornaam");
				String achternaam = rs.getString("achternaam");
				String straat = rs.getString("straat");
				String nummer = rs.getString("huisnummer");
				String woonplaats = rs.getString("woonplaats");
				String postcode = rs.getString("postcode");
				String email = rs.getString("email");
				Date gbdatum = rs.getDate("gbdatum");
				String geslacht = rs.getString("geslacht");
				String telnummer = rs.getString("telefoonnummer");
				String wachtwoord = rs.getString("wachtwoord");
				boolean aanwezig = rs.getBoolean("aanwezig");
				
				int functieid = rs.getInt("functieid");
				int sleutelid = rs.getInt("sleutelid");
				int bedrijfsid = rs.getInt("bedrijfsid");
				
				Functie f = fdao.findFunctieById(functieid);
				Sleutel s = sdao.findSleutelById(sleutelid);
				Bedrijf b = bdao.findBedrijfById(bedrijfsid);
				
				personen.add(new Persoon(persoonsid, voornaam, achternaam,
						straat, nummer, woonplaats, postcode, email,
						gbdatum, geslacht, telnummer, wachtwoord, aanwezig, f, s, b));
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return personen;
	}
	
	public String findRoleForEmailAndPassword(String email, String wachtwoord) {
		String role = null;
		String query = "SELECT f.naam "
				+ "FROM functie f, persoon p "
				+ "WHERE p.functieid = f.functieid "
				+ "AND (p.email = ? "
				+ "AND p.wachtwoord = ?)";
		
		try (Connection conn = super.getConnection()) {
			
			PreparedStatement pstat = conn.prepareStatement(query);
			pstat.setString(1, email);
			pstat.setString(2, wachtwoord);
			
			ResultSet rs = pstat.executeQuery();
			
			if (rs.next()) {
				role = rs.getString("naam");
				System.out.println(role);
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return role;
	}
	
	public void savePersoon(Persoon persoon) throws ParseException {
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("INSERT "
					+ "INTO persoon (voornaam, achternaam, straat, "
					+ "huisnummer, woonplaats, postcode, email, "
					+ "gbdatum, geslacht, telefoonnummer) "
					+ "VALUES(?,?,?, ?,?,?,?, ?,?,?");
			
			pstat.setString(1, persoon.getVoornaam());
			pstat.setString(2, persoon.getAchternaam());
			pstat.setString(3, persoon.getStraat());
			
			pstat.setString(4, persoon.getHuisNummer());
			pstat.setString(5, persoon.getWoonplaats());
			pstat.setString(6, persoon.getPostcode());
			pstat.setString(7, persoon.getEmail());
			
			pstat.setDate(8, fromStringToDate(persoon.getGbdatumS()));
			pstat.setString(9, persoon.getGeslacht());
			pstat.setString(10, persoon.getTelnummer());
//			pstat.setString(11, persoon.getWachtwoord());
			
//			pstat.setString(11, persoon.getBedrijf().getNaam());
//			System.out.println(persoon.getBedrijf().getNaam());
			
			pstat.executeUpdate();
			
			pstat.close();
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
