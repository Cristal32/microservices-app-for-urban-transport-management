package com.example.ScheduleService.repositories;

import com.example.ScheduleService.models.Itinerary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends MongoRepository<Itinerary,String> {
  Itinerary getItineraryById(String id);
}
