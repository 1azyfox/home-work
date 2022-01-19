package com.sbrf.reboot.agreement.contract;

import com.sbrf.reboot.agreement.Agreement;

import java.math.BigDecimal;

public interface Contract extends Agreement {
    BigDecimal getAvailableAmountOfMoney();
}
