package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.main.model.Schedule;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer>{

}
