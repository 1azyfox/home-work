package com.sbrf.reboot.repository;

import java.util.HashSet;

public interface AccountRepository {
    static HashSet getAllAccountsByClientId(long clientId) {
        return new HashSet<>();
    }
}
