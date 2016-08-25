package com.novel.cms.service.impl;

/**
 * @author sun
 * */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.microc.novel.basic.dao.ChapterDao;
import com.microc.novel.basic.model.Chapter;
import com.novel.cms.service.ChapterService;
@Service
public class ChapterServiceImpl implements ChapterService {

	private @Resource ChapterDao dao;

	@Override
	public List<Chapter> findAll(String bookId) {
		return dao.list(bookId, null, null);
	}

	@Override
	public Chapter findById(String string) {
		return dao.findById(string);
	}

	@Override
	public void add(Chapter chapter) {
		dao.insert(chapter);		
	}

	@Override
	public void update(Chapter chapter) {
		dao.update(chapter);
	}

	@Override
	public void delete(String[] marked) {
		for(String id : marked){
			dao.delete(id);
		}
	}
	
}
