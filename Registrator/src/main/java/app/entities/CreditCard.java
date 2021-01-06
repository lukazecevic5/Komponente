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
	private long broj;
	private int kod;
	private long user;
	
	
	public CreditCard() {
		super();
	}
	
	
	public CreditCard(String ime, long broj, int kod,long user) {
		super();
		this.ime = ime;
		this.broj = broj;
		this.kod = kod;
		this.user = user;
	}
	
	
	public long getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return id + " Kartica | broj: " + broj+ " | kod: +" + kod;
	}


	public void setUser(long user) {
		this.user = user;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getId() {
		return id;
	}
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
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
