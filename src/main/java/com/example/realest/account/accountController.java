package com.example.realest.account;

import com.example.realest.file.fileModel;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class accountController {
    private  accountRepository accountRepository;
    private accountService accountService;

    public accountController(accountRepository file, accountService service){
        this.accountRepository = file;
        this.accountService = service;
    }
    @PostMapping("/create/{account}/{password}")
    public  ResponseEntity<accountModel> create(@PathVariable("account") String account, @PathVariable("password") String password) throws ChangeSetPersister.NotFoundException {
        return accountService.createAccount(account,password);
    }
    @PostMapping("/createBody")
    public accountModel create(@RequestBody accountModel account) throws ChangeSetPersister.NotFoundException {
        return accountService.createAccountBody(account);
    }
    @PostMapping("/allGood")
    public accountModel labib() throws ChangeSetPersister.NotFoundException {
        return this.accountService.createFile();
    }
}

