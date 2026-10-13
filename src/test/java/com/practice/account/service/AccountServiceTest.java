package com.practice.account.service;

import com.practice.account.dto.BalanceResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private final AccountService service = new AccountService();

    @Test
    void returnsExistingAccount() {
        assertEquals(1001L, service.findById(1001L).accountNo());
    }

    @Test
    void rejectsUnknownAccount() {
        assertThrows(AccountNotFoundException.class, () -> service.findById(9999L));
    }

    @Test
    void shouldReturnBalanceForExistingAccount() {
        // Arrange: Create the service containing our sample accounts.
        AccountService service = new AccountService();

        // Act: Request the balance of account 1001.
        BalanceResponse response = service.getBalance(1001L);

        // Assert: Verify the account ID.
        assertEquals(1001L, response.accountNo());

        // Assert: Compare monetary values precisely.
        assertEquals(0, new BigDecimal("1250.00")
                .compareTo(response.balance()));

        // Assert: Verify the currency.
        assertEquals("USD", response.currency());
    }

    @Test
    void shouldThrowExceptionForUnknownAccount() {
        // Arrange: Create the service.
        AccountService service = new AccountService();

        // Act and assert: An unknown account should be rejected.
        assertThrows(
                AccountNotFoundException.class,
                () -> service.getBalance(9999L)
        );
    }

}
