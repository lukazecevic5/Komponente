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
	private int milje;
	private Rank rank;
	private List<CreditCard> cards;
	

	public User() {

	}
	

	public User(String ime, String prezime, String email, String password, long pasos) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.password = password;
		this.pasos = pasos;
		milje = 0;
		this.rank = Rank.BRONZE;
		this.cards = new ArrayList<CreditCard>(3);
	}

	
	public int getMilje() {
		return milje;
	}


	public void setMilje(int milje) {
		this.milje = milje;
	}


	public void addPoints(int points) {
		milje+=points;
	}
	
	public void changeRank() {
		if (milje>10000)
			rank = Rank.GOLD;
		else if (milje>1000)
			rank = Rank.SILVER;
	}

	public long getPasos() {
		return pasos;
	}



	public void setPasos(long pasos) {
		this.pasos = pasos;
	}



	public long getRankNum() {
		return milje;
	}



	public void setRankNum(int rankNum) {
		this.milje = rankNum;
	}



	public Rank getRank() {
		return rank;
	}



	public void setRank(Rank rank) {
		this.rank = rank;
	}



	public void addCard(CreditCard card) throws Exception{
		cards.add(card);
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
