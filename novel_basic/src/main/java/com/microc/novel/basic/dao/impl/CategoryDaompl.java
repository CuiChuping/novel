package com.microc.novel.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microc.novel.basic.dao.CategoryDao;
import com.microc.novel.basic.mapper.CategoryMapper;
import com.microc.novel.basic.model.Category;
import com.microc.novel.basic.model.db.DBCategory;
import com.microc.novel.basic.util.Generator;


@Repository
public class CategoryDaompl implements CategoryDao {

	@Autowired
	private CategoryMapper mapper;

	@Override
	public int insert(Category category) {
		category.setId((String) Generator.generate());
		return mapper.insert(objectToDB(category));
	}

	@Override
	public int delete(String id) {
		return mapper.delete(id);
	}

	@Override
	public int update(Category category) {
		return mapper.update(objectToDB(category));
	}

	@Override
	public Category findById(String id) {
		return dbToObject(mapper.findById(id));
	}
	
	@Override
	public Category findByName(String name) {
		return dbToObject(mapper.findByName(name));
	}
	
	@Override
	public List<Category> list() {
		List<DBCategory> dbList = mapper.list();
		List<Category> list = new ArrayList<Category>(dbList.size());
		for (DBCategory category : dbList) {
			list.add(dbToObject(category));
		}
		return list;
	}

	private Category dbToObject(DBCategory dbCategory) {
		Category category = new Category();
		category.setId(dbCategory.getId());
		category.setName(dbCategory.getName());
		category.setIndex(dbCategory.getIndex());
		category.setUrl(dbCategory.getUrl());
		return category;
	}

	private DBCategory objectToDB(Category category) {
		DBCategory dbCategory = new DBCategory();
		dbCategory.setId(category.getId());
		dbCategory.setName(category.getName());
		dbCategory.setIndex(category.getIndex());
		dbCategory.setUrl(category.getUrl());
		return dbCategory;
	}

}
