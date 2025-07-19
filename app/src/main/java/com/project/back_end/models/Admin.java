package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "admins") // Optional: explicitly naming the table
public class Admin {

    // 1. Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 2. Username with validation
    @NotNull(message = "Username cannot be null")
    private String username;

    // 3. Password with validation and JSON access control
    @NotNull(message = "Password cannot be null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // 4. No-arg constructor (required by JPA)
    public Admin() {}

    // 4. Parameterized constructor (optional)
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 5. Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
