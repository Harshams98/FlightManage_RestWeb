package com.flight.main.service;

import java.util.List;


import com.flight.main.model.ScheduledFlight;

public interface ScheduledFlightServices {

	ScheduledFlight saveScheduledFlight (ScheduledFlight schedule);

	//get all
	List<ScheduledFlight> getAllScheduledFlight();
	
	ScheduledFlight getById (int scheduledflightid);
	
	ScheduledFlight updateScheduledflight(ScheduledFlight Sscheduledflight,int scheduleid);
	
	void deleteScheduledflight(int scheduleid);
	
	
}
