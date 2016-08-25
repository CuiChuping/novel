package com.microc.novel.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microc.novel.basic.model.db.DBChapter;

public interface ChapterMapper {

	int insert(DBChapter chapter);
	
	int delete(String id);
	
	int update(DBChapter chapter);
	
	DBChapter findById(String id);
	
	List<DBChapter> listByBooks(@Param("bookId") String bookId, @Param("skip") Integer skip, @Param("length") Integer length);
	
}
