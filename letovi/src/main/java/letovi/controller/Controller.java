package letovi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import letovi.entities.Avion;
import letovi.entities.Let;
import letovi.forms.LetForm;
import letovi.forms.PlaneForm;
import letovi.repository.AvionRepository;
import letovi.repository.LetRepository;

@RestController
@RequestMapping("")
public class Controller  {

	private LetRepository rep;
	private AvionRepository avRep;
	
	@Autowired
	public Controller(LetRepository letRep,AvionRepository avRep) {
		this.rep = letRep;
		this.avRep = avRep;
	}
	@GetMapping("/flightsByPlane/{plane}")
	public ResponseEntity<List<Let>> getFlightsbyPlane(@PathVariable String plane) {
		try {

			List<Let> letovi = rep.findByAvion(plane);

			return new ResponseEntity<List<Let>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByStartDest/{dest}")
	public ResponseEntity<List<Let>> getFlightsbyStartDest(@PathVariable String dest) {
		try {

			List<Let> letovi = rep.findByStart_dest(dest);

			return new ResponseEntity<List<Let>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByEndDest/{dest}")
	public ResponseEntity<List<Let>> getFlightsbyEndDest(@PathVariable String dest) {
		try {

			List<Let> letovi = rep.findByEnd_dest(dest);

			return new ResponseEntity<List<Let>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByLen/{len}")
	public ResponseEntity<List<Let>> getFlightsbyLen(@PathVariable int len) {
		try {

			List<Let> letovi = rep.findByFlight_len(len);

			return new ResponseEntity<List<Let>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByPrice/{price}")
	public ResponseEntity<List<Let>> getFlights(@PathVariable float price) {
		try {

			List<Let> letovi = rep.findByPrice(price);

			return new ResponseEntity<List<Let>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/addPlane")
	public ResponseEntity<String> addPlane(@RequestBody PlaneForm planeForm) {

		try {
			
			Avion avion = new Avion(planeForm.getIme(), planeForm.getCapacity());
			
			avRep.saveAndFlush(avion);
			

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@RequestBody LetForm flightForm) {

		try {
			
			Let let = new Let(flightForm.getAvion(), flightForm.getStart_dest(), flightForm.getEnd_dest(), flightForm.getFlight_len(), flightForm.getPrice());
	
			
			rep.saveAndFlush(let);
			

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	@DeleteMapping("/removePlane/{id}")
	public ResponseEntity<String> removePlane(@PathVariable long id) {

		try {
			
			avRep.deleteById(id);
			
			

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	@DeleteMapping("/removeFlight/{id}")
	public ResponseEntity<String> removeFlight(@PathVariable long id) {

		try {
			
			rep.deleteById(id);
			
			

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
