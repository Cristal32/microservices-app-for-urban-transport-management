package com.example.ScheduleService.controllers;

import com.example.ScheduleService.models.Itinerary;
import com.example.ScheduleService.models.Schedule;
import com.example.ScheduleService.services.ItineraryService;
import com.example.ScheduleService.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Itinerary")
public class ItineraryController {
  private ItineraryService itineraryService;
  @Autowired
  public ItineraryController(ItineraryService itineraryService) {
    this.itineraryService = itineraryService;
  }



  //get schedules by id
  @GetMapping("/getItinerary/{id}")
  public Itinerary getItineraryById(@PathVariable String id){
    return itineraryService.getItineraryById(id);
  }
//get all itineraries
  @GetMapping("/getAll")
  public List<Itinerary> getItineraries(){
    return itineraryService.getItineraries();
  }
  //add Itinerary
  @PostMapping("/addItinerary")
  public Itinerary addItinerary(@RequestBody  Itinerary itinerary){
    return  itineraryService.addItinerary(itinerary);
  }
  //update Itinerary

  @PutMapping("/updateItinerary")
  public Itinerary updateItinerary(@RequestParam String id,@RequestParam String departPt,@RequestParam String arrivalPt){
  return itineraryService.updateItinerary(id,departPt,arrivalPt);
  }
}
