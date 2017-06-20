package nl.hu.ipass.model;

import java.sql.Date;

public class Verzoek {
	private int verzoekid;
	private String naam_bedrijf;
	private String voornaam;
	private String achternaam;
	private String straat;
	private String nummer;
	private String woonplaats;
	private String postcode;
	private String email;
	
	private Date gbdatum;
	private String gbdatumS;
	
	private String geslacht;
	private String telnummer;
//	private String wachtwoord;
	private boolean aanwezig;
	
	private Date datum_ontvangen;
	private String datum_ontvangenS;
	
	public Verzoek(String naam_bedrijf, String voornaam, String achternaam, String straat, String nummer,
			String woonplaats, String postcode, String email, String gbdatumS, String geslacht, String telnummer,
			String datum_ontvangenS) {
		super();
		
//		this.verzoekid = verzoekid;
		this.naam_bedrijf = naam_bedrijf;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.nummer = nummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.setGbdatumS(gbdatumS);
		this.geslacht = geslacht;
		this.telnummer = telnummer;
		this.setDatum_ontvangenS(datum_ontvangenS);
	}

	public Verzoek(int verzoekid, String naam_bedrijf, String voornaam, String achternaam, String straat, String nummer,
			String woonplaats, String postcode, String email, Date gbdatum, String geslacht, String telnummer,
			boolean aanwezig, Date datum_ontvangen) {
		super();
		this.verzoekid = verzoekid;
		this.naam_bedrijf = naam_bedrijf;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.nummer = nummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.gbdatum = gbdatum;
		this.geslacht = geslacht;
		this.telnummer = telnummer;
//		this.wachtwoord = wachtwoord;
		this.aanwezig = aanwezig;
		this.datum_ontvangen = datum_ontvangen;
	}
	
	public Verzoek(String naam_bedrijf, String voornaam, String achternaam, String straat, String nummer,
			String woonplaats, String postcode, String email, Date gbdatum, String geslacht, String telnummer,
			Date datum_ontvangen) {
		super();
//		this.verzoekid = verzoekid;
		this.naam_bedrijf = naam_bedrijf;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.straat = straat;
		this.nummer = nummer;
		this.woonplaats = woonplaats;
		this.postcode = postcode;
		this.email = email;
		this.gbdatum = gbdatum;
		this.geslacht = geslacht;
		this.telnummer = telnummer;
//		this.wachtwoord = wachtwoord;
//		this.aanwezig = aanwezig;
		this.datum_ontvangen = datum_ontvangen;
	}
	
	public Verzoek() {
		
	}

	@Override
	public String toString() {
		return "Verzoek [verzoekid=" + verzoekid + ", naam_bedrijf=" + naam_bedrijf + ", voornaam=" + voornaam
				+ ", achternaam=" + achternaam + ", straat=" + straat + ", nummer=" + nummer + ", woonplaats="
				+ woonplaats + ", postcode=" + postcode + ", email=" + email + ", gbdatum=" + gbdatum + ", geslacht="
				+ geslacht + ", telnummer=" + telnummer + ", aanwezig=" + aanwezig
				+ ", datum_ontvangen=" + datum_ontvangen + "]";
	}

	public int getVerzoekid() {
		return verzoekid;
	}

	public void setVerzoekid(int verzoekid) {
		this.verzoekid = verzoekid;
	}

	public String getNaam_bedrijf() {
		return naam_bedrijf;
	}

	public void setNaam_bedrijf(String naam_bedrijf) {
		this.naam_bedrijf = naam_bedrijf;
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

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
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
//		Date date = gbdatum;
//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//		String strgbdatum = df.format(date);
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

//	public String getWachtwoord() {
//		return wachtwoord;
//	}
//
//	public void setWachtwoord(String wachtwoord) {
//		this.wachtwoord = wachtwoord;
//	}

	public boolean isAanwezig() {
		return aanwezig;
	}

	public void setAanwezig(boolean aanwezig) {
		this.aanwezig = aanwezig;
	}

	public Date getDatum_ontvangen() {
//		Date date = datum_ontvangen;
//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//		String strdatum_ontvangen = df.format(date);
		return datum_ontvangen;
	}

	public void setDatum_ontvangen(Date datum_ontvangen) {
		this.datum_ontvangen = datum_ontvangen;
	}

	public String getGbdatumS() {
		return gbdatumS;
	}

	public void setGbdatumS(String gbdatumS) {
		this.gbdatumS = gbdatumS;
	}

	public String getDatum_ontvangenS() {
		return datum_ontvangenS;
	}

	public void setDatum_ontvangenS(String datum_ontvangenS) {
		this.datum_ontvangenS = datum_ontvangenS;
	}
	
	

}
