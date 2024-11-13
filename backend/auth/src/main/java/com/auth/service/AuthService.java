package com.auth.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.auth.dto.RegisterUserDTO;
import com.auth.dto.UpdateUserDTO;
import com.auth.exception.ResourceNotFoundException;
import com.auth.model.User;
import com.auth.repository.UserDao;

@Service
public class AuthService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UpdateUserDTO updateUserDTO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private JwtService jwtService;
	
	// ---------------------- Map from DTO to user --------------------------
	public User mapDtoToUser(RegisterUserDTO dto) {
	    User user = new User();
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setPassword(dto.getPassword());
	    return user;
	}
	
	// ---------------------- get all users --------------------------
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	// ---------------------- get a user by their id --------------------------
	public User findUserById(Long id){
		return userDao.findById(id).orElse(null);
	}
		
	// ---------------------- get a user by their email --------------------------
	public User findUserByUsername(String email){
		return userDao.findByEmail(email).orElse(null);
	}
	
	// ---------------------- save a user --------------------------
	@Transactional
	public User registerUser(RegisterUserDTO registerUserDTO) {
		User user = mapDtoToUser(registerUserDTO);
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    return userDao.save(user);
	}
	
	// ---------------------- update a user --------------------------
	public User updateUser(Long id, UpdateUserDTO updateUserDTO) {
		User user = userDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
		
		// Map fields from DTO to entity
        user.setName(updateUserDTO.getName());
        
        // Persist updated entity
        return userDao.save(user);
	}
	
	// ---------------------- generate a token --------------------------
//	public String generateToken(String username) {
//		return jwtService.generateToken(username);
//	}
	
//	public String generateToken(String email) {
//        User user = userDao.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
//        return jwtService.generateToken(email, user.getRoles());
//    }
	
	// ---------------------- validate the token --------------------------
//	public void validateToken(String token) {
//		jwtService.validateToken(token);
//	}
}