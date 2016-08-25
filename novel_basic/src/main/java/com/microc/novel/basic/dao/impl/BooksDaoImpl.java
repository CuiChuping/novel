package com.microc.novel.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.microc.novel.basic.dao.BooksDao;
import com.microc.novel.basic.mapper.BooksMapper;
import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.model.Suggestion;
import com.microc.novel.basic.model.db.DBBooks;
import com.microc.novel.basic.util.Generator;


@Repository
public class BooksDaoImpl implements BooksDao {

	@Autowired
	private BooksMapper mapper;
	
	@Value("${books.file}")
	private String booksPath;
	
	@Override
	public int insert(Books books) {
		String booksId = (String) Generator.generate();
		String filePath = booksPath + booksId;
//		try {
//			File file = new File(filePath);
//			if(!file.exists())
//				file.createNewFile();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
		books.setId(booksId);
		return mapper.insert(objectToDB(books, filePath));
	}

	@Override
	public int delete(String id) {
		return mapper.delete(id);
	}

	@Override
	public int update(Books books) {
		String filePath = booksPath + books.getId();
		return mapper.update(objectToDB(books, filePath));
	}

	@Override
	public Books findById(String id) {
		return dbToObject(mapper.findById(id));
	}

	@Override
	public List<Books> list(String category, String name, Integer skip, Integer size) {
		List<DBBooks> dbList = mapper.listByCategory(category, name, skip, size);
		List<Books> list = new ArrayList<Books>(dbList.size());
		for (DBBooks dbBooks : dbList) {
			list.add(dbToObject(dbBooks));
		}
		return list;
	}

	@Override
	public int count(String category, String name) {
		return mapper.countByCategory(category, name);
	}
	
	private Books dbToObject(DBBooks dbBooks) {
		Books books = new Books();
		books.setAuthor(dbBooks.getAuthor());
		books.setCategoryId(dbBooks.getCategoryId());
		books.setDesc(dbBooks.getDesc());
		books.setId(dbBooks.getId());
		books.setName(dbBooks.getName());
		books.setImagePath(dbBooks.getImagePath());
		books.setStatus(dbBooks.getStatus());
		books.setUpdateDate(dbBooks.getUpdateDate());
		books.setWordCount(dbBooks.getWordCount());
		return books;
	}
	

	private DBBooks objectToDB(Books books, String filePath) {
		DBBooks dbBooks = new DBBooks();
		dbBooks.setAuthor(books.getAuthor());
		dbBooks.setCategoryId(books.getCategoryId());
		dbBooks.setDesc(books.getDesc());
		dbBooks.setId(books.getId());
		dbBooks.setName(books.getName());
		dbBooks.setImagePath(books.getImagePath());
		dbBooks.setFilePath(filePath);
		dbBooks.setStatus(books.getStatus());
		dbBooks.setUpdateDate(books.getUpdateDate());
		dbBooks.setWordCount(books.getWordCount());
		return dbBooks;
	}

	@Override
	public void suggestionSubmit(Suggestion sug) {
		mapper.suggestionSubmit(sug);	
	}

}
