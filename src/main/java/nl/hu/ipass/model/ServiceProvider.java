package nl.hu.ipass.model;

public class ServiceProvider {
	private static PersoonService persoonService = new PersoonService();
	private static SleutelService sleutelService = new SleutelService();
	private static VerzoekService verzoekService = new VerzoekService();
	private static BedrijfService bedrijfService = new BedrijfService();	
	private static FunctieService functieService = new FunctieService();
	private static HistorieService historieService = new HistorieService();
	
	public static PersoonService getPersoonService() {
		return persoonService;
	}
	
	public static SleutelService getSleutelService() {
		return sleutelService;
	}
	
	public static VerzoekService getVerzoekService() {
		return verzoekService;
	}
	
	public static BedrijfService getBedrijfService() {
		return bedrijfService;
	}
	
	public static FunctieService getFunctieService() {
		return functieService;
	}
	
	public static HistorieService getHistorieService() {
		return historieService;
	}
	
	
}
