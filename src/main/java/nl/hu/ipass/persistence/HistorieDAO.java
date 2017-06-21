package nl.hu.ipass.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.model.Historie;
import nl.hu.ipass.model.Persoon;

public class HistorieDAO extends BaseDAO {
	
	public List<Historie> findAll() {
		List<Historie> histories = new ArrayList<Historie>();
		
		PersoonDAO pdao = new PersoonDAO();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT h.* "
					+ "FROM historie h, persoon p "
					+ "WHERE h.persoonsid = p.persoonsid "
					+ "AND (p.aanwezig != true OR vertrek_tijd != '00:00:00')");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int historieid = rs.getInt("historieid");
//				System.out.println(historieid);
				Date datum = rs.getDate("datum");
//				System.out.println(datum);
				Time aankomst_tijd = rs.getTime("aankomst_tijd");
//				System.out.println(aankomst_tijd);
				Time vertrek_tijd = rs.getTime("vertrek_tijd");
//				System.out.println(vertrek_tijd);
				int persoonsid = rs.getInt("persoonsid");
//				System.out.println(persoonsid);
//				System.out.println("    ");
				
				Persoon p = pdao.findPersoonById(persoonsid);
				
				histories.add(new Historie(historieid, datum, 
						aankomst_tijd, vertrek_tijd, p));
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return histories;
	}
	
	public List<Historie> findAanwezigen() {
		List<Historie> histories = new ArrayList<Historie>();
		
		PersoonDAO pdao = new PersoonDAO();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT h.*, p.* "
					+ "FROM historie h, persoon p "
					+ "WHERE h.persoonsid = p.persoonsid "
					+ "AND p.aanwezig = true "
					+ "AND vertrek_tijd = '00:00:00'");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int historieid = rs.getInt("historieid");
				Date datum = rs.getDate("datum");
				Time aankomst_tijd = rs.getTime("aankomst_tijd");
				Time vertrek_tijd = rs.getTime("vertrek_tijd");
				int persoonsid = rs.getInt("persoonsid");
				
				Persoon p = pdao.findPersoonById(persoonsid);
				
				histories.add(new Historie(historieid, datum, 
						aankomst_tijd, vertrek_tijd, p));
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return histories;
	}
	
	public Historie findHistorieById(int id) {
		List<Historie> histories = new ArrayList<Historie>();
		
		try (Connection conn = super.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("SELECT * FROM historie WHERE historieid = '" + id + "'");
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				int historieid = rs.getInt("historieid");
				Date datum = rs.getDate("datum");
				Time aankomst_tijd = rs.getTime("aankomst_tijd");
				Time vertrek_tijd = rs.getTime("vertrek_tijd");
				
				histories.add(new Historie(historieid, datum, aankomst_tijd, vertrek_tijd));
			}
			
			if (histories.size() > 0) {
				rs.close();
				pstat.close();
				return histories.get(0);
			}
			
			rs.close();
			pstat.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return null;
	}

}
