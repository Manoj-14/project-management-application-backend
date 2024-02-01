package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.exceptions.RoleNotFound;
import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRole(@Valid @RequestBody Role role, @PathVariable String id){
        if(id==null){
            throw new NullPointerException("Role id is null.");
        } else {
            role.setId(id);
        }
        try {
            Role savedRole = roleService.updateRole(role);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(role.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (RoleNotFound ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable String id){
        try {
            roleService.deleteRole(id);
            return ResponseEntity.accepted().build();
        } catch (RoleNotFound e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
