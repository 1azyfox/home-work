package com.sbrf.reboot.atm.cassettes;


import com.sbrf.reboot.atm.cassettes.Banknotes.Banknote;

public interface Cassette<T extends Banknote> {
    int getCountBanknotes();
    boolean addBanknote(Banknote banknote);
    int getTotalAmountOfMoney();
}
