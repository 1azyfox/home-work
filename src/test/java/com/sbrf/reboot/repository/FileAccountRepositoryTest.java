package com.sbrf.reboot.repository;

import com.sbrf.reboot.exceptions.FileAccountRepositoryException;
import com.sbrf.reboot.repository.impl.FileAccountRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileAccountRepositoryTest {

    AccountRepository accountRepository;

    @Test
    void onlyPersonalAccounts() throws IOException {
        String filePath = "src/main/resources/Accounts.txt";
        accountRepository = new FileAccountRepository(filePath);

        long clientId = 1L;
        Set<Long> actualAccounts = accountRepository.getAllAccountsByClientId(clientId);

        Set<Long> expected = new HashSet<Long>() {{
            add(111L);
            add(222L);
            add(333L);
        }};

        actualAccounts.forEach(e -> assertTrue(expected.contains(e)));
    }

    @Test
    void failGetAllAccountsByClientId() {
        long clientId = 1L;

        String filePath = "somePath";

        accountRepository = new FileAccountRepository(filePath);

        assertThrows(FileAccountRepositoryException.class, () -> accountRepository.getAllAccountsByClientId(clientId));
    }

    @Test
    void updateContractNumber() {
        long clientId = 2L;
        long oldContractNumber = 777L;
        long newContractNumber = 666L;

        String filePath = "src/main/resources/Accounts.txt";

        accountRepository = new FileAccountRepository(filePath);
        accountRepository.updateContractNumberByClientId(clientId, oldContractNumber, newContractNumber);

        assertTrue(accountRepository.getAllAccountsByClientId(2L).contains(666L));

        accountRepository.updateContractNumberByClientId(clientId, newContractNumber, oldContractNumber);
    }


}