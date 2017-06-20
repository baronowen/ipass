package nl.hu.ipass.model;

import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.persistence.VerzoekDAO;

public class VerzoekService {
	private VerzoekDAO VerzoekDAO = new VerzoekDAO();
	
	public List<Verzoek> getAllVerzoeken() { return VerzoekDAO.findAll(); }
	
	public Verzoek getVerzoekById(int id) { return VerzoekDAO.findVerzoekById(id); }
	
	public void addVerzoek(Verzoek verzoek) throws ParseException { VerzoekDAO.saveVerzoek(verzoek); }
	
	public void deleteVerzoek(int verzoekid) { VerzoekDAO.deleteVerzoekById(verzoekid); }
}
