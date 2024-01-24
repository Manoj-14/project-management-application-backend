package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.UserAccount;

import java.util.List;

public interface UserAccountService {

    public void createUserAccount(UserAccount userAccount);

    public List<UserAccount> getAllUsers();

    public UserAccount getUserAccountById(String userAccountId);

    public void updateUserAccount(UserAccount userAccount);

    public void deleteUserAccount(String userAccountId);
}
