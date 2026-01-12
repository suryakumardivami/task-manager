package com.divami.task_manager.service.impl;

import com.divami.task_manager.entity.Users;
import com.divami.task_manager.repository.UserRepositoryInt;
import com.divami.task_manager.service.UserServiceInt;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserServiceInt {
	private final UserRepositoryInt userRepository;
	
	public UserServiceImpl(UserRepositoryInt userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Users createUser(Users user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Users getUserById(UUID id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}
}
