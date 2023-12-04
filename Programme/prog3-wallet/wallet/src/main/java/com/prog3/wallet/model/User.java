package com.prog3.wallet.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    int userId;
    String user_name;
    String typeCompte;
    String devise;
    float montantDepart;
}
