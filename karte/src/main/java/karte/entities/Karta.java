package karte.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Karta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	private long id;
	private Date date;
	
	
	
	public Karta(String email, long id,Date date) {
		super();
		this.email = email;
		this.id = id;
		this.date = date;
	}

	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
