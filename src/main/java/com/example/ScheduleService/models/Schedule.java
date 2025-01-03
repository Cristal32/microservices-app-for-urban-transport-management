package com.example.ScheduleService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "schedules")
public class Schedule {
  @Id
  private String id;
  private Date departureTime;
  private Date arrivalTime;
  private Itinerary itinerary;
  private BusDTO bus;

}
