package com.practice.account.dto;

import java.math.BigDecimal;

public record AccountResponse(Long accountId, String ownerName, BigDecimal balance, String currency) {}
