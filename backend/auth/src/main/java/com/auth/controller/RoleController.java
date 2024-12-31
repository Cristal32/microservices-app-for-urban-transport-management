package com.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.model.Role;
import com.auth.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private final RoleService roleService;
	
	//constructeur
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> roles = roleService.getAllRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/getByLabel/{label}")
	public ResponseEntity<Role> getRoleByName(@PathVariable("label") String label){
		Role role = roleService.findRoleByName(label);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id){
		Role role = roleService.findRoleById(id);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}

	// ================================= POST Maping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Role> addRole(@RequestBody Role role){
		Role newRole = roleService.addRole(role);
		return new ResponseEntity<>(newRole, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Role> updateRole(@RequestBody Role role){
		Role updatedRole = roleService.updateRole(role);
		return new ResponseEntity<>(updatedRole, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
//	@Transactional
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> deleteRole(@PathVariable("id") Long id){
//		roleService.deleteRole(id);
//		return new ResponseEntity<>(HttpStatus.OK); 
//	}
}