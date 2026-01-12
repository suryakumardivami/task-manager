package com.divami.task_manager.controller;

import com.divami.task_manager.entity.Tags;
import com.divami.task_manager.service.TagServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
	private final TagServiceInt tagService;
	
	public TagController(TagServiceInt tagService) {
		this.tagService = tagService;
	}
	
	@PostMapping
	public Tags createTag(Tags tag) {
		return tagService.createTag(tag);
	}
	
	@GetMapping
	public List<Tags> getAllTags() {
		return tagService.getAllTags();
	}
	
	@GetMapping("/{key}")
	public Tags getTagByKey(@PathVariable String key) {
		return tagService.getTagByKey(key);
	}
	
	@PutMapping("/update/{key}")
	public Tags updateTag(@PathVariable String key, @RequestBody Tags tag) {
		return tagService.updateTag(key, tag);
	}
	
	@DeleteMapping("/{key}")
	public void deleteTag(String key) {
		tagService.deleteTag(key);
	}
	
}
