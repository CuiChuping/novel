package com.microc.novel.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microc.novel.basic.dao.BooksDao;
import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.util.Pager;
import com.microc.novel.web.service.BooksService;


@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksDao booksDao;

	@Override
	public List<Books> find(Pager<Books> pager, String category, String name) {
		List<Books> result = booksDao.list(category, name, pager.getBeginRow(), pager.getRowCount());
		pager.setResult(result);
		pager.setTotalCount(booksDao.count(category, name));
		return result;
	}

	@Override
	public Books findById(String id) {
		return booksDao.findById(id);
	}
	
}
