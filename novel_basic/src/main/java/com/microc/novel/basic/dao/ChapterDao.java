package com.microc.novel.basic.dao;

import java.util.List;

import com.microc.novel.basic.model.Chapter;


public interface ChapterDao {

	int insert(Chapter chapter);
	
	int delete(String id);
	
	int update(Chapter chapter);
	
	Chapter findById(String id);
	
	List<Chapter> list(String books, Integer skip, Integer size);
	
}
