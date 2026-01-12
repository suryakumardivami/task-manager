package com.divami.task_manager.controller;

import com.divami.task_manager.entity.*;
import com.divami.task_manager.service.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	private final ProjectServiceInt projectServiceInt;
	
	public ProjectController(ProjectServiceInt projectServiceInt) {
		this.projectServiceInt = projectServiceInt;
	}
	
	@PostMapping
	public Projects createProject(@RequestBody Projects project) {
		return projectServiceInt.createProject(project);
	}
	
	@GetMapping
	public List<Projects> getAllProjects() {
		return projectServiceInt.getAllProjects();
	}
	
	@GetMapping("/{id}")
	public Projects getProjectById(@PathVariable UUID id) {
		return projectServiceInt.getProjectById(id);
	}
	
	@PutMapping("/{id}")
	public Projects updateProject(@PathVariable UUID id, @RequestBody Projects project) {
		return projectServiceInt.updateProject(id, project);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable UUID id) {
		projectServiceInt.deleteProject(id);
	}
	
}
