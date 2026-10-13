package com.practice.account.controller;

import com.practice.account.dto.AccountResponse;
import com.practice.account.dto.BalanceResponse;
import com.practice.account.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNo}")
    public AccountResponse getAccount(@PathVariable Long accountNo) {
        return accountService.findById(accountNo);
    }

    @GetMapping("/{accountNo}/balance")
    public BalanceResponse getAccountBalance(
            @PathVariable Long accountNo) {

        return accountService.getBalance(accountNo);
    }

}
