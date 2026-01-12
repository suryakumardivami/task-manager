package com.divami.task_manager.service;

import com.divami.task_manager.entity.Projects;

import java.util.UUID;
import java.util.List;

public interface ProjectServiceInt {
	Projects createProject(Projects project);
	
	List<Projects> getAllProjects();
	
	Projects getProjectById(UUID id);
	Projects updateProject(UUID id, Projects project);
	
	void deleteProject(UUID id);
	
}
