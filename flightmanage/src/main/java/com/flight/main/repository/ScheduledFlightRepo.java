package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.main.model.ScheduledFlight;

public interface ScheduledFlightRepo extends JpaRepository<ScheduledFlight,Integer>{

}
