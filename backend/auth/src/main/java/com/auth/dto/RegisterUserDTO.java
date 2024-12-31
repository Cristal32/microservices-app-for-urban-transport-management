package com.auth.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.auth.model.Role;

public class RegisterUserDTO {
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
	private String email;
	
	@NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters long")
	private String password;
	
	@NotBlank(message = "Role is required")
    private Set<Role> roles = new HashSet<>();  

	// Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Role> getRoles() { return roles; }
    public void setRole(Set<Role> roles) { this.roles = roles; }
}