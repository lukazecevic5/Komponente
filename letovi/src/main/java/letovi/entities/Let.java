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

	private String avion;
	private String startdest;
	private String enddest;
	private int flightlen;
	private float price;
	
	public Let() {
	
	}

	public Let(String avion, String start_dest, String end_dest, int flight_len, float price) {
		super();
		this.avion = avion;
		this.startdest = start_dest;
		this.enddest = end_dest;
		this.flightlen = flight_len;
		this.price = price;
	}

	
	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
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
	
}
