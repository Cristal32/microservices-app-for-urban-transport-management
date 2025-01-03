package com.example.ScheduleService.services;

import com.example.ScheduleService.models.Itinerary;
import com.example.ScheduleService.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {
  private ItineraryRepository itineraryRepository;
   @Autowired
  public ItineraryService(ItineraryRepository itineraryRepository) {
    this.itineraryRepository = itineraryRepository;
  }
//get itinerary by id
  public Itinerary getItineraryById(String id) {
     return itineraryRepository.getItineraryById(id);
  }
// add Itinerary
  public Itinerary addItinerary(Itinerary itinerary) {
     return itineraryRepository.save(itinerary);
  }
// get all Itineraries
  public List<Itinerary> getItineraries() {
     return itineraryRepository.findAll();
  }
  //update Itinerary

  public Itinerary updateItinerary(String id,String departPt, String arrivalPt) {
    Itinerary itinerary = itineraryRepository.getItineraryById(id);

    itinerary.setArrivalPt(arrivalPt);
    itinerary.setDeparturePt(departPt);
    return itineraryRepository.save(itinerary);
  }

}
