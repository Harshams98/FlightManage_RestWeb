package com.flight.main.service;

import java.util.List;

import com.flight.main.model.Schedule;

public interface ScheduleServices {
	
	Schedule saveSchedule (Schedule schedule);

	//get all
	List<Schedule> getAllSchedule();
	
	Schedule getById (int scheduleid);
	
	Schedule updateSchedule(Schedule Sschedule,int scheduleid);
	
	void deleteSchedule(int scheduleid);

}
