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
	private String start_dest;
	private String end_dest;
	private int flight_len;
	private float price;
	
	public Let() {
	
	}

	public Let(String avion, String start_dest, String end_dest, int flight_len, float price) {
		super();
		this.avion = avion;
		this.start_dest = start_dest;
		this.end_dest = end_dest;
		this.flight_len = flight_len;
		this.price = price;
	}

	
	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public String getStart_dest() {
		return start_dest;
	}

	public void setStart_dest(String start_dest) {
		this.start_dest = start_dest;
	}

	public String getEnd_dest() {
		return end_dest;
	}

	public void setEnd_dest(String end_dest) {
		this.end_dest = end_dest;
	}

	public int getFlight_len() {
		return flight_len;
	}

	public void setFlight_len(int flight_len) {
		this.flight_len = flight_len;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
