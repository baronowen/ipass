package nl.hu.ipass.model;

import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.persistence.PersoonDAO;

public class PersoonService {
	private PersoonDAO PersoonDAO = new PersoonDAO();
	
	public List<Persoon> getAllPersonen() { return PersoonDAO.findAll(); }
	
	public Persoon getPersoonById(int id) { return PersoonDAO.findPersoonById(id); }
	
	public List<Persoon> getAanwezigen() { return PersoonDAO.findAanwezigen(); }

	public List<Persoon> getExtraInfoPersonen() { return PersoonDAO.findAll(); }
	
	public void addPersoon(Persoon newPersoon) throws ParseException { PersoonDAO.savePersoon(newPersoon); }
}
