package com.practice.account.dto;

import java.math.BigDecimal;

public record BalanceResponse(Long accountNo,
                              BigDecimal balance,
                              String currency) {

}
