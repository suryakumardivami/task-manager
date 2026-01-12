package com.divami.task_manager.service.impl;

import com.divami.task_manager.entity.Users;
import com.divami.task_manager.repository.UserRepository;
import com.divami.task_manager.service.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserServiceInterface {
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
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
