package nl.hu.ipass.model;

import java.sql.Date;
import java.sql.Time;

public class Historie {
	private int historieid;
	private Date datum;
	private Time aankomst_tijd;
	private Time vertrek_tijd;
	private int persoonsid;
	
	private Persoon persoon;
	
	public Historie(int historieid, Date datum, Time aankomst_tijd, Time vertrek_tijd) {
		super();
		this.datum = datum;
		this.historieid = historieid;
		this.aankomst_tijd = aankomst_tijd;
		this.vertrek_tijd = vertrek_tijd;
	}

	public Historie(int historieid, Date datum, Time aankomst_tijd, Time vertrek_tijd, int persoonsid) {
		super();
		this.datum = datum;
		this.historieid = historieid;
		this.aankomst_tijd = aankomst_tijd;
		this.vertrek_tijd = vertrek_tijd;
		
		this.persoonsid = persoonsid;
	}

	public Historie(int historieid, Date datum, Time aankomst_tijd, Time vertrek_tijd, Persoon persoon) {
		super();
		this.datum = datum;
		this.historieid = historieid;
		this.aankomst_tijd = aankomst_tijd;
		this.vertrek_tijd = vertrek_tijd;
		
		this.persoon = persoon;
	}

	@Override
	public String toString() {
		return "Historie [datum=" + datum + ", historieid=" + historieid + ", aankomst_tijd=" + aankomst_tijd
				+ ", vertrek_tijd=" + vertrek_tijd + "]";
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getHistorieid() {
		return historieid;
	}

	public void setHistorieid(int historieid) {
		this.historieid = historieid;
	}

	public Time getAankomst_tijd() {
		return aankomst_tijd;
	}

	public void setAankomst_tijd(Time aankomst_tijd) {
		this.aankomst_tijd = aankomst_tijd;
	}

	public Time getVertrek_tijd() {
		return vertrek_tijd;
	}

	public void setVertrek_tijd(Time vertrek_tijd) {
		this.vertrek_tijd = vertrek_tijd;
	}

	public int getPersoonsid() {
		return persoonsid;
	}

	public void setPersoonsid(int persoonsid) {
		this.persoonsid = persoonsid;
	}

	public Persoon getPersoon() {
		return persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}
}
