package com.example.ScheduleService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BusDTO {
  private String numBus;
  private  int capacity;
}
