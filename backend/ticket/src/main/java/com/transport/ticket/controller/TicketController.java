package com.transport.ticket.controller;

import com.transport.ticket.model.Ticket;
import com.transport.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String id) {
        Optional<Ticket> existingTicket = ticketRepository.findById(id);
        if (existingTicket.isPresent()) {
            ticketRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String id, @RequestBody Ticket updatedTicket) {
        return ticketRepository.findById(id)
                .map(existingTicket -> {
                    // Update fields of the existing ticket with values from the updated ticket
                    existingTicket.setPrice(updatedTicket.getPrice());
                    existingTicket.setType(updatedTicket.getType());
                    // Add more fields as necessary

                    Ticket savedTicket = ticketRepository.save(existingTicket);
                    return ResponseEntity.ok(savedTicket); // Return the updated ticket
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 Not Found if the ticket doesn't exist
    }
}
