package com.project.springcrud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.springcrud.DTO.UserDTO;
import com.project.springcrud.Entity.User;
import com.project.springcrud.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(UserDTO userDTO) {
		
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setAge(userDTO.getAge());
		user.setAddress(userDTO.getAddress());
		userRepository.save(user);
	}
}
