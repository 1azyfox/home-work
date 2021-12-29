package com.sbrf.reboot.repository;


import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AccountRepository {
    Set<Long> getAllAccountsByClientId(long clientId);
    Map<Long, List<Long>> getAllAccounts();
}
