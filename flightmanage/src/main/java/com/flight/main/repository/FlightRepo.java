package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.main.model.Flight;

public interface FlightRepo extends JpaRepository<Flight,Integer>{

}
