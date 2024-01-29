package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody Role role){
        try{
            roleService.createRole(role);
            return ResponseEntity.status(HttpStatus.CREATED).body("Role created successfully.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Role");
        }
    }

    @GetMapping("/get-all-roles")
    public ResponseEntity<?> getRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(),HttpStatus.OK);
    }

    @GetMapping("/get-role/{id}")
    public ResponseEntity<?> getRoleById(@Valid @PathVariable String id){
        try {
            Role role = roleService.getRoleById(id);
            return new ResponseEntity<>(role,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Role Id not found.",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateRole(@Valid @PathVariable String id){
        try {
            Role existingRole = roleService.getRoleById(id);
            if(existingRole==null)
                return new ResponseEntity<>("Role Not found with id: "+id,HttpStatus.NOT_FOUND);
            roleService.updateRole(existingRole);
            return new ResponseEntity<>("Role Updated Successfully.",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Internal Server Error.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable String id){
        try {
            roleService.deleteRole(id);
            return new ResponseEntity<>("Role deleted with id:"+id,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server error",HttpStatus.NOT_FOUND);
        }
    }
}
