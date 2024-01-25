package com.project.projectMgmtApp.task.service;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.repository.EmployeeRepository;
import com.project.projectMgmtApp.task.exceptions.AssignedValueNotFound;
import com.project.projectMgmtApp.task.exceptions.TaskNotFoundException;
import com.project.projectMgmtApp.task.model.Assigned;
import com.project.projectMgmtApp.task.model.Task;
import com.project.projectMgmtApp.task.repository.AssignedRepository;
import com.project.projectMgmtApp.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AssigningServiceImpl {
    @Autowired
    private AssignedRepository assignedRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public void createTaskAssignment(Map<String,String> requestBody)  {
        Employee employee = this.getEmployee(requestBody.get("employeeId"));
        Task task = this.getTask(requestBody.get("taskId"));
        if(employee != null && task != null) {
            Assigned assigned = new Assigned();
            assigned.setEmployee(employee);
            assigned.setTask(task);
            assigned.setRoleId(requestBody.get("roleId"));
            assignedRepository.save(assigned);
        }
        else if (employee == null){
            throw new TaskNotFoundException("Employee not found");
        }
        else {
            throw new TaskNotFoundException("Task not found");
        }

    }

//    @Async
    private Employee getEmployee(String id){
        return employeeRepository.findById(id).stream().findFirst().orElse(null);
    }

//    @Async
    private Task getTask(String id){
        return taskRepository.findById(id).stream().findFirst().orElse(null);
    }

    public List<Assigned> getAssignmentsByTaskId(String taskId) throws TaskNotFoundException {
        Task dbTask = taskRepository.findById(taskId).stream().findFirst().orElse(null);
        if(dbTask == null){
            throw new TaskNotFoundException("Task not found for given id");
        }else {
            List<Assigned> assignedLists = assignedRepository.findAllByTaskId(taskId);
            return assignedLists;
        }
    }

    public Assigned getAssigned(String id) throws AssignedValueNotFound {
        Assigned dbAssigned = assignedRepository.findById(id).stream().findFirst().orElse(null);
        if(dbAssigned != null) return dbAssigned;
        else throw new AssignedValueNotFound("Assigned details not found");
    }
}
