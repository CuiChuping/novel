package com.microc.novel.basic.dao;

import java.util.List;

import com.microc.novel.basic.model.Category;

public interface CategoryDao {

	int insert(Category category);
	
	int delete(String id);
	
	int update(Category category);
	
	Category findById(String id);
	
	Category findByName(String name);
	
	List<Category> list();
	
}
