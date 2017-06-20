package nl.hu.ipass.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.model.Functie;

public class FunctieDAO extends BaseDAO {
	
	public List<Functie> findAll() {
		List<Functie> functies = new ArrayList<Functie>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM functie");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int functieid = rs.getInt("functieid");
				String naam = rs.getString("naam");
				
				functies.add(new Functie(functieid, naam));
			}
			
			rs.close();
			pstat.close();
		
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return functies;
	}
	
	public Functie findFunctieById(int id) {
		List<Functie> functies = new ArrayList<Functie>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM functie WHERE functieid = ?");
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int functieid = rs.getInt("functieid");
				String naam = rs.getString("naam");
				
				functies.add(new Functie(functieid, naam));
			}
			
			if (functies.size() > 0) {
				rs.close();
				pstat.close();
				return functies.get(0);
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
	}
}
