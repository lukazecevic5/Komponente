package app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String ime;
	private String prezime;
	private String email;
	private String password;
	private long pasos;
	private long rankNum;
	private Rank rank;
	private boolean admin;
	private List<CreditCard> cards;
	

	public User() {

	}
	
	

	

	public User(String ime, String prezime, String email, String password) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.password = password;
	}





	public User(String ime, String prezime, String email, String password, long pasos, long rankNum, Rank rank,
			boolean admin) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.password = password;
		this.pasos = pasos;
		this.rankNum = rankNum;
		this.rank = rank;
		this.admin = admin;
		this.cards = new ArrayList<CreditCard>(3);
	}

	


	public long getPasos() {
		return pasos;
	}



	public void setPasos(long pasos) {
		this.pasos = pasos;
	}



	public long getRankNum() {
		return rankNum;
	}



	public void setRankNum(long rankNum) {
		this.rankNum = rankNum;
	}



	public Rank getRank() {
		return rank;
	}



	public void setRank(Rank rank) {
		this.rank = rank;
	}



	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	public List<CreditCard> getCards() {
		return cards;
	}



	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
