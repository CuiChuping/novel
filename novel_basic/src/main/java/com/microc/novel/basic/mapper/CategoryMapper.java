package com.microc.novel.basic.mapper;

import java.util.List;

import com.microc.novel.basic.model.db.DBCategory;


public interface CategoryMapper {

	int insert(DBCategory category);
	
	int delete(String id);
	
	int update(DBCategory category);
	
	DBCategory findById(String id);
	
	List<DBCategory> list();

	DBCategory findByName(String name);
	
}
