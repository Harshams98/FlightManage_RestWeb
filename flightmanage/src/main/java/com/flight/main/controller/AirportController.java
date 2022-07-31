package com.flight.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.main.model.Airport;
import com.flight.main.service.AirportService;




@RestController
@RequestMapping("/api/airport")
public class AirportController {

	@Autowired
	private AirportService airportService;

	public AirportController(AirportService airportService) {
		super();
		this.airportService = airportService;
	}
	
	public AirportController() {
		super();
	}

	@PostMapping()
	public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
		return new ResponseEntity<Airport>(airportService.saveAirport(airport), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Airport> getAllEmployees(){
		return airportService.getAllAirport();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Airport> getEmployeeById(@PathVariable ("id")String airportcode){
	return new ResponseEntity<Airport>(airportService.getById(airportcode),
			HttpStatus.OK);//status -- 200
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Airport> updateEmployee(@PathVariable ("id")String aircode,
			@RequestBody Airport airport){
	return new ResponseEntity<Airport>(airportService.updateAirport(airport,aircode),
			HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id") String aircode){
		//delete employee db
		airportService.deleteEmployee(aircode);
		return new ResponseEntity<String>("Employee record deleted successfully!",HttpStatus.OK);
	}
	
}
