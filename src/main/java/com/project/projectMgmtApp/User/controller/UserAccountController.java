package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.exceptions.UserAccountNotFound;
import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/useraccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/create")
    public ResponseEntity<?> createUserAccount(@RequestBody UserAccount userAccount){
        try{
            userAccountService.createUserAccount(userAccount);
            return ResponseEntity.status(HttpStatus.CREATED).body("UserAccount Created.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userAccountService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<?> getUserById(@Valid @PathVariable String id){
        try{
            UserAccount userAccount = userAccountService.getUserAccountById(id);
            return new ResponseEntity<>(userAccount,HttpStatus.OK);
        } catch (UserAccountNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserAccount(@Valid @RequestBody UserAccount userAccount,@PathVariable String id){
        if(id==null){
            throw new NullPointerException("UserAccount id is null.");
        } else {
            userAccount.setId(id);
        }
        try {
            UserAccount savedUserAccount = userAccountService.updateUserAccount(userAccount);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userAccount.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (UserAccountNotFound ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserAccount(@PathVariable String id){
        try{
            userAccountService.deleteUserAccount(id);
            return ResponseEntity.accepted().build();
        } catch (UserAccountNotFound e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
