package com.microc.novel.basic.mapper;

import java.util.List;

import com.microc.novel.basic.model.BooksUrl;

public interface BooksUrlMapper {

	List<BooksUrl> list();
	
	BooksUrl findById(String id);
	
	int insert(BooksUrl booksUrl);
	
	int update(BooksUrl booksUrl);
	
	int delete(String id);
	
}
