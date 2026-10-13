package com.practice.account.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private final AccountService service = new AccountService();

    @Test
    void returnsExistingAccount() {
        assertEquals(1001L, service.findById(1001L).accountId());
    }

    @Test
    void rejectsUnknownAccount() {
        assertThrows(AccountNotFoundException.class, () -> service.findById(9999L));
    }
}
