package nl.hu.ipass.model;

public class Functie {
	private int functieid;
	private String naam;
	
	public Functie(int functieid, String naam) {
		super();
		this.functieid = functieid;
		this.naam = naam;
	}

	@Override
	public String toString() {
		return "Functie [functieid=" + functieid + ", naam=" + naam + "]";
	}

	public int getFunctieid() {
		return functieid;
	}

	public void setFunctieid(int functieid) {
		this.functieid = functieid;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	
}
