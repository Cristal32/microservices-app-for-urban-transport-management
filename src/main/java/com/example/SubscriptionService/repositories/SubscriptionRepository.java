package com.example.SubscriptionService.repositories;

import com.example.SubscriptionService.models.Subscription;
import com.example.SubscriptionService.models.UserDTO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription,String> {
 List<Subscription> getSubscriptionByUser(UserDTO user);
}
