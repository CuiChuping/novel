package com.microc.novel.web.service.impl;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microc.novel.basic.dao.BooksDao;
import com.microc.novel.basic.model.Books;
import com.microc.novel.web.service.ShelfService;

@Service
public class ShelfServiceImpl implements ShelfService {

	@Autowired
	private BooksDao booksDao;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public List<Books> findShelfBooks(HttpServletRequest request) {
		List<Books> books = new ArrayList<>();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("books".equals(cookie.getName())) {
				try {
					String[] ids = objectMapper.readValue(URLDecoder.decode(cookie.getValue(), "UTF-8"), String[].class);
					if(ids != null) {
						for (String id : ids) {
							books.add(booksDao.findById(id));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}

}
