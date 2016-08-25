package com.microc.novel.basic.dao;

import java.util.List;

import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.model.Suggestion;

public interface BooksDao {

	int insert(Books books);
	
	int delete(String id);
	
	int update(Books books);
	
	Books findById(String id);
	
	List<Books> list(String category, String name, Integer skip, Integer size);
	
	int count(String category, String name);
	//提交意见反馈
	void suggestionSubmit(Suggestion sug);
	
}
