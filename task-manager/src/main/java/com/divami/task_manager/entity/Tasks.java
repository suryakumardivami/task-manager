package com.divami.task_manager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.*;

@Entity
@Table(name = "task")
public class Tasks {

	@Id
	@GeneratedValue()
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	@Column()
	private String title;
	
	@Column()
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "project_id", nullable = false)
	private Projects project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_task_id", nullable=false)
	private Tasks parentTask;
	
	@OneToMany(mappedBy="parentTask")
	private Set<Tasks> subTasks = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "task_tags",
		joinColumns = @JoinColumn(name = "task_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private Set<Tags> tags = new HashSet<>();
	
	protected Tasks() {
	}
	
	public Tasks(String title) {
		this.title = title;
	}
	
	// getters and setters
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setTitle(String title) {
		validateTitle(title);
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Tasks getParentTask() {
		return parentTask;
	}
	
	public void setParentTask(Tasks parentTask) {
		if(parentTask != null && parentTask.equals(this)) {
			throw new IllegalArgumentException("Task cannot be its own parent");
		}
		this.parentTask = parentTask;
	}
	
	public Set<Tasks> getSubTasks() {
		return subTasks;
	}
	
	// helper methods 
	// isRootTask()
	// addSubTask()
	// removeSubTask()
	
	// validators 
	private void validateTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("title cannot be empty");
		}
	}
}
