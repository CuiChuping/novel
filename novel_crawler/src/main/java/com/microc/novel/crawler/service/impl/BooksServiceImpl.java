package com.microc.novel.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.microc.novel.basic.dao.BooksDao;
import com.microc.novel.basic.model.Books;
import com.microc.novel.crawler.handler.BooksHandler;
import com.microc.novel.crawler.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksDao booksDao;
	
	@Async
	@Override
	public void crawler(String category) {
		int pageCount = BooksHandler.getPageCount(category);
		for (int pageNum = 1; pageNum <= pageCount; pageNum++) {
			System.out.println("开始爬取: " + category + ": " + pageNum);
			List<Books> booksList = BooksHandler.buildBooks(category, pageNum);
			for (Books books : booksList) {
				System.out.println("开始写入: " + category + ": " + pageNum + ": " + books.getName());
				booksDao.insert(books);
			}
		}
	}

}
