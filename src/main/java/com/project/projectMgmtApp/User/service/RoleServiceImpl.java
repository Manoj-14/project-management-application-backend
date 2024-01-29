package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public void updateRole(Role role) {
        try{
            Optional<Role> existingRoleOptional = roleRepository.findById(role.getId());

            if(existingRoleOptional.isPresent()){
                Role existingRole = existingRoleOptional.get();
                existingRole.setRoleName(role.getRoleName());

                roleRepository.save(existingRole);
            }
            else {
                throw new IllegalArgumentException("Role not found with Id: "+ role.getId());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(String roleId) {
        try{
            int id = Integer.parseInt(roleId);
            Optional<Role> existingRoleOptional = roleRepository.findById(String.valueOf(id));

            if(existingRoleOptional.isPresent()){
                roleRepository.deleteById(String.valueOf(id));
            }
            else {
                throw new IllegalArgumentException("Role not Found Id :"+id);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
