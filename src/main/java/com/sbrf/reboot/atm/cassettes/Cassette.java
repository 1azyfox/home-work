package com.sbrf.reboot.atm.cassettes;


import com.sbrf.reboot.atm.cassettes.banknote.Banknote;

public interface Cassette<T extends Banknote> {
    int getCountBanknotes();
    boolean addBanknote(Banknote banknote);
    int getTotalAmountOfMoney();
}
