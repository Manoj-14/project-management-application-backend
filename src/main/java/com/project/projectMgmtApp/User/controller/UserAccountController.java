package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating UserAccount.");
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
        } catch (Exception e) {
            return new ResponseEntity<>("UserId not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUserAccount(@Valid @PathVariable String id){
        try{
            UserAccount existingUserAccount = userAccountService.getUserAccountById(id);
            if(existingUserAccount == null) {
                return new ResponseEntity<>("User Not Found with id: "+id, HttpStatus.NOT_FOUND);
            }
            userAccountService.updateUserAccount(existingUserAccount);
            return new ResponseEntity<>("User Updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserAccount(@PathVariable String id){
        try{
            userAccountService.deleteUserAccount(id);
            return new ResponseEntity<>("UserAccount deleted with id: "+id,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server error", HttpStatus.NOT_FOUND);
        }
    }

}
