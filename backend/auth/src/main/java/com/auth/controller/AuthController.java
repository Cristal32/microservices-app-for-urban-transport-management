package com.auth.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth.dto.RegisterUserDTO;
import com.auth.dto.UpdateUserDTO;
import com.auth.model.User;
import com.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	// ================================= GET mapping =================================
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = authService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		User user = authService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
//	@GetMapping("/validateToken")
//	public ResponseEntity<?> validateToken(@RequestParam("token") String token) {
//		authService.validateToken(token);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	// ================================= POST mapping =================================
//	@PostMapping("/register")
//	public User registerUser(@RequestBody User user) {
//		return authService.registerUser(user);
//	}
	
	@PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        User registeredUser = authService.registerUser(registerUserDTO);
        return ResponseEntity.ok(registeredUser);
    }
	
//	@PostMapping("/getToken")
//	public ResponseEntity<String> getToken(@RequestBody UserRequest user) {
//		// Tell the authManager to authenticate the request before giving out the token
//		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//		
//		// If authenticated, generate the token
//		if(auth.isAuthenticated()) {
//			String token = authService.generateToken(user.getUsername());
//			return new ResponseEntity<>(token, HttpStatus.OK);
//		}else {
//			throw new RuntimeException("Invalid user credentials!");
//		}
//	}
	
	// ================================= PUT mapping =================================
	@PutMapping("/update/{id}")
	public User registerUser(@PathVariable("id") Long id, @RequestBody UpdateUserDTO updateUserRequest) {
		return authService.updateUser(id, updateUserRequest);
	}
}
