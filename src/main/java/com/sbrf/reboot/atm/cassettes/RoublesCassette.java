package com.sbrf.reboot.atm.cassettes;

import com.sbrf.reboot.atm.cassettes.banknote.Banknote;
import com.sbrf.reboot.atm.cassettes.banknote.RoubleBanknotes;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class RoublesCassette<T extends Banknote> implements Cassette {
    private final List<RoubleBanknotes> banknoteCollection;

    public int getCountBanknotes() {
        return banknoteCollection.size();
    }

    @Override
    public boolean addBanknote(Banknote banknote) {
        for (RoubleBanknotes roubleBanknotes : RoubleBanknotes.values()) {
            if (banknoteCollection.size() == 0) {
                if (banknote.equals(roubleBanknotes)) {
                    banknoteCollection.add((RoubleBanknotes) banknote);
                    return true;
                }
            } else {
                if (banknoteCollection.get(0).equals(roubleBanknotes) && banknote.equals(roubleBanknotes)) {
                    banknoteCollection.add((RoubleBanknotes) banknote);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public int getTotalAmountOfMoney() {
        Banknote banknote = banknoteCollection.get(0);
        return banknoteCollection.size() * banknote.getValue();
    }
}
