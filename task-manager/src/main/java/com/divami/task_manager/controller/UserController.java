package com.divami.task_manager.controller;

import com.divami.task_manager.entity.Users;
import com.divami.task_manager.service.UserServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/users")
public class UserController {
	private final UserServiceInterface userService;
	
	public UserController(UserServiceInterface userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public Users createUser(@RequestBody Users user) {
		System.out.println("Received user - Email: " + user.getEmail() + ", Name: " + user.getName() + ", Role: " + user.getRole());
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable UUID id) {
		return userService.getUserById(id);
	}
}
