package com.divami.task_manager.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tags")
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
	
	public Set<Tasks> getTasks() {
		return tasks;
	}
}
