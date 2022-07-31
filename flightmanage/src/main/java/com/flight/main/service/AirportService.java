package com.flight.main.service;

import java.util.List;

import com.flight.main.model.Airport;


public interface AirportService {
	
	Airport saveAirport (Airport airport);
	
	List<Airport> getAllAirport();
	
	Airport getById (String airportcode);
	
	Airport updateAirport(Airport airport,String airportcode);
	
	void deleteEmployee(String airportcode);

}
