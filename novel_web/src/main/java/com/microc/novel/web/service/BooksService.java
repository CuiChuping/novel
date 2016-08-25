package com.microc.novel.web.service;

import java.util.List;

import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.util.Pager;

public interface BooksService {

	List<Books> find(Pager<Books> pager, String category, String name);
	
	Books findById(String id);
	
}
