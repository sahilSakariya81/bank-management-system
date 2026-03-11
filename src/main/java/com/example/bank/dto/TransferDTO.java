package com.example.bank.dto;

public class TransferDTO {

    private Long senderAc;
    private Long reciverAc;
    private int amount;

    public Long getSenderAc() {
        return senderAc;
    }

    public void setSenderAc(Long senderAc) {
        this.senderAc = senderAc;
    }

    public Long getReciverAc() {
        return reciverAc;
    }

    public void setReciverAc(Long reciverAc) {
        this.reciverAc = reciverAc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
