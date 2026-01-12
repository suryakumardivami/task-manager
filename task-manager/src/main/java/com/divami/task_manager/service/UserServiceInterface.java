package com.divami.task_manager.service;

import com.divami.task_manager.entity.Users;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {
	Users createUser(Users user);
	
	List<Users> getAllUsers();
	
	Users getUserById(UUID id);
}
