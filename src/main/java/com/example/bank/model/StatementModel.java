package com.example.bank.model;

import com.example.bank.enums.TransactionType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "statement")
public class StatementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statement_id")
    private int sId;

    @Column(name = "ac_no")
    private Long acNo;

    private String type;

    private int amount;

    private LocalDate date;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public Long getAcNo() {
        return acNo;
    }

    public void setAcNo(Long acNo) {
        this.acNo = acNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
