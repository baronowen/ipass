package nl.hu.ipass.model;

public class Bedrijf {
	private int bedrijfsid;
	private String naam;
	private String locatie;
	
	public Bedrijf(int bedrijfsid, String naam, String locatie) {
		super();
		this.bedrijfsid = bedrijfsid;
		this.naam = naam;
		this.locatie = locatie;
	}

	@Override
	public String toString() {
		return "Bedrijf [bedrijfsid=" + bedrijfsid + ", naam=" + naam + ", locatie=" + locatie + "]";
	}

	public int getBedrijfsid() {
		return bedrijfsid;
	}

	public void setBedrijfsid(int bedrijfsid) {
		this.bedrijfsid = bedrijfsid;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
	
	

}
