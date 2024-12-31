package com.auth.dto;

import javax.validation.constraints.NotBlank;

public class UpdateUserDTO {
	@NotBlank(message = "Id is required")
    private Long id;
	
	@NotBlank(message = "Name is required")
    private String name;
	
	// Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
