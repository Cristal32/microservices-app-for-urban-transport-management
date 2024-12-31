package com.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.model.Role;
import com.auth.repository.RoleDao;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	// ---------------------------- find all roles ----------------------------
	public List<Role> getAllRoles(){
		return roleDao.findAll();
	}
			
	// ---------------------------- find a role by their id ----------------------------
	public Role findRoleById(Long id) {
		return roleDao.findRoleById(id).orElse(null);
	}
		
	// ---------------------------- find a role by its name ----------------------------
	public Role findRoleByName(String label) {
		return roleDao.findRoleByLabel(label).orElse(null);
	}
		
	// ---------------------------- add a role ----------------------------
	public Role addRole(Role role) {
		return roleDao.save(role);
	}
	
	// ---------------------------- update a role ----------------------------
	public Role updateRole(Role role) {
		return roleDao.save(role);
	}
	
	// ---------------------------- delete a role by their id ----------------------------
//	public void deleteRole(Long id) {
//		roleDao.deleteRoleById(id);
//	}
}
