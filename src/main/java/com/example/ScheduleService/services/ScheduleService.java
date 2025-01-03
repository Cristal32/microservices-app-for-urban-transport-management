package com.example.ScheduleService.services;

import com.example.ScheduleService.models.Itinerary;
import com.example.ScheduleService.models.Schedule;
import com.example.ScheduleService.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
  private ScheduleRepository scheduleRepository;
  @Autowired
  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
  }
  //get schedule by Id
  public Schedule getSdheduleById(String id) {
    return scheduleRepository.getScheduleById(id);
  }
//add schedule
  public Schedule addSchedule(Schedule schedule) {
    return scheduleRepository.save(schedule);
  }
//get all schedules
  public List<Schedule> getSchedules() {
    return scheduleRepository.findAll();
  }
//update schedule
  public Schedule updateSchedule(String id, Date departTime, Date arrivalTime) {
   Schedule schedule=scheduleRepository.getScheduleById(id);

   schedule.setArrivalTime(arrivalTime);
   schedule.setDepartureTime(departTime);
   return scheduleRepository.save(schedule);
  }
//add schedule

}
