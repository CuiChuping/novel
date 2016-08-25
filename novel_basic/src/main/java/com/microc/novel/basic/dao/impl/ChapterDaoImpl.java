package com.microc.novel.basic.dao.impl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microc.novel.basic.dao.ChapterDao;
import com.microc.novel.basic.mapper.BooksMapper;
import com.microc.novel.basic.mapper.ChapterMapper;
import com.microc.novel.basic.model.Chapter;
import com.microc.novel.basic.model.db.DBBooks;
import com.microc.novel.basic.model.db.DBChapter;
import com.microc.novel.basic.util.Generator;


@Repository
public class ChapterDaoImpl implements ChapterDao {

	@Autowired
	private ChapterMapper mapper;
	
	@Autowired
	private BooksMapper booksMapper;
	
	@Override
	public int insert(Chapter chapter) {
		chapter.setId((String) Generator.generate());
		DBBooks books = booksMapper.findById(chapter.getBookId());
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(books.getFilePath(), "w");
			long position = file.length();
			if(chapter.getContent() != null) {
				file.seek(position);
				file.write(chapter.getContent().getBytes());
			}
			long length = file.length() - position;
			return mapper.insert(objectToDB(chapter, (int)position, (int)length));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(file != null)
					file.close();
			} catch (IOException e) { }
		}
	}

	@Override
	public int delete(String id) {
		return mapper.delete(id);
	}

	@Override
	public int update(Chapter chapter) {
		DBBooks books = booksMapper.findById(chapter.getBookId());
		DBChapter dbChapter = mapper.findById(chapter.getId());
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(books.getFilePath(), "w");
			long position = file.length(), length = 0;
			if(chapter.getContent() != null) {
				length = chapter.getContent().getBytes().length;
				if(length <= dbChapter.getLength()) {
					position = dbChapter.getPosition();
				}
			}
			file.seek(position);
			file.write(chapter.getContent().getBytes());
			return mapper.update(objectToDB(chapter, (int)position, (int)length));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(file != null)
					file.close();
			} catch (IOException e) { }
		}
	}

	@Override
	public Chapter findById(String id) {
		DBChapter dbChapter = mapper.findById(id);
		DBBooks books = booksMapper.findById(dbChapter.getBookId());
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(books.getFilePath(), "r");
			String content = null;
			if(dbChapter.getLength() != null && dbChapter.getLength() != 0) {
				byte[] data = new byte[(int)dbChapter.getLength()];
				file.seek(dbChapter.getPosition());
				file.read(data);
				content = new String(data);
			}
			return dbToObject(dbChapter, content);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(file != null)
					file.close();
			} catch (IOException e) { }
		}
	}

	@Override
	public List<Chapter> list(String bookId, Integer skip, Integer size) {
		List<DBChapter> dbList = mapper.listByBooks(bookId, skip, size);
		List<Chapter> list = new ArrayList<Chapter>(dbList.size());
		DBBooks books = booksMapper.findById(bookId);
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(books.getFilePath(), "r");
			for (DBChapter dbChapter : dbList) {
				String content = null;
				if(dbChapter.getLength() != null && dbChapter.getLength() != 0) {
					byte[] data = new byte[(int)dbChapter.getLength()];
					file.seek(dbChapter.getPosition());
					file.read(data);
					content = new String(data);
				}
				list.add(dbToObject(dbChapter, content));
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(file != null)
					file.close();
			} catch (IOException e) { }
		}
		return list;
	}
	
	public DBChapter objectToDB(Chapter chapter, Integer position, Integer length) {
		DBChapter dbChapter = new DBChapter();
		dbChapter.setId(chapter.getId());
		dbChapter.setName(chapter.getName());
		dbChapter.setBookId(chapter.getBookId());
		dbChapter.setPosition((int)position);
		dbChapter.setLength((int)length);
		dbChapter.setIndex(chapter.getIndex());
		return dbChapter;
	}
	
	public Chapter dbToObject(DBChapter dbChapter, String content) {
		Chapter chapter = new Chapter();
		chapter.setId(dbChapter.getId());
		chapter.setName(dbChapter.getName());
		chapter.setBookId(dbChapter.getBookId());
		chapter.setContent(content);
		chapter.setIndex(dbChapter.getIndex());
		return chapter;
	}

}
