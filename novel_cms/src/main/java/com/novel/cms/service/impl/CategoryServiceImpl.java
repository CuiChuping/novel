package com.novel.cms.service.impl;

/**
 * @author sun
 * */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microc.novel.basic.dao.CategoryDao;
import com.microc.novel.basic.model.Category;
import com.novel.cms.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	private @Resource CategoryDao dao;
	
	@Override
	public List<Category> findAll() {
		return dao.list();
	}

	@Override
	public void add(Category category) {
		dao.insert(category);
	}

	@Override
	public Category findById(String id) {
		return dao.findById(id);
	}

	@Override
	public void update(Category category) {
		dao.update(category);
	}

	@Override
	public void delete(String[] marked) {
		for(String id : marked){
			dao.delete(id);
		}
	}

}
