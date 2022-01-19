package com.sbrf.reboot.agreement.credit;

import com.sbrf.reboot.agreement.contract.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;


class CreditContractTest {

    @Test
    void getAvailableAmountOfMoney() {
        Calendar monthlyPaymentDate = new GregorianCalendar(2022, Calendar.JANUARY, 25);
        BigDecimal monthlyPaymentAmount = BigDecimal.valueOf(10_000);
        BigDecimal availableAmountOfMoney = BigDecimal.valueOf(100_000);
        double annualInterestRate = 9.0;

        Contract creditContract = new CreditContract<ConsumerCredit>(new ConsumerCredit(monthlyPaymentDate,
                monthlyPaymentAmount,
                availableAmountOfMoney,
                annualInterestRate));

        Assertions.assertEquals(BigDecimal.valueOf(100_000),creditContract.getAvailableAmountOfMoney());
    }
}
