package com.example.ScheduleService.controllers;

import com.example.ScheduleService.models.Schedule;
import com.example.ScheduleService.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
  private ScheduleService scheduleService;
  @Autowired
  public ScheduleController(ScheduleService scheduleService) {
    this.scheduleService = scheduleService;
  }
  //get schedules by id
  @GetMapping("/getSchedule/{id}")
  public Schedule getScheduleById(@PathVariable String id){
    return scheduleService.getSdheduleById(id);
  }
  //get schedules
  @GetMapping("/allSchedules")
  public  List<Schedule> getSchedules(){
    return scheduleService.getSchedules(); }
  //add schedule
  @PostMapping("/addSchedule")
  public Schedule addSchedule(@RequestBody Schedule schedule){
    return scheduleService.addSchedule(schedule);
  }
  //update schedule
  @PutMapping("/updateSchedule")
  public Schedule updateSchedule(@RequestParam String id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date departTime, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date arrivalTime)
  {
    return scheduleService.updateSchedule(id,departTime,arrivalTime);
  }
}
