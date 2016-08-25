package com.novel.cms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.microc.novel.basic.model.Books;

/**
 * 
 * @author sun
 * @createTime 下午4:05:47
 *  Service
 */
public interface NovelService {
	/**
	 * 查询所有小说(根据分类)
	 * 
	 * */
	List<Books> findAll(String cateGoryId);
	/**
	 * 添加书籍
	 * 
	 * */
	void add(Books books, MultipartFile file);
	/**
	 * 根据Id查询书籍
	 * 
	 * */
	Books findById(String string);
	/**
	 * 更新书籍
	 * 
	 * */
	void update(Books books, MultipartFile file);
	/**
	 * 删除书籍
	 * 
	 * */
	void delete(String[] marked);

}
