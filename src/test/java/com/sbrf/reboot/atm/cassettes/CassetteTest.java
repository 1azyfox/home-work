package com.sbrf.reboot.atm.cassettes;

import com.sbrf.reboot.atm.cassettes.Banknotes.Banknote;
import com.sbrf.reboot.atm.cassettes.Banknotes.RoubleBanknotes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class CassetteTest {

    @Test
    void addOneHundredRoublesToEmptyCassette() {
        RoublesCassette<? super Banknote> cassette = new RoublesCassette<>(new ArrayList<>());

        Assertions.assertTrue(cassette.addBanknote(RoubleBanknotes.ONE_HUNDRED_RUBLES));
    }

    @Test
    void addOneHundredRoublesToCassetteForOneHundredRoubles() {
        RoublesCassette<Banknote> cassette = new RoublesCassette<>(new ArrayList<RoubleBanknotes>() {{
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
        }});

        Assertions.assertTrue(cassette.addBanknote(RoubleBanknotes.ONE_HUNDRED_RUBLES));
    }

    @Test
    void addOneHundredRoublesToCassetteForOneThousandRoubles() {
        RoublesCassette<? super Banknote> cassette = new RoublesCassette<>(new ArrayList<RoubleBanknotes>() {{
            add (RoubleBanknotes.ONE_THOUSAND_ROUBLES);
        }});

        Assertions.assertFalse(cassette.addBanknote(RoubleBanknotes.ONE_HUNDRED_RUBLES));
    }


    @Test
    void getCountBanknotesWhenAddedOneHundredRoublesOneTimes() {
        RoublesCassette<? super Banknote> cassette = new RoublesCassette<>(new ArrayList<RoubleBanknotes>() {{
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
        }});

        Assertions.assertEquals(1, cassette.getCountBanknotes());
    }

    @Test
    void getCountBanknotesWhenAddedOneHundredRoublesThreeTimes() {
        RoublesCassette<? super Banknote> cassette = new RoublesCassette<>(new ArrayList<RoubleBanknotes>() {{
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
        }});

        Assertions.assertEquals(3, cassette.getCountBanknotes());
    }

    @Test
    void getTotalAmountOfMoney() {
        RoublesCassette<? super Banknote> cassette = new RoublesCassette<>(new ArrayList<RoubleBanknotes>() {{
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
            add (RoubleBanknotes.ONE_HUNDRED_RUBLES);
        }});

        Assertions.assertEquals(300, cassette.getTotalAmountOfMoney());
    }
}