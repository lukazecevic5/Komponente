package app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Karta;
import app.forms.KartaForm;
import app.repository.KarteRepository;
import app.utils.UtilsMethods;

@RestController
@RequestMapping("")
public class Controller {

	private KarteRepository karteRepo;
	
	@Autowired
	public Controller(KarteRepository karteRepo) {
		this.karteRepo = karteRepo;
	}
	
	@PostMapping("/buyKarta")
	public ResponseEntity<String> buyKarta(@RequestBody KartaForm kartaForm) {

		try {
			ResponseEntity<Boolean> canBoard  = UtilsMethods.sendGetBool("http://localhost:8081/flightCanBoard/" + kartaForm.getLet());
			if (!canBoard.getBody()) {
				return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
			}
			ResponseEntity<String> rankRes = UtilsMethods.sendGetStr("http://localhost:8080/userRank/" + kartaForm.getUser());
			ResponseEntity<Float> priceRes = UtilsMethods.sendGetFloat("http://localhost:8081/flightPrice/" + kartaForm.getLet());
			String rank = rankRes.getBody();
			float price = priceRes.getBody();
			if (rank.equals("SILVER")) {
				price*=0.9;
			}
			else if(rank.equals("GOLD")) {
				price*=0.8;
			}
			ResponseEntity<Integer> milesRes = UtilsMethods.sendGetInt("http://localhost:8081/flightLen/" + kartaForm.getLet());
			int miles = milesRes.getBody();
			UtilsMethods.sendGetStr("http://localhost:8080/addMiles/" + kartaForm.getUser() + "/" + miles);
			UtilsMethods.sendGetStr("http://localhost:8080/updateRank/" + kartaForm.getUser());
			Karta karta = new Karta(kartaForm.getUser(), new Date(), kartaForm.getLet(),price);
			
			karteRepo.saveAndFlush(karta);
			
			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/ticketUser/{id}")
	public ResponseEntity<String> getticketUser(@PathVariable long id) {
		try {

			Karta karta = karteRepo.findById(id);
			
			

			return new ResponseEntity<String>(karta.getUser(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ticketDate/{id}")
	public ResponseEntity<Date> getTicketDate(@PathVariable long id) {
		try {

			Karta karta = karteRepo.findById(id);
			
			

			return new ResponseEntity<Date>(karta.getDate(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ticketFlight/{id}")
	public ResponseEntity<Long> getTicketFlight(@PathVariable long id) {
		try {

			Karta karta = karteRepo.findById(id);
			
			

			return new ResponseEntity<Long>(karta.getLet(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/ticketPrice/{id}")
	public ResponseEntity<Float> getTicketPrice(@PathVariable long id) {
		try {

			Karta karta = karteRepo.findById(id);
			
			

			return new ResponseEntity<Float>(karta.getPrice(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/tickets/{user}")
	public ResponseEntity<List<Long>> getFlightsbyLen(@PathVariable String user) {
		try {

			List<Karta> tmp = karteRepo.findAllByUserOrderByDateDesc(user);
			
			List<Long> karte = new ArrayList<Long>();
			
			for (Karta k : tmp) {
				karte.add(k.getId());
			}

			return new ResponseEntity<List<Long>>(karte, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
