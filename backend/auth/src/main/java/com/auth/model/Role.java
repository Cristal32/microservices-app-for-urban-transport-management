package com.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "label", length = 100, unique = true)
	private String label;
	
	//constructeurs
	public Role() {}
	
	public Role(Long id, String label) {
		this.id = id;
		this.label = label;
	}
	
	// Getters & Setters
	// id
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	// Label
	public String getLabel() {
		return label;
	}
		
	public void setLabel(String label) {
		this.label = label;
	}
}
