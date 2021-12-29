package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @Test
    void contractExist() {
        Set<Long> accounts = new HashSet<>();
        accounts.add(111L);

        long clientId = 1L;
        long contractNumber = 111L;


        when(accountRepository.getAllAccountsByClientId(clientId)).thenReturn(accounts);

        assertTrue(accountService.isClientHasContract(clientId, contractNumber));
    }

    @Test
    void contractNotExist() {
        Set<Long> accounts = new HashSet<>();
        accounts.add(222L);

        long clientId = 1L;
        long contractNumber = 111L;

        when(accountRepository.getAllAccountsByClientId(clientId)).thenReturn(accounts);

        assertFalse(accountService.isClientHasContract(clientId, contractNumber));
    }

    @Test
    void foundClientsIdByContractNumber() {
        Map<Long, List<Long>> allAccounts = new HashMap<>();

        ArrayList<Long> firstAccountContracts = new ArrayList<>();
        firstAccountContracts.add(111L);
        firstAccountContracts.add(11L);
        allAccounts.put(1L,firstAccountContracts);

        ArrayList<Long> secondAccountContracts = new ArrayList<>();
        secondAccountContracts.add(111L);
        secondAccountContracts.add(22L);
        allAccounts.put(2L,secondAccountContracts);

        ArrayList<Long> thirdAccountContracts = new ArrayList<>();
        thirdAccountContracts.add(333L);
        thirdAccountContracts.add(33L);
        allAccounts.put(3L,thirdAccountContracts);

        when(accountRepository.getAllAccounts()).thenReturn(allAccounts);

        List<Long> requiredClientsIds = new ArrayList<>();
        requiredClientsIds.add(1L);
        requiredClientsIds.add(2L);

        assertEquals(requiredClientsIds, accountService.getClientsIdByContractNumber(111L));
    }

    @Test
    void notFoundClientsIdByContractNumber() {
        Map<Long, List<Long>> allAccounts = new HashMap<>();

        ArrayList<Long> firstAccountContracts = new ArrayList<>();
        firstAccountContracts.add(111L);
        firstAccountContracts.add(11L);
        allAccounts.put(1L,firstAccountContracts);

        ArrayList<Long> secondAccountContracts = new ArrayList<>();
        firstAccountContracts.add(111L);
        firstAccountContracts.add(22L);
        allAccounts.put(2L,secondAccountContracts);

        ArrayList<Long> thirdAccountContracts = new ArrayList<>();
        firstAccountContracts.add(333L);
        firstAccountContracts.add(33L);
        allAccounts.put(3L,thirdAccountContracts);

        when(accountRepository.getAllAccounts()).thenReturn(allAccounts);

        assertTrue(accountService.getClientsIdByContractNumber(444L).isEmpty());
    }

    @Test
    void repositoryHasTreeMethods() {
        assertEquals(2, AccountRepository.class.getMethods().length);
    }

    @Test
    void serviceHasTreeMethods() {
        assertEquals(2, AccountService.class.getMethods().length - Object.class.getMethods().length);
    }

}