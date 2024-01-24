package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public void createUserAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount getUserAccountById(String userAccountId) {
        Optional<UserAccount> optionalUserAccount = userAccountRepository.findById(String.valueOf(Integer.parseInt(userAccountId)));
        return optionalUserAccount.orElse(null);
    }

    @Override
    public void updateUserAccount(UserAccount userAccount) {
        try{
            Optional<UserAccount> existingUserAccountOptional = userAccountRepository.findById(userAccount.getId());

            if(existingUserAccountOptional.isPresent()){
                UserAccount existingUserAccount = existingUserAccountOptional.get();
                existingUserAccount.setUsername(userAccount.getUsername());
                existingUserAccount.setFirstName(userAccount.getFirstName());
                existingUserAccount.setLastName(userAccount.getLastName());
                existingUserAccount.setEmail(userAccount.getEmail());
                existingUserAccount.setPassword(userAccount.getPassword());
                existingUserAccount.setProjectManager(userAccount.isProjectManager());
                existingUserAccount.setRegistrationTime(userAccount.getRegistrationTime());

                userAccountRepository.save(existingUserAccount);
            }
            else {
                throw new IllegalArgumentException("UserAccount not found with ID :" + userAccount.getId());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserAccount(String userAccountId) {
        try{
            int id = Integer.parseInt(userAccountId);
            Optional<UserAccount> existingUserAccountOptional = userAccountRepository.findById(String.valueOf(id));

            if(existingUserAccountOptional.isPresent()){
                userAccountRepository.deleteById(String.valueOf(id));
            } else {
                throw new IllegalArgumentException("UserAccount not found with ID: " + id);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
