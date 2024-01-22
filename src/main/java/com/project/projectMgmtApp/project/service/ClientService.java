package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    public ClientEntity addClient(ClientEntity client);

    public ClientEntity getClientById(String id);

    public List<ClientEntity> getAllClients();

    public ClientEntity deleteClient(String id);
}
