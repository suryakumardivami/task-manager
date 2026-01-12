package com.divami.task_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.*;

@Entity
@Table(name="project")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Projects {
	
	@Id
	@GeneratedValue()
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	@Column()
	private String name;
	
	@Column()
	private String description;
	
	@OneToMany(mappedBy = "project")	
	private List<Tasks> tasks = new ArrayList<>();

	@Column(name="created_by")
	private UUID createdBy;
	
	@Column(name="created_at")
	private OffsetDateTime createdAt;
	
	@Column(name="updated_by")
	private UUID updatedBy;
	
	@Column(name="updated_at")
	private OffsetDateTime updatedAt;

	// Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public UUID getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = OffsetDateTime.now();
		this.updatedAt = OffsetDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = OffsetDateTime.now();
	}
}