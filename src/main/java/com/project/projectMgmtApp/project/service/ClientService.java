package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;

import java.util.List;

public interface ClientService {
    public ClientEntity addClient(ClientEntity client);

    public ClientEntity getClientById(String id) throws ClientNotFoundException;

    public List<ClientEntity> getAllClients();

    public ClientEntity updateClient(ClientEntity client);

    public void deleteClient(String id);
}
