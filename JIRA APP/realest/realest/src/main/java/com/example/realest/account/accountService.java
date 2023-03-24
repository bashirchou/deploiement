package com.example.realest.account;

import com.example.realest.file.fileModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class accountService {
    private final accountRepository accountRepository;

    public ResponseEntity getFileById(Long file_id) throws ChangeSetPersister.NotFoundException {

        if (accountRepository.existsById(file_id)) {
            var file = accountRepository.findById(file_id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            return new ResponseEntity(file, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity createAccount(String accountName, String password) throws ChangeSetPersister.NotFoundException {
        accountModel account = new accountModel();
        account.setUsername(accountName);
        account.setPassword(password);
        var response = accountRepository.saveAndFlush(account);

        if (response != null)
            return new ResponseEntity(response, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public accountModel createAccountBody(accountModel account){
        accountRepository.saveAndFlush(account);
        return account;
    }
    public accountModel createFile() throws ChangeSetPersister.NotFoundException {
       accountModel fileModel = new accountModel();
        fileModel.setCreationDate("HAHAHAHAHA");
        accountRepository.saveAndFlush(fileModel);
        return fileModel;
    }
}
