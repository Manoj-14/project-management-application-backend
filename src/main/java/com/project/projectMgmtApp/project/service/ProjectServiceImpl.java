package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.entity.ProjectEntity;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;
import com.project.projectMgmtApp.project.repository.ClientRepository;
import com.project.projectMgmtApp.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ClientRepository clientRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ClientRepository clientRepository){
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public ProjectEntity addProject(Map<String,String> projectEntity) {
        //System.out.println(projectEntity.getClient_id().getId());
        //ClientEntity client = clientRepository.findById(projectEntity.getClient_id().getId()).stream().findFirst().orElse(null);
        //System.out.println(client);
        if(null != null){
            return null;
        }else{
            throw new ClientNotFoundException("Client not found");
        }

    }

    @Override
    public ProjectEntity updateProject(String id) {
        return null;
    }

    @Override
    public List<ProjectEntity> getProject() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity deleteProject() {
        return null;
    }
}
