package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.dto.TeamMemberDTO;
import com.project.projectMgmtApp.User.exceptions.TeamMemberNotFound;
import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.Role;
import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.model.TeamMember;
import com.project.projectMgmtApp.User.repository.EmployeeRepository;
import com.project.projectMgmtApp.User.repository.TeamMemberRepository;
import com.project.projectMgmtApp.User.repository.TeamRepository;
import com.project.projectMgmtApp.User.repository.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService{

    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @Autowired
    private TeamService teamService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    private TeamMember teamMemberDTOToModel(TeamMemberDTO teamMemberDTO){
        ModelMapper mapper = new ModelMapper();
        TeamMember teamMember = mapper.map(teamMemberDTO,TeamMember.class);
        Employee employee = employeeService.getEmployeeById(teamMemberDTO.getEmployeeId());
        Team team = teamService.getTeamById(teamMemberDTO.getTeamId());
        Role role = roleService.getRoleById(teamMemberDTO.getRoleId());
        teamMember.setTeamId(team);
        teamMember.setEmployeeId(employee);
        teamMember.setRoleId(role);
        return teamMember;
    }

    @Override
    public TeamMember createTeamMember(TeamMemberDTO teamMemberDTO) {
        TeamMember teamMember = this.teamMemberDTOToModel(teamMemberDTO);
        teamMemberRepository.save(teamMember);
        return teamMember;
    }

    @Override
    public TeamMember getTeamMemberById(String teamMemberId) {
        TeamMember teamMember = teamMemberRepository.findById(teamMemberId).stream().findFirst().orElse(null);
        if(teamMember!= null) {
            return teamMember;
        } else{
            throw new TeamMemberNotFound("Team Member not found");
        }
    }

    @Override
    public List<TeamMember> getTeamMembersByTeamId(String teamId) {
        Team team = teamService.getTeamById(teamId);
        List<TeamMember> teamMembers = teamMemberRepository.findAllByTeamId(teamId);
        return teamMembers;
    }

    @Override
    public List<TeamMember> getTeamMembersByRoleId(String roleId) {
        Role role = roleService.getRoleById(roleId);
        List<TeamMember> teamMembers = teamMemberRepository.findAllByRoleId(roleId);
        return teamMembers;
    }

    @Override
    public void deleteTeamMember(String teamMemberId) {
        TeamMember teamMember = teamMemberRepository.findById(teamMemberId).stream().findFirst().orElse(null);

        if(teamMember!= null) {
            teamMemberRepository.deleteById(teamMemberId);
        } else{
            throw new TeamMemberNotFound("Team Member not found");
        }
    }
}
