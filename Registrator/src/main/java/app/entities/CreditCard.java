package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String ime;
	private String prezime;
	private long broj;
	private int kod;
	
	
	public CreditCard() {
		super();
	}
	
	
	public CreditCard(String ime, String prezime, long broj, int kod) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.broj = broj;
		this.kod = kod;
	}
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public long getBroj() {
		return broj;
	}
	public void setBroj(long broj) {
		this.broj = broj;
	}
	public int getKod() {
		return kod;
	}
	public void setKod(int kod) {
		this.kod = kod;
	}
	
	

}
