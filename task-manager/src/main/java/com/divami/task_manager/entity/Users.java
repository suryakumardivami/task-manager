package com.divami.task_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.time.OffsetDateTime;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
	
	@Id
	@GeneratedValue()
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=true, length=150)
	private String name;
	
	@Column(nullable=true)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=20)
	private UserRole role;
	
	@Column(name="created_by")
	private UUID createdBy;
	
	@Column(name="created_at")
	private OffsetDateTime createdAt;
	
	@Column(name="updated_by")
	private UUID updatedBy;
	
	@Column(name="updated_at")
	private OffsetDateTime updatedAt;
	
	public Users(String email, UserRole role) {
		validateEmail(email);
		validateRole(role);
		this.email = email.toLowerCase();
		this.role = role;
	}
	
	// setters and getters
	public UUID getId() {
		return id;
	}
	
	protected void setId(UUID id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	protected void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		validateRole(role);
		this.role = role;
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
    
    // validation helpers
    private void validateEmail(String email) {
    	if(email == null) {
    		throw new IllegalArgumentException("Email should not be null");
    	}
    }
    
    private void validateRole(UserRole role) {
    	if(role == null) {
    		throw new IllegalArgumentException("role should not be null");
    	}
    }
	
    //lifecycle hooks
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
