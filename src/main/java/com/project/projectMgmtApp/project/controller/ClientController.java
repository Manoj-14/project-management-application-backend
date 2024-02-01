package com.project.projectMgmtApp.project.controller;

import ch.qos.logback.core.net.server.Client;
import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;
import com.project.projectMgmtApp.project.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<?> getClients(){

            List<ClientEntity> clients = clientService.getAllClients();

            return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable String id) throws Exception{

            ClientEntity client = clientService.getClientById(id);
            return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addClient(@Valid ClientEntity clientEntity){
            ClientEntity client= clientService.addClient(clientEntity);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
            return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<?> updateClient(@RequestBody ClientEntity clientEntity) throws Exception {
        ClientEntity client = clientService.updateClient(clientEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id) throws Exception{
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
