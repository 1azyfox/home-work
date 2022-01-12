package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
public class AccountService {

    @NonNull
    private final AccountRepository accountRepository;

    public boolean isClientHasContract(long clientId, long contractNumber) {
        return accountRepository.getAllAccountsByClientId(clientId).contains(contractNumber);
    }

    public List<Long> getClientsIdByContractNumber(long contractNumber) {
        Map<Long, List<Long>> allAccounts = accountRepository.getAllAccounts();
        List<Long> clientsIds = new ArrayList<>();
        for (Map.Entry<Long, List<Long>> entry : allAccounts.entrySet()) {
            for (Long value : entry.getValue()) {
                if (value == contractNumber) {
                    clientsIds.add(entry.getKey());
                }
            }
        }
        return clientsIds;
    }
}
