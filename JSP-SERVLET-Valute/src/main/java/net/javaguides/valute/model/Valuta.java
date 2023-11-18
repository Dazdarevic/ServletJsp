package net.javaguides.valute.model;

public class Valuta {

	private int id;
	private String naziv;
	private String drzava;
	private String vrednost;
	
	
	public Valuta(int id, String naziv, String drzava, String vrednost) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.vrednost = vrednost;
	}
	
	
	
	public Valuta(String naziv, String drzava, String vrednost) {
		super();
		this.naziv = naziv;
		this.drzava = drzava;
		this.vrednost = vrednost;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getVrednost() {
		return vrednost;
	}
	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	
	
}
