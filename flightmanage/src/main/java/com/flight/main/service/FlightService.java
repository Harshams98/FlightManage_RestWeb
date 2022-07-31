package com.flight.main.service;

import java.util.List;


import com.flight.main.model.Flight;

public interface FlightService {

	
	Flight saveFlight (Flight flight);
	
	List<Flight> getAllFlights();
	
	Flight getById (int flightnum);
	
	Flight updateFlight(Flight flight,int flightnum);
	
	void deleteFlight(int flightnum);
	
}
