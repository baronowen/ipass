package nl.hu.ipass.model;

import java.util.List;

import nl.hu.ipass.persistence.SleutelDAO;

public class SleutelService {
	private SleutelDAO SleutelDAO = new SleutelDAO();
	
	public List<Sleutel> getAllSleutels() { return SleutelDAO.findAll(); }
	
	public Sleutel getSleutelById(int id) { return SleutelDAO.findSleutelById(id); }
	
	public void addSleutel(Sleutel newSleutel) { SleutelDAO.saveSleutel(newSleutel); }
}
