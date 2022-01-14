package com.sbrf.reboot.atm.cassettes.Banknotes;

public enum RoubleBanknotes implements Banknote {
    FIVE_ROUBLES(5),
    TEN_ROUBLES(10),
    FIFTY_RUBLES(50),
    ONE_HUNDRED_RUBLES(100),
    TWO_HUNDRED_RUBLES(200),
    FIVE_HUNDRED_ROUBLES(500),
    ONE_THOUSAND_ROUBLES(1000),
    TWO_THOUSAND_ROUBLES(2000),
    FIVE_THOUSAND_ROUBLES(5000);

    final int value;

    RoubleBanknotes(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
