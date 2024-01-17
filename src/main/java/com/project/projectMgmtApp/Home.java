package com.project.projectMgmtApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping
    public String home(){
        return "In Home Path" ;
    }
}
