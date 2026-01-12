package com.divami.task_manager.service.impl;

import java.util.List;
import java.util.UUID;

import com.divami.task_manager.entity.Tags;
import com.divami.task_manager.repository.TagRepositoryInt;
import com.divami.task_manager.service.TagServiceInt;

public class TagServiceImpl implements TagServiceInt {
	private final TagRepositoryInt tagRepo;
	
	public TagServiceImpl(TagRepositoryInt tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	@Override
	public Tags createTag(Tags tag) {
		return tagRepo.save(tag);
	}
	
	@Override
	public List<Tags> getAllTags() {
		return tagRepo.findAll();
	}
	
	@Override
	public Tags getTagByKey(String key) {
		return tagRepo.findByKey(key)
					.orElseThrow(() -> new RuntimeException("tag not found with key: " +key));
	}
	
	@Override
	public Tags updateTag(String key, Tags tag) {
		Tags existingTag = this.getTagByKey(key);
		
		if (tag.getValue() != null) {
			existingTag.setValue(tag.getValue());
		}
		
		return tagRepo.save(existingTag);
	}
	
	@Override
	public void deleteTag(String key) {
		if (!tagRepo.existsByKey(key)) {
			throw new RuntimeException("tag not found with key: " +key);
		}
		tagRepo.deleteByKey(key);
	}
}
