package com.transport.ticket.service;

import com.transport.ticket.model.Ticket;
import com.transport.ticket.model.TicketPurchase;
import com.transport.ticket.model.TicketStatus;
import com.transport.ticket.repository.TicketPurchaseRepository;
import com.transport.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketPurchaseService {

    @Autowired
    private TicketPurchaseRepository ticketPurchaseRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public TicketPurchase purchaseTicket(String ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            TicketPurchase purchase = new TicketPurchase();
            purchase.setTicket(ticket.get());
            purchase.setPurchaseTime(LocalDateTime.now());
            purchase.setStatus(TicketStatus.VALID);
            return ticketPurchaseRepository.save(purchase);
        }
        return null;
    }

    @Transactional
    public void cancelPurchase(String purchaseId) {
        Optional<TicketPurchase> purchase = ticketPurchaseRepository.findById(purchaseId);

        if (purchase.isEmpty()) {
            throw new RuntimeException("Purchase not found with ID: " + purchaseId);
        }

        TicketPurchase ticketPurchase = purchase.get();

        // Check if ticket can be cancelled
        if (ticketPurchase.getStatus() != TicketStatus.VALID) {
            throw new RuntimeException("Ticket cannot be cancelled - current status: " + ticketPurchase.getStatus());
        }

        ticketPurchase.setStatus(TicketStatus.CANCELLED);
        ticketPurchaseRepository.save(ticketPurchase);
    }

    public List<TicketPurchase> getPurchaseHistory(Long clientId) {
        return ticketPurchaseRepository.findByClientId(clientId);
    }
}
