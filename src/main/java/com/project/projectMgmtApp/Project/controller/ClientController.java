package com.project.projectMgmtApp.Project.controller;

import com.project.projectMgmtApp.Project.entity.ClientEntity;
import com.project.projectMgmtApp.Project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @GetMapping("/clients")
    public List<ClientEntity> getClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public ClientEntity getClientById(@PathVariable String id){
        return clientService.getClientById(id);
    }

    @PostMapping("/clients")
    public ClientEntity addClient(@RequestBody ClientEntity clientEntity){
        return clientService.addClient(clientEntity);
    }

    @PutMapping("/clientsUpdate")
    public ClientEntity updateClient(@RequestBody ClientEntity clientEntity){
        return clientService.addClient(clientEntity);
    }

    @DeleteMapping("/clientsDelete/{id}")
    public ClientEntity deleteClient(@PathVariable String id){
        return clientService.deleteClient(id);
    }

}
