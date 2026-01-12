package com.divami.task_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tags")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {
	
	@Id
	@GeneratedValue()
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	@Column()
	private String key;
	
	@Column()
	private String value;
	
	@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
	private Set<Tasks> tasks = new HashSet<>();
	
	protected Tags() {}
	
	public Tags(String value) {
		this.value = value;
	}
	
	// Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Tasks> tasks) {
		this.tasks = tasks;
	}
}