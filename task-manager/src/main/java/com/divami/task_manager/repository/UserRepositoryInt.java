package com.divami.task_manager.repository;

import com.divami.task_manager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryInt extends JpaRepository<Users, UUID> {
}