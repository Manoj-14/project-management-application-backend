package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/useraccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserAccount(@RequestBody UserAccount userAccount){
        try{
            userAccountService.createUserAccount(userAccount);
            return ResponseEntity.status(HttpStatus.CREATED).body("UserAccount Created.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating UserAccount.");
        }
    }
}
