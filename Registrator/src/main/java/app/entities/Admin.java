package app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String password;
	
	
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}




	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	

}
