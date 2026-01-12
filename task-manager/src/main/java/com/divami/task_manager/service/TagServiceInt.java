package com.divami.task_manager.service;

import com.divami.task_manager.entity.Tags;

import java.util.List;

public interface TagServiceInt {
	Tags createTag(Tags tag);
	Tags getTagByKey(String key);
	
	List<Tags> getAllTags();
	Tags updateTag(String key, Tags tag);
	
	void deleteTag(String key);
}
