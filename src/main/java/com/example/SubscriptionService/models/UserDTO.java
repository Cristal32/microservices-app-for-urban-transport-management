package com.example.SubscriptionService.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
  private String id;
  private String name;
  private String email;
  private Date datejoined;


}
