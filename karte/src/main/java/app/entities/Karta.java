package app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Karta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long user;
	private Date date;
	private long let;
	private float price;
	
	public Karta() {
	}
	
	public Karta(long user,Date date,long let,float price) {
		super();
		this.user = user;
		this.date = date;
		this.let = let;
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return id  + " Karta | " + "Let: " + let + " | cena: " + price;
	}
	
	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public long getLet() {
		return let;
	}


	public void setLet(long let) {
		this.let = let;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	
	public long getUser() {
		return user;
	}


	public void setUser(long user) {
		this.user = user;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
