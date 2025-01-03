package com.transport.ticket.model;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    @Id
    private String id;
    private float price;
    private String type;

}
