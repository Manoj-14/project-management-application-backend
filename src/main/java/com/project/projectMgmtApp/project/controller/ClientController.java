package com.project.projectMgmtApp.project.controller;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;
import com.project.projectMgmtApp.project.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @GetMapping
    public List<ClientEntity> getClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable String id){

        try{
            ClientEntity client = clientService.getClientById(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }catch (ClientNotFoundException ex){
            throw new ClientNotFoundException("Client id not found - "+id);
        }
    }

    @PostMapping
    public ResponseEntity<?> addClient(@Valid @RequestBody ClientEntity clientEntity){
        try{
            ClientEntity client= clientService.addClient(clientEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public ResponseEntity<?> updateClient(@RequestBody ClientEntity clientEntity){


        try{
            ClientEntity client = clientService.updateClient(clientEntity);
            return new ResponseEntity<>(client,HttpStatus.OK);
        }
        catch (Exception ex){
            throw new ClientNotFoundException("Client Id Not Found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id){

        try{
            clientService.deleteClient(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            throw new ClientNotFoundException("Client Id Not Found");
        }
    }

}
