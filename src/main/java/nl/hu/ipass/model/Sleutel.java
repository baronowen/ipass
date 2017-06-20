package nl.hu.ipass.model;

public class Sleutel {
	private int sleutelid;
	private int sleutelcode;
	
	public Sleutel(int sleutelid, int sleutelcode) {
		super();
		this.sleutelid = sleutelid;
		this.sleutelcode = sleutelcode;
	}
	
	public Sleutel(int sleutelcode) {
		this.sleutelcode = sleutelcode;
	}
	


	@Override
	public String toString() {
		return "Sleutel [sleutelid=" + sleutelid + ", sleutelcode=" + sleutelcode + "]";
	}

	public int getSleutelid() {
		return sleutelid;
	}

	public void setSleutelid(int sleutelid) {
		this.sleutelid = sleutelid;
	}

	public int getSleutelcode() {
		return sleutelcode;
	}

	public void setSleutelcode(int sleutelcode) {
		this.sleutelcode = sleutelcode;
	}
	
	
	
}
