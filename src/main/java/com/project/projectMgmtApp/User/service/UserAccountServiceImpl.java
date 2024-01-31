package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.exceptions.UserAccountNotFound;
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
    public UserAccount updateUserAccount(UserAccount userAccount) throws UserAccountNotFound {
        UserAccount dbUserAccount = userAccountRepository.findById(userAccount.getId()).stream().findFirst().orElse(null);
        if(dbUserAccount != null) userAccountRepository.save(userAccount);
        else throw new UserAccountNotFound("UserAccount Not present");
        return null;
    }

    @Override
    public void deleteUserAccount(String userAccountId) throws UserAccountNotFound{
        UserAccount userAccount = userAccountRepository.findById(userAccountId).stream().findFirst().orElse(null);
        if(userAccount != null) userAccountRepository.deleteById(userAccountId);
        else throw new UserAccountNotFound("UserAccount not found");
    }

}
