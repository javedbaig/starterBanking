package com.example.starterBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Showbalance {
    private String accountNumber;
    private String accountName;
    private double balance;
}
