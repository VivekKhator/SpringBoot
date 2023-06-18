package com.project.springcrud.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	@Override
	public List<UserDTO> getAllUsers(){
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> allUsers = new ArrayList<>();
		users.forEach(user->{
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setAge(user.getAge());
			userDTO.setAddress(user.getAddress());
			allUsers.add(userDTO);
		});
		
		return allUsers;
		
	}
	
	@Override
	public UserDTO getUser(Integer id){
		Optional<User> optional = userRepository.findById(id);
		User user = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setAge(user.getAge());
		userDTO.setAddress(user.getAddress());
		return userDTO;
		
	}

	@Override
	public void updateUser(Integer id, User user) {
		
		userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		user.setId(id);
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		userRepository.delete(user);
		
		
	}
	
	
}
