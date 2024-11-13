package com.auth.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.auth.model.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
	Optional<Role> findRoleById(Long id);
	Optional<Role> findRoleByLabel(String label);
	void deleteRoleById(Long id);
}
