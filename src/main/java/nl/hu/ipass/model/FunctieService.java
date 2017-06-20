package nl.hu.ipass.model;

import java.util.List;

import nl.hu.ipass.persistence.FunctieDAO;

public class FunctieService {
	private FunctieDAO FunctieDAO = new FunctieDAO();
	
	public List<Functie> getAllFuncties() { return FunctieDAO.findAll(); }
	
	public Functie getFunctieById(int id) { return FunctieDAO.findFunctieById(id); }
	
	

}
