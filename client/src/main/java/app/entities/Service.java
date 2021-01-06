package app.entities;

public class Service {
	
	String name;
	String path;

	public Service(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "\n\nname=" + name + ", path=" + path + "\n\n";
	}


}
