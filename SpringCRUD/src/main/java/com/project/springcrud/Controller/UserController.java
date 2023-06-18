package com.project.springcrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> list = userService.getAllUsers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
		UserDTO list = userService.getUser(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user){
		userService.updateUser(id, user);
		return new ResponseEntity<>("Details has been updated in the table!", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return new ResponseEntity<>("User "+id+" deleted successfully", HttpStatus.OK);
	}
}
