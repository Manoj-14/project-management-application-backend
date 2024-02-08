package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.model.UserAccount;

import java.util.List;

public interface RoleService {
    public Role createRole(Role role);
    public List<Role> getAllRoles();

    public Role getRoleById(String roleId);

    public Role updateRole(Role role);

    public void deleteRole(String roleId);
}
