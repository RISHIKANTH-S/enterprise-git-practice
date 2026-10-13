package com.practice.account.dto;

import java.math.BigDecimal;

public record AccountResponse(Long accountNo, String ownerName, BigDecimal balance, String currency) {}
