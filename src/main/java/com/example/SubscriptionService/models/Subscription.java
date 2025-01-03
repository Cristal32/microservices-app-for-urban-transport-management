package com.example.SubscriptionService.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subscriptions")
public class Subscription {

  @Id
  private String id;

  private UserDTO user;
  private SubscriptionType type;
  private Date startDate;
  private Date endDate;
  private boolean active;


}
