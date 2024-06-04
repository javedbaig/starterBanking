package com.example.starterBanking.service;

import com.example.starterBanking.dto.AddMoneyRequest;
import com.example.starterBanking.dto.DeductMoneyRequest;
import com.example.starterBanking.dto.Showbalance;
import com.example.starterBanking.model.Account;
import com.example.starterBanking.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account newAccount){
         return accountRepository.save(newAccount);
    }

    public List<Account> showAll(){
        return accountRepository.findAll();
    }
    public Showbalance addMoney(String accountNumber, double amount){
        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance()+amount);
            accountRepository.save(account);
            return new Showbalance(account.getAccountNumber(), account.getAccountName(), account.getBalance());

        }
        else{
            throw  new RuntimeException("Account not found");
        }
    }

    public Showbalance deductMoney(String accountNumber, double amount){
        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance()-amount);
            accountRepository.save(account);
            return new Showbalance(account.getAccountNumber(),account.getAccountName(),account.getBalance());
        }
        else{
            throw new RuntimeException("Account not found");
        }

    }
    public Showbalance getBalance(String accountNumber){
    Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
    if(optionalAccount.isPresent()){
        Account account = optionalAccount.get();
        return new Showbalance(account.getAccountNumber(),account.getAccountName(),account.getBalance());

    }
    else {
        throw new RuntimeException("Account not found");
    }

    }
}
