package com.sbrf.reboot.agreement.deposit;

import java.math.BigDecimal;

public class TermDeposit implements Deposit{
    private BigDecimal availableAmountOfMoney;
    private final double INTEREST_RATE = 5.5;

    public TermDeposit(BigDecimal availableAmountOfMoney) {
        this.availableAmountOfMoney = availableAmountOfMoney;
    }

    @Override
    public BigDecimal getAvailableAmountOfMoney() {
        return availableAmountOfMoney;
    }

    @Override
    public double getAnnualInterestRate() {
        return INTEREST_RATE;
    }
}
