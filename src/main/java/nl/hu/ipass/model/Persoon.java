package nl.hu.ipass.model;

import java.sql.Date;

public class Persoon {
	private int persoonsid;
	private String voornaam;
	private String achternaam;
	private String straat;
	private String huisnummer;
	private String woonplaats;
	private String postcode;
	private String email;
	
	private Date gbdatum;
	private String gbdatumS;
	
	private String geslacht;
	private String telnummer;
	private String wachtwoord;
	private boolean aanwezig;
	private int functieid;
	private int sleutelid;
	private int bedrijfsid;
	
	private Functie functie;
	private Sleutel sleutel;
	private Bedrijf bedrijf;
	
	public Persoon(String voornaam, String achternaam, String straat, String huisnummer,
			String woonplaats, String postcode, String email, String gbdatumS, String geslacht, String telnummer) {
		super();
//		this.persoonsid = persoonsid;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.gbdatumS = gbdatumS;
		this.geslacht = geslacht;
		this.telnummer = telnummer;
//		this.wachtwoord = wachtwoord;
//		this.aanwezig = aanwezig;
	}

	public Persoon(String voornaam, String achternaam, String straat, String huisnummer,
			String woonplaats, String postcode, String email, Date gbdatum, String geslacht, String telnummer) {
		super();
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.gbdatum = gbdatum;
		this.geslacht = geslacht;
		this.telnummer = telnummer;
	}
	
	public Persoon(String voornaam, String achternaam, Sleutel sleutel) {
		super();
		this.voornaam = voornaam;
		this.sleutel = sleutel;
	}

	public Persoon(int persoonsid, String voornaam, String achternaam, String straat, String huisnummer, String woonplaats,
			String postcode, String email, Date gbdatum, String geslacht, String telnummer, String wachtwoord,
			boolean aanwezig, int functieid, int sleutelid, int bedrijfsid) {
		super();
		this.persoonsid = persoonsid;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.gbdatum = gbdatum;
		this.geslacht = geslacht;
		this.telnummer = telnummer;
		this.wachtwoord = wachtwoord;
		this.aanwezig = aanwezig;
		
		this.functieid = functieid;
		this.sleutelid = sleutelid;
		this.bedrijfsid = bedrijfsid;
	}
	
	public Persoon(int persoonsid, String voornaam, String achternaam, String straat, String huisnummer, String woonplaats,
			String postcode, String email, Date gbdatum, String geslacht, String telnummer, String wachtwoord,
			boolean aanwezig, Functie functie, Sleutel sleutel, Bedrijf bedrijf) {
		super();
		this.persoonsid = persoonsid;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.gbdatum = gbdatum;
		this.geslacht = geslacht;
		this.telnummer = telnummer;
		this.wachtwoord = wachtwoord;
		this.aanwezig = aanwezig;
		
		this.functie = functie;
		this.sleutel = sleutel;
		this.bedrijf = bedrijf;
		
	}
	
	public Persoon() {
		
	}
	
	@Override
	public String toString() {
		return "Persoon [persoonsid=" + persoonsid + ", voornaam=" + voornaam + ", achternaam=" + achternaam
				+ ", straat=" + straat + ", huisnummer=" + huisnummer + ", woonplaats=" + woonplaats + ", postcode="
				+ postcode + ", email=" + email + ", gbdatum=" + gbdatum + gbdatumS + ", geslacht=" + geslacht + ", telnummer="
				+ telnummer + ", wachtwoord=" + wachtwoord + ", aanwezig=" + aanwezig + "]";
	}

	public int getPersoonsid() {
		return persoonsid;
	}

	public void setPersoonsid(int persoonsid) {
		this.persoonsid = persoonsid;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisNummer() {
		return huisnummer;
	}

	public void setHuisNummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getTelnummer() {
		return telnummer;
	}

	public void setTelnummer(String telnummer) {
		this.telnummer = telnummer;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public boolean isAanwezig() {
		return aanwezig;
	}

	public void setAanwezig(boolean aanwezig) {
		this.aanwezig = aanwezig;
	}

	public int getFunctieid() {
		return functieid;
	}

	public void setFunctieid(int functieid) {
		this.functieid = functieid;
	}

	public Functie getFunctie() {
		return functie;
	}

	public void setFunctie(Functie functie) {
		this.functie = functie;
	}

	public int getSleutelid() {
		return sleutelid;
	}

	public void setSleutelid(int sleutelid) {
		this.sleutelid = sleutelid;
	}

	public Sleutel getSleutel() {
		return sleutel;
	}

	public void setSleutel(Sleutel sleutel) {
		this.sleutel = sleutel;
	}

	public int getBedrijfsid() {
		return bedrijfsid;
	}

	public void setBedrijfsid(int bedrijfsid) {
		this.bedrijfsid = bedrijfsid;
	}

	public Bedrijf getBedrijf() {
		return bedrijf;
	}

	public void setBedrijf(Bedrijf bedrijf) {
		this.bedrijf = bedrijf;
	}

	public String getGbdatumS() {
		return gbdatumS;
	}

	public void setGbdatumS(String gbdatumS) {
		this.gbdatumS = gbdatumS;
	}
	
	
}
