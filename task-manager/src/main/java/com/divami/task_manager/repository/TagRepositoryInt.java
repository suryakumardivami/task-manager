package com.divami.task_manager.repository;

import com.divami.task_manager.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagRepositoryInt extends JpaRepository<Tags, UUID> {
	Optional<Tags> findByKey(String key);
    boolean existsByKey(String key);
    void deleteByKey(String key);
}
