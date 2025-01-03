package com.example.ScheduleService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "itineraries")
public class Itinerary {
  @Id
  private String id;
  private String departurePt;
 private  String arrivalPt;

}
