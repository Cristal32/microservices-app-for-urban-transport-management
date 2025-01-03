package com.example.SubscriptionService.controllers;

import com.example.SubscriptionService.models.Subscription;
import com.example.SubscriptionService.models.UserDTO;
import com.example.SubscriptionService.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

  @Autowired
  private SubscriptionService subscriptionService;



  // add subscription
  @PostMapping("/addSubscrition")
  public Subscription addSubsription(@RequestBody Subscription subscription){
    return subscriptionService.addSusbscription(subscription);
  }
  //get all subscriptions
  @GetMapping("/getAll")
  public List<Subscription> getSubscrition(){
    return subscriptionService.getSubscriptions();
  }
  //get Subscription by  user email
  @GetMapping("/getByUser")
  public List<Subscription> getSusbscritionByUser(@RequestBody UserDTO user){
    return subscriptionService.getSusbscriptionByUser(user);
  }


}
