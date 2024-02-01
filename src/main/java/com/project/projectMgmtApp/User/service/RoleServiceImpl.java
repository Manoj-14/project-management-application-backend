package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.exceptions.EmployeeNotFound;
import com.project.projectMgmtApp.User.exceptions.RoleNotFound;
import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(String roleId) {
        Optional<Role> optionalRole = roleRepository.findById(String.valueOf(Integer.parseInt(roleId)));
        return optionalRole.orElse(null);
    }

    @Override
    public Role updateRole(Role role) throws RoleNotFound {
        Role dbRole = roleRepository.findById(role.getId()).stream().findFirst().orElse(null);
        if(dbRole != null) roleRepository.save(role);
        else throw new RoleNotFound("Role not found");
        return null;
    }

    @Override
    public void deleteRole(String roleId) throws RoleNotFound{
        Role role = roleRepository.findById(roleId).stream().findFirst().orElse(null);
        if(role != null) roleRepository.deleteById(roleId);
        else throw new RoleNotFound("Role not found");
    }
}
