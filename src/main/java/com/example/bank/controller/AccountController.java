package com.example.bank.controller;

import com.example.bank.dto.StatementDTO;
import com.example.bank.dto.TransactionDTO;
import com.example.bank.dto.TransferDTO;
import com.example.bank.model.AccountModel;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/open-acc")
    public void openAccount(@RequestBody AccountModel a){
        accountService.openAccount(a);
    }

    @PutMapping("/withdrew")
    public void withdrewAmount(@RequestBody TransactionDTO dto){
        accountService.withdrewAmount(dto);
    }

    @PutMapping("/deposite")
    public void depositeAmount(@RequestBody TransactionDTO dto){
        accountService.depositeAmount(dto);
    }

    @PutMapping("/tranfer")
    public void depositeAmount(@RequestBody TransferDTO dto){
        accountService.transferAmount(dto);
    }

    @GetMapping("getState/{acNo}")
    public List<StatementDTO> getStatement(@PathVariable Long acNo){
        return accountService.getStatement(acNo);
    }

    @GetMapping("showBalance/{acNo}")
    public AccountModel showDetails(@PathVariable Long acNo){
        return accountService.showDetails(acNo);
    }
}
