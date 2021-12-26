package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;

public class AccountService {
    public boolean isClientHasContract(long clientId, long contractNumber) {
        return AccountRepository.getAllAccountsByClientId(clientId).contains(contractNumber);
    }
}
