package com.project.projectMgmtApp.project.service;


import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;
import com.project.projectMgmtApp.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl( ClientRepository clientRepository1){
        clientRepository=clientRepository1;
    }

    @Override
    public ClientEntity addClient(ClientEntity clientEntity) {
            return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity getClientById(String id) {
        ClientEntity client = clientRepository.findById(id).stream().findFirst().orElse(null);
        if(client != null){
            return  client;
        }else{
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity updateClient(ClientEntity client) {
        ClientEntity clientEntity = clientRepository.findById(client.getId()).stream().findFirst().orElse(null);

        if(clientEntity != null){
            return  clientRepository.save(client);
        }else{
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public void deleteClient(String id) {
        ClientEntity clientEntity = clientRepository.findById(id).stream().findFirst().orElse(null);
        if(clientEntity != null){
            clientRepository.deleteById(id);
        }else{
            throw new ClientNotFoundException("Client not found");
        }

    }

}
