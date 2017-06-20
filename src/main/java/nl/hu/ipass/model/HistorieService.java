package nl.hu.ipass.model;

import java.util.List;

import nl.hu.ipass.persistence.HistorieDAO;

public class HistorieService {
	private HistorieDAO HistorieDAO = new HistorieDAO();
	
	public List<Historie> getAllHistories() { return HistorieDAO.findAll(); }
	
	public Historie getHistorieById(int id) { return HistorieDAO.findHistorieById(id); }
	
	public List<Historie> getAanwezigen() { return HistorieDAO.findAanwezigen(); }	
}
