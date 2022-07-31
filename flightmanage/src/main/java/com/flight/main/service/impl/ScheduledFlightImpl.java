package com.flight.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.main.model.ScheduledFlight;
import com.flight.main.repository.ScheduledFlightRepo;
import com.flight.main.service.ScheduledFlightServices;

@Service
public class ScheduledFlightImpl implements ScheduledFlightServices{

	
	@Autowired
	private ScheduledFlightRepo scheduledFlightRepo;
	
	
	
	public ScheduledFlightImpl(ScheduledFlightRepo scheduledFlightRepo) {
		super();
		this.scheduledFlightRepo = scheduledFlightRepo;
	}
	

	public ScheduledFlightImpl() {
		super();
	}


	@Override
	public ScheduledFlight saveScheduledFlight(ScheduledFlight schedule) {
		// TODO Auto-generated method stub
		return scheduledFlightRepo.save(schedule);
	}

	@Override
	public List<ScheduledFlight> getAllScheduledFlight() {
		// TODO Auto-generated method stub
		return scheduledFlightRepo.findAll();
	}

	@Override
	public ScheduledFlight getById(int scheduledflightid) {
		Optional<ScheduledFlight> scheduleflightid = scheduledFlightRepo.findById(scheduledflightid);

		return scheduledFlightRepo.findById(scheduledflightid).orElseThrow(() -> // USING LAMBDA
		new com.flight.main.exception.ResourceNotFoundException("scheduleid", "scheduleidid", scheduleflightid));
	}

	@Override
	public ScheduledFlight updateScheduledflight(ScheduledFlight Sscheduledflight, int scheduleid) {
		ScheduledFlight sfid = scheduledFlightRepo.findById(scheduleid).orElseThrow(() ->

		new com.flight.main.exception.ResourceNotFoundException("scheduled flight", "id", scheduleid));
		sfid.setAvailableseats(Sscheduledflight.getAvailableseats());
		sfid.setSchedule(Sscheduledflight.getSchedule());

		// saving existion employee in db
		scheduledFlightRepo.save(sfid);

		return sfid;
	}

	@Override
	public void deleteScheduledflight(int scheduleid) {
		scheduledFlightRepo.findById(scheduleid).orElseThrow( ()->
		new com.flight.main.exception.ResourceNotFoundException("schedule","id",scheduleid));
		scheduledFlightRepo.deleteById(scheduleid);	
	}

}
