package com.flight.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.main.model.Schedule;
import com.flight.main.repository.ScheduleRepo;
import com.flight.main.service.ScheduleServices;

@Service
public class ScheduleServicesImpl implements ScheduleServices {

	@Autowired
	private ScheduleRepo scheduleRepo;

	public ScheduleServicesImpl(ScheduleRepo scheduleRepo) {
		super();
		this.scheduleRepo = scheduleRepo;
	}

	public ScheduleServicesImpl() {
		super();
	}

	@Override
	public Schedule saveSchedule(Schedule schedule) {

		return scheduleRepo.save(schedule);
	}

	@Override
	public List<Schedule> getAllSchedule() {
		return scheduleRepo.findAll();
	}

	@Override
	public Schedule getById(int scheduleid) {
		Optional<Schedule> aircode = scheduleRepo.findById(scheduleid);

		return scheduleRepo.findById(scheduleid).orElseThrow(() -> // USING LAMBDA
		new com.flight.main.exception.ResourceNotFoundException("scheduleid", "scheduleidid", aircode));
	}
	

	@Override
	public Schedule updateSchedule(Schedule Sschedule, int scheduleid) {

		Schedule sid = scheduleRepo.findById(scheduleid).orElseThrow(() ->

		new com.flight.main.exception.ResourceNotFoundException("Airport", "code", scheduleid));
		sid.setArrivalTime(Sschedule.getArrivalTime());
		
		sid.setDepartureTime(Sschedule.getDepartureTime());

		// saving existion employee in db
		scheduleRepo.save(sid);

		return sid;
	}

	@Override
	public void deleteSchedule(int scheduleid) {
		// TODO Auto-generated method stub
		scheduleRepo.findById(scheduleid).orElseThrow( ()->
		new com.flight.main.exception.ResourceNotFoundException("schedule","id",scheduleid));
		scheduleRepo.deleteById(scheduleid);
	}

}
