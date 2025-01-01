package com.auth.dto;

import java.util.Set;
import com.auth.model.Role;
//import com.auth.model.User;

public class UserRequest {
	private String email;
    private String password;
    private Set<Role> roles;
	
	// No-args constructor
    public UserRequest() {}

    // All-args constructor
    public UserRequest(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Getters and setters

    // email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // password
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    // roles
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
    
    // Builder pattern
//    public static class Builder {
//        private Long id;
//        private String email;
//        private String password;
//        private Set<Role> roles = new HashSet<>();
//
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//        
//        public Builder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder roles(Set<Role> roles) {
//            this.roles = roles;
//            return this;
//        }
//
//        public Builder addRole(Role role) {
//            this.roles.add(role);
//            return this;
//        }
//
//        public User build() {
//            return new User(id, email, password, roles);
//        }
//    }
}
