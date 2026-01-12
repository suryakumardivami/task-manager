package com.divami.task_manager.repository;

import com.divami.task_manager.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Projects, UUID> {
}
