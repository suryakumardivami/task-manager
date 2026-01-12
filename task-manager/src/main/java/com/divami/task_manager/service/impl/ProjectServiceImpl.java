package com.divami.task_manager.service.impl;

import com.divami.task_manager.repository.ProjectRepositoryInt;
import com.divami.task_manager.entity.Projects;
import com.divami.task_manager.service.ProjectServiceInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectServiceInt {
	private final ProjectRepositoryInt projectRepo;
	
	public ProjectServiceImpl(ProjectRepositoryInt projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	@Override
	public Projects createProject(Projects project) {
		return projectRepo.save(project);
	}
	
	@Override
	public List<Projects> getAllProjects() {
		return projectRepo.findAll();
	}
	
	@Override
	public Projects getProjectById(UUID id) {
		return projectRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Project not found with id:" +id));
	}
	
	@Override
	public Projects updateProject(UUID id, Projects project) {
		Projects existingProject = getProjectById(id);
        if (project.getName() != null) {
            existingProject.setName(project.getName());
        }
        if (project.getDescription() != null) {
            existingProject.setDescription(project.getDescription());
        }
        return projectRepo.save(existingProject);
	}
	
	@Override
	public void deleteProject(UUID id) {
		if (!projectRepo.existsById(id)) {
			throw new RuntimeException("Project not found with id:" +id);
		}
		projectRepo.deleteById(id);
	}
}
