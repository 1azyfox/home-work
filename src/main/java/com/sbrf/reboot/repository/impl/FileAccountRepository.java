package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.exceptions.FileAccountRepositoryException;
import com.sbrf.reboot.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FileAccountRepository implements AccountRepository {
    private final String FILE_PATH;

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)));
                Scanner scanner = new Scanner(reader)
        ) {
            while ((scanner.hasNextLine())) {
                if (scanner.nextLine().contains("\"clientId\": " + clientId)) {
                    return Arrays.stream(scanner.nextLine().split(":")[1].split("\n"))
                            .map(String::trim)
                            .map(Long::valueOf)
                            .collect(Collectors.toSet());
                }
            }
            return new HashSet<>();
        } catch (IOException e) {
            throw new FileAccountRepositoryException(e);
        }
    }

    @Override
    public boolean updateContractNumberByClientId(long clientId, long oldContractNumber, long newContractNumber) {
        try (RandomAccessFile originFile = new RandomAccessFile(FILE_PATH, "rwd")) {
            String requiredClientIdDefinitionLine = "\"clientId\": ";
            String searchingLine;
            long originFilePointer;
            do {

                if ((searchingLine = originFile.readLine()) == null) {
                    return false;
                }
            } while (!searchingLine.contains(requiredClientIdDefinitionLine + clientId));
            originFilePointer = originFile.getFilePointer();

            String readLine = originFile.readLine();
            if (readLine.contains(String.valueOf(oldContractNumber))) {
                originFile.seek(originFilePointer);
                originFile.writeBytes(readLine.replace(String.valueOf(oldContractNumber), String.valueOf(newContractNumber)));
                return true;
            }
            return false;
        } catch (IOException e) {
            throw new FileAccountRepositoryException(e);
        }
    }

    @Override
    public Map<Long, List<Long>> getAllAccounts() {
        throw new FileAccountRepositoryException("Not Implemented Yet");
    }
}
