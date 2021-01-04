package letovi.controller;



import java.util.ArrayList;
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
	public ResponseEntity<List<Long>> getFlightsbyPlane(@PathVariable long plane) {
		try {

			List<Let> tmp = rep.findByAvion(plane);
			
			List<Long> letovi = new ArrayList<Long>();
			
			for (Let let : tmp) {
				letovi.add(let.getId());
			}

			return new ResponseEntity<List<Long>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByStartDest/{dest}")
	public ResponseEntity<List<Long>> getFlightsbyStartDest(@PathVariable String dest) {
		try {

			List<Let> tmp = rep.findByStartdest(dest);
			
			List<Long> letovi = new ArrayList<Long>();
			
			for (Let let : tmp) {
				letovi.add(let.getId());
			}

			return new ResponseEntity<List<Long>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByEndDest/{dest}")
	public ResponseEntity<List<Long>> getFlightsbyEndDest(@PathVariable String dest) {
		try {

			List<Let> tmp = rep.findByEnddest(dest);
			
			List<Long> letovi = new ArrayList<Long>();
			
			for (Let let : tmp) {
				letovi.add(let.getId());
			}

			return new ResponseEntity<List<Long>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByLen/{len}")
	public ResponseEntity<List<Long>> getFlightsbyLen(@PathVariable int len) {
		try {

			List<Let> tmp = rep.findByFlightlen(len);
			
			List<Long> letovi = new ArrayList<Long>();
			
			for (Let let : tmp) {
				letovi.add(let.getId());
			}

			return new ResponseEntity<List<Long>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/flightsByPrice/{price}")
	public ResponseEntity<List<Long>> getFlightsByPrice(@PathVariable float price) {
		try {

			List<Let> tmp = rep.findByPrice(price);
			
			List<Long> letovi = new ArrayList<Long>();
			
			for (Let let : tmp) {
				letovi.add(let.getId());
			}

			return new ResponseEntity<List<Long>>(letovi, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightPlane/{id}")
	public ResponseEntity<Long> getFlightPlane(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			

			return new ResponseEntity<Long>(let.getAvion(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightStartDest/{id}")
	public ResponseEntity<String> getFlightStartDest(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			

			return new ResponseEntity<String>(let.getStartdest(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightEndDest/{id}")
	public ResponseEntity<String> getFlightEndDest(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			

			return new ResponseEntity<String>(let.getEnddest(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightLen/{id}")
	public ResponseEntity<Integer> getFlightLen(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			

			return new ResponseEntity<Integer>(let.getFlightlen(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightPrice/{id}")
	public ResponseEntity<Float> getFlightPrice(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			

			return new ResponseEntity<Float>(let.getPrice(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightSeatsLeft/{id}")
	public ResponseEntity<Integer> getFlightSeatsLeft(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			

			return new ResponseEntity<Integer>(let.getSeatsLeft(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/flightCanBoard/{id}")
	public ResponseEntity<Boolean> getFlightCanBoard(@PathVariable long id) {
		try {

			Let let = rep.findById(id);
			
			Boolean can = let.bookTicket();
			
			rep.saveAndFlush(let);

			return new ResponseEntity<Boolean>(can, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/planeByName/{name}")
	public ResponseEntity<Long> getFlights(@PathVariable String name) {
		try {

			Avion a = avRep.findByIme(name);
			Long avion = a.getId();
			

			return new ResponseEntity<Long>(avion, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getPlanes")
	public ResponseEntity<List<Long>> getPlanes() {
		try {

			List<Avion> tmp = avRep.findAll();
			
			List<Long> planes = new ArrayList<Long>();
			
			for (Avion a : tmp) {
				planes.add(a.getId());
			}

			return new ResponseEntity<List<Long>>(planes, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/PlaneName/{id}")
	public ResponseEntity<String> getPlaneName(@PathVariable long id) {
		try {

			Avion a = avRep.findById(id);
			
			

			return new ResponseEntity<String>(a.getIme(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/PlaneCap/{id}")
	public ResponseEntity<Integer> getPlaneCap(@PathVariable long id) {
		try {

			Avion a = avRep.findById(id);
			
			

			return new ResponseEntity<Integer>(a.getCapacity(), HttpStatus.ACCEPTED);
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
			
			Avion a = avRep.findById(flightForm.getAvion());
			
			
			
			Let let = new Let(flightForm.getAvion(), flightForm.getStart_dest(), flightForm.getEnd_dest(), flightForm.getFlight_len(), flightForm.getPrice(),a.getCapacity());
	
			
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
