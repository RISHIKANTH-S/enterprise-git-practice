package com.practice.account.service;

import com.practice.account.dto.AccountResponse;
import com.practice.account.dto.BalanceResponse;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class AccountService {
    private final Map<Long, AccountResponse> accounts = Map.of(
        1001L, new AccountResponse(1001L, "Alex Morgan", new BigDecimal("1250.00"), "USD"),
        1002L, new AccountResponse(1002L, "Taylor Reed", new BigDecimal("840.50"), "USD")
    );

    public AccountResponse findById(Long accountNo) {
        AccountResponse account = accounts.get(accountNo);
        if (account == null) {
            throw new AccountNotFoundException(accountNo);
        }
        return account;
    }

    public BalanceResponse getBalance(Long accountNo) {

        // Reuse existing account lookup and 404 handling.
        AccountResponse account = findById(accountNo);

        // Return only the fields required by the balance API.
        return new BalanceResponse(
                account.accountNo(),
                account.balance(),
                account.currency()
        );
    }

}
