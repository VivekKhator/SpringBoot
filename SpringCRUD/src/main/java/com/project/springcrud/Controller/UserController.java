package com.project.springcrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.springcrud.DTO.UserDTO;
import com.project.springcrud.Entity.User;
import com.project.springcrud.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
		userService.addUser(userDTO);
		return new ResponseEntity<>("User added Successfully!",HttpStatus.CREATED);
	}
	
	
}
