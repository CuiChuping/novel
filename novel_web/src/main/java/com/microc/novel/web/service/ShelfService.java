package com.microc.novel.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.microc.novel.basic.model.Books;

public interface ShelfService {

	List<Books> findShelfBooks(HttpServletRequest request);
	
}
