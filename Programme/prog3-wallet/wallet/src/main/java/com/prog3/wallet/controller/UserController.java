package com.prog3.wallet.controller;

import com.prog3.wallet.repository.UserCrudOperationsRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserCrudOperationsRepository repositoryPostgres;
}
