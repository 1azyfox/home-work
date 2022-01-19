package com.sbrf.reboot.agreement.deposit;

import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
public class DepositContract<T extends Deposit> implements Deposit {
    Deposit deposit;

    @Override
    public BigDecimal getAvailableAmountOfMoney() {
        return deposit.getAvailableAmountOfMoney();
    }

    @Override
    public double getAnnualInterestRate() {
        return deposit.getAnnualInterestRate();
    }
}
