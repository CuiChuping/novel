package com.novel.cms.service;

import java.util.List;

import com.microc.novel.basic.model.Category;

/**
 * 
 * @author sun
 * @createTime 下午4:05:47
 * 广告block  Service
 */
public interface CategoryService {

	/**
	 * 查询所有分类
	 * */
	List<Category> findAll();

	/**
	 * 添加分类
	 * */
	void add(Category category);
	
	/**
	 * 根据Id查询
	 * */
	Category findById(String id);
	
	/**
	 * 更新分类
	 * */
	void update(Category category);

	/**
	 * 删除分类
	 * */
	void delete(String[] marked);

}
