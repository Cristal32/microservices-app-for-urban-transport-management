package com.example.ScheduleService.repositories;

import com.example.ScheduleService.models.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String> {
  Schedule getScheduleById(String id);
}
