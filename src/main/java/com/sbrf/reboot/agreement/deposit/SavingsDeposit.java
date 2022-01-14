package com.sbrf.reboot.agreement.deposit;

import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
public class SavingsDeposit implements Deposit {
    private BigDecimal availableAmountOfMoney;
    private final double INTEREST_RATE = 8.0;

    @Override
    public BigDecimal getAvailableAmountOfMoney() {
        return availableAmountOfMoney;
    }

    @Override
    public double getAnnualInterestRate() {
        return INTEREST_RATE;
    }
}
