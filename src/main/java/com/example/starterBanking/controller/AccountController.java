package com.example.starterBanking.controller;

import com.example.starterBanking.dto.AddMoneyRequest;
import com.example.starterBanking.dto.DeductMoneyRequest;
import com.example.starterBanking.dto.Showbalance;
import com.example.starterBanking.model.Account;
import com.example.starterBanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
// test pr
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<Account> showAll(){
        return accountService.showAll();
    }
    @PostMapping("/insert")
    public Account newAccount(@RequestBody Account newAccount){
        return accountService.saveAccount(newAccount);
    }
    @PutMapping("/add")
    public ResponseEntity<Showbalance> addMoney(@RequestBody AddMoneyRequest credit){
        return ResponseEntity.ok(accountService.addMoney(credit.getAccountNumber(),credit.getAmount()));
    }
    @PutMapping("/deduct")
    public ResponseEntity<Showbalance> deductMoney(@RequestBody DeductMoneyRequest debit){
        return ResponseEntity.ok(accountService.deductMoney(debit.getAccountNumber(),debit.getAmount()));
    }
    @GetMapping("/balance")
    public ResponseEntity<Showbalance> getBalance(@RequestBody Account account){
        return ResponseEntity.ok(accountService.getBalance(account.getAccountNumber()));

    }

}
