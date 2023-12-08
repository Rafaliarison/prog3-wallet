package com.prog3.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Devise {
    @Id
    private int deviseId;
    private String deviseName;
    private String deviseCode;
}
