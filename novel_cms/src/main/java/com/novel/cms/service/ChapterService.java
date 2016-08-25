package com.novel.cms.service;

import java.util.List;

import com.microc.novel.basic.model.Chapter;

/**
 * 
 * @author sun
 *  ChapterService
 */
public interface ChapterService {
	/**
	 * 查询所有章节
	 * 
	 * */
	List<Chapter> findAll(String bookId);
	/**
	 * 根据Id查询
	 * 
	 * */
	Chapter findById(String string);
	/**
	 * 添加章节
	 * 
	 * */
	void add(Chapter chapter);
	/**
	 * 更新章节
	 * 
	 * */
	void update(Chapter chapter);
	/**
	 * 删除章节
	 * 
	 * */
	void delete(String[] marked);

}
