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
import org.springframework.web.bind.annotation.RestController;


import com.flight.main.model.ScheduledFlight;
import com.flight.main.service.ScheduledFlightServices;


@RestController
@RequestMapping("/api/scheduledflight")
public class ScheduleFlightController {
	
	
	
	@Autowired
	ScheduledFlightServices ScheduleFlightServices;

	public ScheduleFlightController(ScheduledFlightServices scheduleFlightServices) {
		super();
		ScheduleFlightServices = scheduleFlightServices;
	}

	public ScheduleFlightController() {
		super();
	}

	@PostMapping()
	public ResponseEntity<ScheduledFlight> saveAirport(@RequestBody ScheduledFlight schedule){
		return new ResponseEntity<ScheduledFlight>(ScheduleFlightServices.saveScheduledFlight(schedule), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<ScheduledFlight> getAllScheduledFlight(){
		return ScheduleFlightServices.getAllScheduledFlight();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ScheduledFlight> getById(@PathVariable ("id")int scheduleid){
	return new ResponseEntity<ScheduledFlight>(ScheduleFlightServices.getById(scheduleid),
			HttpStatus.OK);//status -- 200
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<ScheduledFlight> updateScheduledflight(@PathVariable ("id")int sfid,
			@RequestBody ScheduledFlight schedule){
	return new ResponseEntity<ScheduledFlight>(ScheduleFlightServices.updateScheduledflight(schedule,sfid),
			HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> ScheduleFlightServices(@PathVariable ("id") int sfid){
		//delete employee db
		ScheduleFlightServices.deleteScheduledflight(sfid);
		return new ResponseEntity<String>("Employee record deleted successfully!",HttpStatus.OK);
	}
	
}
