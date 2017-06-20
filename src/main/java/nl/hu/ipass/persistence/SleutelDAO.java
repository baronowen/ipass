package nl.hu.ipass.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.model.Sleutel;

public class SleutelDAO extends BaseDAO {
	
	public List<Sleutel> findAll() {
		List<Sleutel> sleutels = new ArrayList<Sleutel>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * "
					+ "FROM sleutel");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int sleutelid = rs.getInt("sleutelid");
				int sleutelcode = rs.getInt("sleutelcode");
				
				sleutels.add(new Sleutel(sleutelid, sleutelcode));
			}
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return sleutels;
	}
	
	public void saveSleutel(Sleutel sleutel) {
//		System.out.println(sleutel);
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement p = conn.prepareStatement("INSERT INTO "
					+ "sleutel(sleutelcode) VALUES(?)");
			
			p.setInt(1, sleutel.getSleutelcode());
			
			p.executeUpdate();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public Sleutel findSleutelById(int id) {
		List<Sleutel> sleutels = new ArrayList<Sleutel>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * "
					+ "FROM sleutel WHERE sleutelid = '" + id + "'");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int sleutelid = rs.getInt("sleutelid");
				int sleutelcode = rs.getInt("sleutelcode");
				
				sleutels.add(new Sleutel(sleutelid, sleutelcode));
			}
			
			if (sleutels.size() > 0) {
				rs.close();
				pstat.close();
				return sleutels.get(0);
			}
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
	}
}
