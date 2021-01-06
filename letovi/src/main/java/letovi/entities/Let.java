package letovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Let {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long avion;
	private String startdest;
	private String enddest;
	private int flightlen;
	private float price;
	private int seatsLeft;
	
	public Let() {
	
	}

	public Let(long avion, String start_dest, String end_dest, int flight_len, float price,int seatsLeft) {
		super();
		this.avion = avion;
		this.startdest = start_dest;
		this.enddest = end_dest;
		this.flightlen = flight_len;
		this.price = price;
		this.seatsLeft = seatsLeft;
	}
	
	public boolean bookTicket() {
		if(seatsLeft-1>=0) {
			seatsLeft--;
			return true;
		}
		return false;
	}

	
	public int getSeatsLeft() {
		return seatsLeft;
	}

	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}

	public long getAvion() {
		return avion;
	}

	public void setAvion(long avion) {
		this.avion = avion;
	}

	public String getStartdest() {
		return startdest;
	}

	public void setStartdest(String start_dest) {
		this.startdest = start_dest;
	}

	public String getEnddest() {
		return enddest;
	}

	public void setEnddest(String end_dest) {
		this.enddest = end_dest;
	}

	public int getFlightlen() {
		return flightlen;
	}

	public void setFlightlen(int flight_len) {
		this.flightlen = flight_len;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return id + " Let | Avionom " + avion + " | " + startdest + " -> " + enddest + " | duzine: " + flightlen + " | cene: " + price + " | ostala sedista: " + seatsLeft ;
	}
	
}
