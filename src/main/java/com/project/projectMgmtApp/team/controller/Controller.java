package com.project.projectMgmtApp.team.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teams")
public class Controller {

    @GetMapping
    public String getTeam(){
        return "All teams";
    }
}
