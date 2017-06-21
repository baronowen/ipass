package nl.hu.ipass.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.model.Bedrijf;

public class BedrijfDAO extends BaseDAO {
	
	public List<Bedrijf> findAll() {
		List<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * "
					+ "FROM bedrijf");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int bedrijfsid = rs.getInt("bedrijfsid");
				String naam = rs.getString("naam");
				String locatie = rs.getString("locatie");
				
				bedrijven.add(new Bedrijf(bedrijfsid, naam, locatie));
			}
			
			rs.close();
			pstat.close();
			
		} catch(SQLException s) {
			s.printStackTrace();
		}
		return bedrijven;
	}
	
	public Bedrijf findBedrijfById(int id) {
		List<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * "
					+ "FROM bedrijf "
					+ "WHERE bedrijfsid = '" + id + "'");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int bedrijfsid = rs.getInt("bedrijfsid");
				String naam = rs.getString("naam");
				String locatie = rs.getString("locatie");
				
				bedrijven.add(new Bedrijf(bedrijfsid, naam, locatie));
			}
			
			if (bedrijven.size() > 0) {
				rs.close();
				pstat.close();
				return bedrijven.get(0);
			}
			
			rs.close();
			pstat.close();
			
		} catch(SQLException s) {
			s.printStackTrace();
		}
		return null;
	}

}
