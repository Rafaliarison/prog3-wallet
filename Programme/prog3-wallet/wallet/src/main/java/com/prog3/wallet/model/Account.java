package com.prog3.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    private int idAccount;
    private String accountName;
    private float solde;
    private ZonedDateTime accountUpdateDate;
    private String accountType;
}
