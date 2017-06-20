package nl.hu.ipass.webapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Scanner;

//import nl.hu.ipass.persistence.BaseDAO;

public class App {
	private static final String db_driv = "com.mysql.jdbc.Driver";
	private static final String db_url = "jdbc:mysql://localhost:3306/ipass_test";
	private static final String db_user = "java";
	private static final String db_pass = "password";
	private static Connection conn;
	
	
	
    public static void main( String[] args ) throws SQLException {
    	
    	try {
    		Class.forName(db_driv).newInstance();
    	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
    		e1.printStackTrace();
    	}
    	
    	conn = DriverManager.getConnection(db_url, db_user, db_pass);
    	
    	Scanner scanner = new Scanner(System.in);
		
		while (true) {
			Time huidige_tijd = new Time(Calendar.getInstance().getTime().getTime());
			System.out.println("Voer uw sleutelcode in: ");
			
			int code = scanner.nextInt();
			
			String stringcode = Integer.toString(code);
			
			if (stringcode.length() == 5) {
				System.out.println("Ingevoerde sleutel: " + code);
				System.out.println("Checking database...");
				
				PreparedStatement p = conn.prepareStatement("SELECT "
						+ "p.persoonsid, p.voornaam, p.achternaam, p.aanwezig "
						+ "FROM persoon p, sleutel s "
						+ "WHERE p.sleutelid = s.sleutelid "
						+ "AND s.sleutelcode = ?");
				
				p.setInt(1, code);
				ResultSet rs = p.executeQuery();
				if (rs.next()) {
//					System.out.println("not supposed to be here!");
					int persoonsid = rs.getInt("persoonsid");
					String voornaam = rs.getString("voornaam");
					String achternaam = rs.getString("achternaam");
					boolean aanwezig = rs.getBoolean("aanwezig");
					
					String naam = voornaam + " " + achternaam;
					System.out.println("Welkom " + naam);
//					System.out.println(aanwezig);
					
					PreparedStatement p6 = conn.prepareStatement("SELECT "
							+ "MAX(aankomst_tijd) AS aankomst_tijd "
							+ "FROM historie "
							+ "WHERE persoonsid = ? "
							+ "AND datum = (SELECT MAX(datum) "
							+ "		FROM historie "
							+ "		WHERE persoonsid = ?)");
					p6.setInt(1, persoonsid);
					p6.setInt(2, persoonsid);
					ResultSet rs2 = p6.executeQuery();
					
					rs2.next();
					
					Time aankomst_tijd = rs2.getTime("aankomst_tijd");
					System.out.println(aankomst_tijd);
					
					//Select persoonsid:
					System.out.println("Updating table persoon...");
					if (aanwezig == false) {
						//Update persoon where persoonsid = persoonsid hierboven
						PreparedStatement p2 = conn.prepareStatement("UPDATE"
								+ " persoon"
								+ " SET aanwezig = 1"
								+ " WHERE persoonsid = ?");
						p2.setInt(1, persoonsid);
						p2.executeUpdate();
						
						System.out.println(persoonsid + " " + naam + " staat nu op aanwezig");
						System.out.println();
						
						//inserten historie:
						System.out.println("Inserting into historie...");
						Date huidige_datum = new Date(Calendar.getInstance().getTime().getTime());
						System.out.println(huidige_datum);
						
//						Time huidige_tijd = new Time(Calendar.getInstance().getTime().getTime());
						System.out.println(huidige_tijd);
						
						PreparedStatement p3 = conn.prepareStatement("INSERT INTO"
								+ " historie (datum, aankomst_tijd, persoonsid)"
								+ " VALUES (?, ?, (SELECT p.persoonsid"
								+ " FROM persoon p, sleutel s"
								+ " WHERE p.sleutelid = s.sleutelid"
								+ " AND s.sleutelcode = ?))");
						p3.setDate(1, huidige_datum);
						p3.setTime(2, huidige_tijd);
						p3.setInt(3, code);
						
						p3.executeUpdate();
						
						System.out.println(naam + " staat nu in historie");
						
					}
					else if (aanwezig == true) {
						//Updaten persoon
						PreparedStatement p4 = conn.prepareStatement("UPDATE"
								+ " persoon"
								+ " SET aanwezig = 0"
								+ " WHERE persoonsid = ?");
						p4.setInt(1, persoonsid);
						p4.executeUpdate();
						
						System.out.println(persoonsid + " " + naam + " staat nu op afwezig.");
						System.out.println();
						
						//updaten historie:
						System.out.println("Updating historie:");
						
//						Time huidige_vertrek_tijd = new Time(Calendar.getInstance().getTime().getTime());
						System.out.println(huidige_tijd);
						
						PreparedStatement p5 = conn.prepareStatement("UPDATE"
								+ " historie h1"
								+ " SET h1.vertrek_tijd = ?"
								+ " WHERE h1.persoonsid = ?"
								+ " AND aankomst_tijd = ?");
						
						
					
						p5.setTime(1, huidige_tijd);
						p5.setInt(2, persoonsid);
						p5.setTime(3, aankomst_tijd);
											
						p5.executeUpdate();
						
						System.out.println(persoonsid + " " + naam +" " + huidige_tijd);
						
					}
				}
			} else if (Integer.toString(code).length() > 5) {
				System.out.println("Ingevoerde code is te groot!");
				
			} else if (Integer.toString(code).length() < 5) {
        		System.out.println("Ingevoerde code is te klein!");
        	}
			
		}
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
    }
}
