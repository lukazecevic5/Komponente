package app.forms;

public class RegistrationForm {

	private String ime;
	private String prezime;
	private String email;
	private String password;
	private long pasos;
	
	

	public long getPasos() {
		return pasos;
	}

	public void setPasos(long pasos) {
		this.pasos = pasos;
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
