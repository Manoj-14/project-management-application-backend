package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.User.exceptions.UserAccountNotFound;
import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.repository.UserAccountRepository;
import com.project.projectMgmtApp.project.entity.ProjectEntity;
import com.project.projectMgmtApp.project.entity.ProjectManagerEntity;
import com.project.projectMgmtApp.project.exceptions.FieldNotFoundException;
import com.project.projectMgmtApp.project.exceptions.ProjectManagerNotFoundException;
import com.project.projectMgmtApp.project.exceptions.ProjectNotFoundException;
import com.project.projectMgmtApp.project.repository.ProjectManagerRepository;
import com.project.projectMgmtApp.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

    private ProjectRepository projectRepository;

    private UserAccountRepository userAccountRepository;

    private ProjectManagerRepository projectManagerRepository;

    @Autowired
    public ProjectManagerServiceImpl(ProjectRepository projectRepository, UserAccountRepository userAccountRepository,ProjectManagerRepository projectManagerRepository){
        this.projectManagerRepository=projectManagerRepository;
        this.projectRepository = projectRepository;
        this.userAccountRepository = userAccountRepository;
    }

    private static void checkAllParametersArePresentInTheMap(Map<String, String> projectManager) {
        for (Map.Entry<String,String> entry : projectManager.entrySet()){
            if(entry.getValue() == null || entry.getValue().isBlank() || entry.getValue().isEmpty()){
                throw new FieldNotFoundException(entry.getKey().substring(0,1).toUpperCase()+entry.getKey().substring(1)+" not found");
            }
        }
    }


    @Override
    public ProjectManagerEntity addProjectManager(Map<String,String> projectManager) {

        checkAllParametersArePresentInTheMap(projectManager);

        ProjectEntity project = projectRepository.findById(projectManager.get("projectId")).stream().findFirst().orElse(null);
        UserAccount user = userAccountRepository.findById(projectManager.get("userAccountId")).stream().findFirst().orElse(null);

        if(project!=null && user!=null && !user.isProjectManager()){

            ProjectManagerEntity projectManagerEntity = new ProjectManagerEntity(project,user);
            projectManagerEntity.getUserAccountId().setProjectManager(true);

            userAccountRepository.save(user);
            return projectManagerRepository.save(projectManagerEntity);
        }
        else if(project == null){
            throw new ProjectNotFoundException("Project not found");
        }
        else if(user == null){
            throw new UserAccountNotFound("User not found");
        }
        else {
            throw new ProjectNotFoundException("Employee is already in another project as a manager");
        }
    }



    @Override
    public ProjectManagerEntity updateProjectManager(Map<String,String> projectManager) {
        checkAllParametersArePresentInTheMap(projectManager);
        ProjectManagerEntity projectManagers = projectManagerRepository.findById(projectManager.get("id")).stream().findFirst().orElse(null);

        if(projectManagers != null){

        ProjectEntity project = projectRepository.findById(projectManager.get("projectId")).stream().findFirst().orElse(null);
        UserAccount user = userAccountRepository.findById(projectManager.get("userAccountId")).stream().findFirst().orElse(null);
        UserAccount prevUser = userAccountRepository.findById(projectManagers.getUserAccountId().getId()).get();


        if(project!=null && user!=null && (!user.isProjectManager() || projectManagers.getUserAccountId().isProjectManager())){
            ProjectManagerEntity projectManagerEntity = new ProjectManagerEntity();
            projectManagerEntity.setUserAccountId(user);
            projectManagerEntity.setProjectId(project);
            projectManagerEntity.setId(projectManager.get("id"));
            if( !user.getId().equals(projectManagers.getUserAccountId().getId())){
                prevUser.setProjectManager(false);
                projectManagerEntity.getUserAccountId().setProjectManager(true);
                userAccountRepository.save(prevUser);
                userAccountRepository.save(user);
                projectManagerRepository.save(projectManagers);
            }

            return projectManagerRepository.save(projectManagerEntity);
        }
        else if(project == null){
            throw new ProjectNotFoundException("Project not found");
        }
        else if(user == null){
            throw new UserAccountNotFound("User not found");
        }
        else {
            throw new ProjectNotFoundException("Employee is already in another project as a manager");
        }}
        else {
            throw new ProjectManagerNotFoundException("Project Manager not found");
        }
    }

    @Override
    public List<ProjectManagerEntity> getProjectManager() {
        return projectManagerRepository.findAll();
    }

    @Override
    public ProjectManagerEntity getProjectManagerById(String id) {
        ProjectManagerEntity projectManager = projectManagerRepository.findById(id).stream().findFirst().orElse(null);
        if(projectManager !=null){
            return projectManager;
        }
        else {
            throw new ProjectManagerNotFoundException("Project Manager not found");
        }
    }

    @Override
    public ProjectManagerEntity getProjectManagerByProjectId(String id) {
        ProjectEntity project = projectRepository.findById(id).stream().findFirst().orElse(null);

        if(project !=null){
            ProjectManagerEntity projectManager= projectManagerRepository.findByProjectId(id);

            if(projectManager != null){
                return projectManager;
            }
            else {
                throw new ProjectManagerNotFoundException("Project Manager not found");
            }
        }
        else {
            throw new ProjectNotFoundException("Project Not found");
        }
    }

    @Override
    public ProjectManagerEntity getProjectManagerByUserAccountId(String id) {
        UserAccount user = userAccountRepository.findById(id).stream().findFirst().orElse(null);
        if(user !=null){
            ProjectManagerEntity projectManager= projectManagerRepository.findByUserAccountId(id);
            if(projectManager != null){
                return projectManager;
            }
            else {
                throw new ProjectManagerNotFoundException("Project Manager not found");
            }
        }
        else {
            throw new UserAccountNotFound("User not found");
        }
    }

    @Override
    public void deleteProjectManager(String id) {
        ProjectManagerEntity projectManager = projectManagerRepository.findById(id).stream().findFirst().orElse(null);
        if(projectManager !=null){
            projectManager.getUserAccountId().setProjectManager(false);
            UserAccount user = userAccountRepository.findById(projectManager.getUserAccountId().getId()).get();
            user.setProjectManager(false);
            userAccountRepository.save(user);
            projectManagerRepository.deleteById(id);
        }
        else {
            throw new ProjectManagerNotFoundException("Project Manager not found");
        }
    }
}
