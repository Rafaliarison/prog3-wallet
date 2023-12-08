package Controller;

import Model.Account;
import Operations.AccountCrudOperations;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    private final AccountCrudOperations accountOperation;

    @Autowired
    public AccountController(AccountOperation accountOperation) {
        this.accountOperation = accountOperation;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return accountOperation.findAll();
    }

    @PostMapping("/saveAllAccounts")
    public List<Account> saveAllAccount(@RequestBody List<Account> accounts){
        return  accountOperation.saveAll(accounts);
    }

    @PostMapping("/account")
    public Account newAccount(@RequestBody Account account){
        return accountOperation.save(account);
    }

    @PutMapping("/account")
    public Account updateAccount(@RequestBody Account account){
        return accountOperation.update(account);
    }

    @GetMapping("/account/{id}")
    public Account getOneAccount(@PathVariable("id") int id){
        return accountOperation.getOne(id);
    }
}
