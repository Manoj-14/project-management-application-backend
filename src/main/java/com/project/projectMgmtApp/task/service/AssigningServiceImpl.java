package com.project.projectMgmtApp.task.service;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.repository.EmployeeRepository;
import com.project.projectMgmtApp.User.repository.RoleRepository;
import com.project.projectMgmtApp.task.dto.AssignmentDTO;
import com.project.projectMgmtApp.task.exceptions.AssignedValueNotFound;
import com.project.projectMgmtApp.task.exceptions.TaskNotFoundException;
import com.project.projectMgmtApp.task.model.Assignment;
import com.project.projectMgmtApp.task.model.Task;
import com.project.projectMgmtApp.task.repository.AssignedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AssigningServiceImpl {
    @Autowired
    private AssignedRepository assignedRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RoleRepository roleRepository;

    private Assignment assignmentDtoToModel(AssignmentDTO assignmentDTO){
        ModelMapper mapper = new ModelMapper();
        Assignment assignment = mapper.map(assignmentDTO,Assignment.class);
        Employee employee = this.getEmployee(assignmentDTO.getEmployeeId());
        Role role = this.getRole(assignmentDTO.getRoleId());
        Task task = this.taskService.getTeam(assignmentDTO.getTeamId());
        assignment.setRole(role);
        assignment.setEmployee(employee);
        assignment.setTask(task);
        return assignment;
    }

    @Transactional
    public Assignment createTaskAssignment(AssignmentDTO assignmentDTO)  {
        Assignment assignment = this.assignmentDtoToModel(assignmentDTO);
        assignedRepository.save(assignment);
        return assignment;
    }

//    @Async
    private Employee getEmployee(String id){
        Employee employee = employeeRepository.findById(id).stream().findFirst().orElse(null);
        if(employee == null) throw new RuntimeException("Employee Not found");
        else return employee;
    }

    private Role getRole(String id){
        Role role = roleRepository.findById(id).stream().findFirst().orElse(null);
        if(role == null) throw new RuntimeException("Role not found");
        else return role;
    }

    public List<Assignment> getAssignmentsByTaskId(String taskId) throws TaskNotFoundException {
        Task task = taskService.getTeam(taskId);
        List<Assignment> assignmentLists = assignedRepository.findAllByTaskId(task.getId());
        return assignmentLists;
    }

    public Assignment getAssigned(String id) throws AssignedValueNotFound {
        Assignment dbAssignment = assignedRepository.findById(id).stream().findFirst().orElse(null);
        if(dbAssignment != null) return dbAssignment;
        else throw new AssignedValueNotFound("Assigned details not found");
    }

    @Transactional
    public Assignment updateAssigned(AssignmentDTO assignmentDTO){
        if (assignmentDTO.getId() == null){
            throw new AssignedValueNotFound("Assignment not found");
        }else {
            Assignment assignment = this.assignmentDtoToModel(assignmentDTO);
            assignedRepository.save(assignment);
            return assignment;
        }
    }

    @Transactional
    public void deleteAssignment(String id){
        Assignment assignment = this.getAssigned(id);
        assignedRepository.deleteById(id);
    }

    public Assignment demoUpdate(AssignmentDTO assignmentDTO){
        return this.assignmentDtoToModel(assignmentDTO);
    }
}
