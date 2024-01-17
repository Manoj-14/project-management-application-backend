package com.project.projectMgmtApp.Project.service;

import com.project.projectMgmtApp.Project.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    public ClientEntity addClient(ClientEntity client);

    public ClientEntity getClientById(String id);

    public List<ClientEntity> getAllClients();

    public ClientEntity deleteClient(String id);
}
