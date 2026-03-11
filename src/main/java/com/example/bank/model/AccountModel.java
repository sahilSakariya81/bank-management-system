package com.example.bank.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "account")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ac_no")
    private Long acNo;
    private String name;
    private int balance;
    private LocalDate date;


    public Long getAcNo() {
        return acNo;
    }

    public void setAcNo(Long acNo) {
        this.acNo = acNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
