package letovi.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	private String ime;
	private int capacity;
	
	public Avion() {
		
	}
	
	
	public Avion(String ime, int capacity) {
		super();
		this.ime = ime;
		this.capacity = capacity;
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


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public void loadPassenger(int passenger) {
		this.capacity-= passenger;
	}
	public void cancelPassenget(int passenger) {
		this.capacity+= passenger;
	}
	
	@Override
	public String toString() {
		
		return id + "Avion | ime : " + ime + " | kapacitet : " + capacity;
	}
}
