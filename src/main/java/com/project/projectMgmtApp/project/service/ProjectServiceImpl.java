package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.entity.ProjectEntity;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;
import com.project.projectMgmtApp.project.exceptions.FieldNotFoundException;
import com.project.projectMgmtApp.project.exceptions.ProjectNotFoundException;
import com.project.projectMgmtApp.project.repository.ClientRepository;
import com.project.projectMgmtApp.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public ProjectEntity addProject(Map<String,String> responseBody){
        for (Map.Entry<String,String> entry : responseBody.entrySet()){
            if(entry.getValue() == null || entry.getValue().isBlank() || entry.getValue().isEmpty()){
                throw new FieldNotFoundException(entry.getKey().substring(0,1).toUpperCase()+entry.getKey().substring(1)+" not found");
            }
        }
        ClientEntity client = clientRepository.findById(responseBody.get("clientId")).stream().findFirst().orElse(null);
        if(client != null){
            ProjectEntity project = new ProjectEntity(responseBody.get("project_name"), new Date(responseBody.get("planned_start_date")),new Date(responseBody.get("planned_end_date")),new Date(responseBody.get("actual_start_date")),new Date(responseBody.get("actual_end_date")),responseBody.get("project_description"),client);
            ProjectEntity projectEntity = projectRepository.save(project);
            return projectEntity;
        }else{
            throw new ClientNotFoundException("Client not found");
        }

    }

    @Override
    public ProjectEntity updateProject(Map<String,String> responseBody) {
        for (Map.Entry<String,String> entry : responseBody.entrySet()){
            if(entry.getValue() == null || entry.getValue().isBlank() || entry.getValue().isEmpty()){
                throw new FieldNotFoundException(entry.getKey().substring(0,1).toUpperCase()+entry.getKey().substring(1)+" not found");
            }
        }

        ProjectEntity project = projectRepository.findById(responseBody.get("id")).stream().findFirst().orElse(null);
        System.out.println(project);
        if(project!=null){
            ClientEntity client = clientRepository.findById(responseBody.get("clientId")).stream().findFirst().orElse(null);
        if(client != null){
            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity.setId(responseBody.get("id"));
            projectEntity.setProject_name(responseBody.get("project_name"));
            projectEntity.setPlanned_start_date(new Date(responseBody.get("planned_start_date")));
            projectEntity.setPlanned_end_date(new Date(responseBody.get("planned_end_date")));
            projectEntity.setActual_start_date(new Date(responseBody.get("actual_start_date")));
            projectEntity.setActual_end_date(new Date(responseBody.get("actual_end_date")));
            projectEntity.setProject_description(responseBody.get("project_description"));
            projectEntity.setClientId(client);


            return projectRepository.save(projectEntity);
        }else{
            throw new ClientNotFoundException("Client not found");
        }}
        else {
            throw new ProjectNotFoundException("Project not found");
        }
    }

    @Override
    public List<ProjectEntity> getProject() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity getProjectById(String id) {
        ProjectEntity project = projectRepository.findById(id).stream().findFirst().orElse(null);

        if(project !=null){
            return project;
        }

        else {
            throw new ProjectNotFoundException("Project not found");
        }
    }

    @Override
    public void deleteProject(String id) {
        ProjectEntity project = projectRepository.findById(id).stream().findFirst().orElse(null);

        if(project !=null){
            projectRepository.deleteById(id);
        }

        else {
            throw new ProjectNotFoundException("Project not found");
        }
    }

    @Override
    public List<ProjectEntity> getProjectByClientId(String id) {
        ClientEntity clientEntity = clientRepository.findById(id).stream().findFirst().orElse(null);
        System.out.println(clientEntity);
        if(clientEntity != null){
            return projectRepository.findAllByClientId(id);
        }
        else {
            throw new ClientNotFoundException("Client Not found");
        }
    }
}
