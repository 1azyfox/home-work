package com.sbrf.reboot.agreement.credit;

import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.Calendar;


@AllArgsConstructor
public class CommercialCredit implements Credit{
    private Calendar monthlyPaymentDate;
    private BigDecimal monthlyPaymentAmount;
    private BigDecimal availableAmountOfMoney;
    private double annualInterestRate;

    @Override
    public BigDecimal getAvailableAmountOfMoney() {
        return availableAmountOfMoney;
    }

    @Override
    public Calendar getMonthlyPaymentDate() {
        return monthlyPaymentDate;
    }

    @Override
    public BigDecimal getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    @Override
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
}
