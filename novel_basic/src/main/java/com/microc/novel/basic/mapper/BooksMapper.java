package com.microc.novel.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.microc.novel.basic.model.Suggestion;
import com.microc.novel.basic.model.db.DBBooks;


public interface BooksMapper {

	int insert(DBBooks books);
	
	int delete(String id);
	
	int update(DBBooks books);
	
	DBBooks findById(String id);
	
	List<DBBooks> listByCategory(@Param("categoryId") String categoryId, @Param("name") String name, @Param("skip") Integer skip, @Param("length") Integer length);

	int countByCategory(@Param("categoryId") String category, @Param("name") String name);

	//提交意见反馈
	void suggestionSubmit(Suggestion suggestion);
	
}
