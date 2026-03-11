package com.example.bank.service;

import com.example.bank.dto.StatementDTO;
import com.example.bank.dto.TransactionDTO;
import com.example.bank.dto.TransferDTO;
import com.example.bank.enums.TransactionType;
import com.example.bank.model.AccountModel;
import com.example.bank.model.StatementModel;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StatementRepository statementRepository;

    @Autowired
    StatementService service;



    public void openAccount(AccountModel a) {
        LocalDate date = LocalDate.now();
        a.setDate(date);
        accountRepository.save(a);
    }

    public void withdrewAmount(TransactionDTO dto) {

        AccountModel account = accountRepository.findById(dto.getAcNo()).orElse(null);

        if(account.getBalance() < dto.getAmount()){
            System.out.println("Not Sufficient Balance");
            return;
        }

        account.setBalance(account.getBalance() - dto.getAmount());
        accountRepository.save(account);

        StatementModel statementModel = new StatementModel();
        statementModel.setType(TransactionType.Withdraw.toString());
        statementModel.setAmount(dto.getAmount());
        statementModel.setDate(LocalDate.now());
        statementModel.setAcNo(dto.getAcNo());

        service.saveStatement(statementModel);



    }

    public void depositeAmount(TransactionDTO dto) {
        AccountModel account = accountRepository.findById(dto.getAcNo()).orElseThrow();
        account.setBalance(account.getBalance() + dto.getAmount());
        accountRepository.save(account);

        StatementModel statementModel = new StatementModel();
        statementModel.setType(TransactionType.Deposit.toString());
        statementModel.setAmount(dto.getAmount());
        statementModel.setDate(LocalDate.now());
        statementModel.setAcNo(dto.getAcNo());

        service.saveStatement(statementModel);


    }

    public void transferAmount(TransferDTO dto) {

        AccountModel sender = accountRepository.findById(dto.getSenderAc()).orElseThrow();
        if(sender.getBalance() < dto.getAmount()){
            System.out.println("Unsuficcient balance");
            return;
        }

        AccountModel reciver = accountRepository.findById(dto.getReciverAc()).orElseThrow();

        sender.setBalance(sender.getBalance() - dto.getAmount());
        reciver.setBalance(reciver.getBalance() + dto.getAmount());
        accountRepository.save(sender);
        accountRepository.save(reciver);

        StatementModel senderStatement = new StatementModel();
        senderStatement.setType(TransactionType.Withdraw.toString());
        senderStatement.setAmount(dto.getAmount());
        senderStatement.setDate(LocalDate.now());
        senderStatement.setAcNo(dto.getSenderAc());
        service.saveStatement(senderStatement);

        StatementModel reciverStatement = new StatementModel();
        reciverStatement.setType(TransactionType.Deposit.toString());
        reciverStatement.setAmount(dto.getAmount());
        reciverStatement.setDate(LocalDate.now());
        reciverStatement.setAcNo(dto.getReciverAc());
        service.saveStatement(reciverStatement);
    }

    public List<StatementDTO> getStatement(Long acNo) {

        return service.getStatement(acNo);
    }

    public AccountModel showDetails(Long acNo) {
        return accountRepository.findById(acNo).orElse(null);
    }
}
