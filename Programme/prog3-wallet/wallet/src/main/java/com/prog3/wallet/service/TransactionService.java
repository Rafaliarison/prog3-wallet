package com.prog3.wallet.service;

import com.prog3.wallet.model.Transaction;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Service
public class TransactionService {

    private Transaction transaction;
    public Transaction creditTransaction(String label, float amount, String type){

    }

}
