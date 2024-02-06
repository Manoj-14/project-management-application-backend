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
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> createRole(@Valid @RequestBody Role role){


          Role roles =  roleService.createRole(role);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(roles.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<?> getRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@Valid @PathVariable String id){

            Role role = roleService.getRoleById(id);
            return new ResponseEntity<>(role,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@Valid @RequestBody Role role, @PathVariable String id){
        if(id==null){
            throw new NullPointerException("Role id is null.");
        } else {
            role.setId(id);
        }

            Role savedRole = roleService.updateRole(role);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(role.getId()).toUri();
            return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable String id){

            roleService.deleteRole(id);
            return ResponseEntity.accepted().build();

    }
}
