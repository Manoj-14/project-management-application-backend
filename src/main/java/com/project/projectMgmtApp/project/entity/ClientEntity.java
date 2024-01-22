package com.project.projectMgmtApp.project.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class ClientEntity {
    @Id
    private String id;

    @NotNull(message = "is required")
    private String c_name;

    @NotNull(message = "is required")
    private String c_address;

    @NotNull(message = "is required")
    private String c_details;

    public ClientEntity() {
    }

    public ClientEntity(String id, String c_name, String c_address, String c_details) {
        this.id = id;
        this.c_name = c_name;
        this.c_address = c_address;
        this.c_details = c_details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_details() {
        return c_details;
    }

    public void setC_details(String c_details) {
        this.c_details = c_details;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", c_name='" + c_name + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_details='" + c_details + '\'' +
                '}';
    }
}

