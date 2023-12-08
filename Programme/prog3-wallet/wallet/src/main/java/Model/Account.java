package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private String name;
    private AccountType type;
    private Devise devise;
    private Balance balance;
    private List<Transaction> transactions;
}
