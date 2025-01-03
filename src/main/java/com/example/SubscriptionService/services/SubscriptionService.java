package com.example.SubscriptionService.services;

import com.example.SubscriptionService.models.Subscription;
import com.example.SubscriptionService.models.UserDTO;
import com.example.SubscriptionService.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {


  @Autowired
  private SubscriptionRepository subscriptionRepository;


  //get all subscription
  public  List<Subscription> getSubscriptions() {
    return  subscriptionRepository.findAll();
  }

  //add subscription
  public Subscription addSusbscription(Subscription subscription) {
   return subscriptionRepository.save(subscription);
  }

  public List<Subscription> getSusbscriptionByUser(UserDTO user) {
    return subscriptionRepository.getSubscriptionByUser(user);
  }
}
