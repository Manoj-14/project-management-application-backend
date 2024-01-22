package com.project.projectMgmtApp.project.controller;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ClientEntity getClientById(@PathVariable String id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientEntity addClient(@RequestBody ClientEntity clientEntity){
        return clientService.addClient(clientEntity);
    }

    @PutMapping
    public ClientEntity updateClient(@RequestBody ClientEntity clientEntity){
        return clientService.addClient(clientEntity);
    }

    @DeleteMapping("/{id}")
    public ClientEntity deleteClient(@PathVariable String id){
        return clientService.deleteClient(id);
    }

}
