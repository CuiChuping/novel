package com.novel.cms.service.impl;

/**
 * @author sun
 * */
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microc.novel.basic.dao.BooksDao;
import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.util.Generator;
import com.novel.cms.service.NovelService;

@Service
public class NovelServiceImpl implements NovelService {

	private @Resource BooksDao dao;
	
	@Value("${books.image}")
	private String booksImage;
	
	/**
	 * 查找小说
	 * */
	@Override
	public List<Books> findAll(String cateGoryId) {
		if(cateGoryId != null){
			return dao.list(cateGoryId, null, null, null);
		}else{
			return dao.list(null, null, null, null);
		}
	}
	
	/**
	 * 添加小说
	 * */
	@Override
	public void add(Books books, MultipartFile file) {
		if(file != null){
			try {
				String imagePath = booksImage + Generator.generate();
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imagePath));
				books.setImagePath(imagePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.insert(books);
	}

	@Override
	public Books findById(String string) {
		return dao.findById(string);
	}

	/**
	 * 修改小说
	 * */
	@Override
	public void update(Books books, MultipartFile file) {
		if(file != null){
			try {
				String imagePath = booksImage + Generator.generate();
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imagePath));
				books.setImagePath(imagePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.update(books);
	}
	
	/**
	 * 删除小说
	 * */
	@Override
	public void delete(String[] marked) {
		for(String id : marked){
			dao.delete(id);
		}
	}
}
