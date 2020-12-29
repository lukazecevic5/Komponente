package karte.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import karte.entities.Karta;
import karte.forms.KartaForm;
import karte.repository.KarteRepository;

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
			
			Karta karta = new Karta(kartaForm.getEmail(), kartaForm.getId(), new Date());
			
			karteRepo.saveAndFlush(karta);
			
			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
}
