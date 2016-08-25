package com.microc.novel.web.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microc.novel.basic.dao.BooksDao;
import com.microc.novel.basic.model.Suggestion;
import com.microc.novel.basic.util.Generator;
import com.microc.novel.web.service.MyService;


@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private BooksDao dao;

	@Override
	public void suggestionSubmit(String contactWay, String suggestion) {
		
		Suggestion sug = new Suggestion();
		sug.setId((String)Generator.generate());
		sug.setContactWay(contactWay);
		sug.setSuggestion(suggestion);
		sug.setCreateTime(new Date());
		
		dao.suggestionSubmit(sug);
	}
}
