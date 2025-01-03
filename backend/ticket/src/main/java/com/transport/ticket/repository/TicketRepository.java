package com.transport.ticket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.transport.ticket.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

}
