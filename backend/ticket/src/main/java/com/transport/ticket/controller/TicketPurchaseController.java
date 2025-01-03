package com.transport.ticket.controller;

import com.transport.ticket.model.TicketPurchase;
import com.transport.ticket.service.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/purchases")
public class TicketPurchaseController {

    @Autowired
    private TicketPurchaseService ticketPurchaseService;

    @PostMapping("/buy/{ticketId}")
    public TicketPurchase purchaseTicket(@PathVariable String ticketId) {
        return ticketPurchaseService.purchaseTicket(ticketId);
    }

    @PostMapping("/cancel/{purchaseId}")
    public void cancelPurchase(@PathVariable String purchaseId) {
        ticketPurchaseService.cancelPurchase(purchaseId);
    }

    @GetMapping("/history/{clientId}")
    public ResponseEntity<List<TicketPurchase>> getPurchaseHistory(
            @PathVariable long clientId) {
        List<TicketPurchase> history = ticketPurchaseService.getPurchaseHistory(clientId);
        return ResponseEntity.ok(history);
    }
}
