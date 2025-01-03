package com.transport.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime; // Use LocalDateTime for date and time handling

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ticketPurchases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketPurchase {
    private String id; // Unique identifier for the purchase
    private LocalDateTime purchaseTime; // Timestamp of the purchase
    private long ClientId;

    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.VALID;

    @ManyToOne
    private Ticket ticket;

}
