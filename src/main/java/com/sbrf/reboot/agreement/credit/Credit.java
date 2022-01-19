package com.sbrf.reboot.agreement.credit;

import com.sbrf.reboot.agreement.contract.Contract;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public interface Credit extends Contract {
    Calendar getMonthlyPaymentDate();
    BigDecimal getMonthlyPaymentAmount();
    double getAnnualInterestRate();
}
