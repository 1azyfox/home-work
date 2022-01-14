package com.sbrf.reboot.agreement.deposit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DepositContractTest {
    @Test
    void getAnnualInterestRate() {
        BigDecimal availableAmountOfMoney = BigDecimal.valueOf(1_000_000);
        DepositContract<? super Deposit> depositContract = new DepositContract<>(new SavingsDeposit(availableAmountOfMoney));

        Assertions.assertEquals(8.0,depositContract.getAnnualInterestRate());
    }
}
