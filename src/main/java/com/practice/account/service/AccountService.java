package com.practice.account.service;

import com.practice.account.dto.AccountResponse;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class AccountService {
    private final Map<Long, AccountResponse> accounts = Map.of(
        1001L, new AccountResponse(1001L, "Alex Morgan", new BigDecimal("1250.00"), "USD"),
        1002L, new AccountResponse(1002L, "Taylor Reed", new BigDecimal("840.50"), "USD")
    );

    public AccountResponse findById(Long accountId) {
        AccountResponse account = accounts.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }
        return account;
    }
}
