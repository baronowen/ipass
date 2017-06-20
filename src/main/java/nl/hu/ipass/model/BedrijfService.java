package nl.hu.ipass.model;

import java.util.List;

import nl.hu.ipass.persistence.BedrijfDAO;

public class BedrijfService {
	private BedrijfDAO BedrijfDAO = new BedrijfDAO();
	
	public List<Bedrijf> getAllBedrijven() { return BedrijfDAO.findAll(); }
	
	public Bedrijf getBedrijfById(int id) { return BedrijfDAO.findBedrijfById(id); }
	
	
	
}
