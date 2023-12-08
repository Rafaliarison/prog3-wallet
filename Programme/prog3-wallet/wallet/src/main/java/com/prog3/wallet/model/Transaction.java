package com.prog3.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    private int transactionId;
    private String transactionLabel;
    private ZonedDateTime transactionDate;
    private String transacionType;
}
