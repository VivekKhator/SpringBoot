package com.project.springcrud.Service;


import java.util.List;

import com.project.springcrud.DTO.UserDTO;
import com.project.springcrud.Entity.User;


public interface UserService {

	void addUser(UserDTO userDTO);
	UserDTO getUser(Integer id);
	List<UserDTO> getAllUsers();
	void updateUser(Integer id, User user);
	void deleteUser(Integer id);
}
