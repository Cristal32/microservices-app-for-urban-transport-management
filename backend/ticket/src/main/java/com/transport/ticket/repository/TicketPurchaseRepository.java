package com.transport.ticket.repository;

import com.transport.ticket.model.TicketPurchase;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketPurchaseRepository extends MongoRepository<TicketPurchase, String> {
    List<TicketPurchase> findByClientId(Long clientId);
}
