package app.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import app.entities.Service;

public class HttpManager {

	public static final String GETEWAY_URL = "http://localhost:8762";
	public static final String ROUTES_URL = GETEWAY_URL + "/actuator/routes";
	public static List<Service> services = new ArrayList<>();
	
	
	
	
	public static void main(String[] args) {
		getServices();
		for (Service s : services) {
			System.out.println(s);
		}
	}
	
	
	public static void getServices() {
		services.clear();
		ResponseEntity<String> resp = UtilsMethods.sendGetStr(ROUTES_URL);

		String[] str = resp.getBody().substring(1, resp.getBody().length() - 1).split(",");

		for (String s : str) {
			Service service = new Service(s.split(":")[1].substring(1, s.split(":")[1].length() - 1),
					s.split(":")[0].substring(1, s.split(":")[0].length() - 3));
			services.add(service);
		}
	}


	public static String getSelectedPath(String name) {
		HttpManager.getServices();
		for (Service service : services) {
			if(service.getName().equals(name))
				return GETEWAY_URL + service.getPath();
		}
		return null;
	}
	
	
	
	
}
