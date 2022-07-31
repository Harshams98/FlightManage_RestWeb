package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.main.model.Booking;

public interface BookingRepo extends JpaRepository<Booking,Integer>{

}
