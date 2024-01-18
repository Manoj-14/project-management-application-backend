package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository1){
        clientRepository=clientRepository1;
    }

    @Override
    public ClientEntity addClient(ClientEntity clientEntity) {
       return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity getClientById(String id) {
        Optional<ClientEntity> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity deleteClient(String id) {
        Optional<ClientEntity> client = clientRepository.findById(id);
        clientRepository.deleteById(id);
        return client.get();
    }

}
