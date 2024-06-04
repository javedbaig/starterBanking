package com.example.starterBanking.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Account")
@Data
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String accountNumber;
    private String accountName;
    private double balance;

}
