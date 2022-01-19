package com.sbrf.reboot.agreement.credit;

import com.sbrf.reboot.agreement.contract.Contract;
import com.sbrf.reboot.agreement.credit.Credit;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CreditContract<T extends Credit> implements Contract {
    Credit credit;

    @Override
    public BigDecimal getAvailableAmountOfMoney() {
        return credit.getAvailableAmountOfMoney();
    }
}
