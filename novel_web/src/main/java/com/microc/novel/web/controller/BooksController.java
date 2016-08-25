package com.microc.novel.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.util.Pager;
import com.microc.novel.web.service.BooksService;


@Controller
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	@RequestMapping("/books")
	public String home() {
		return "books/list";
	}
	
	@RequestMapping("/books/fragment")
	public String loadPager(Pager<Books> pager, String category, String name, ModelMap map) {
		booksService.find(pager, category, name);
		map.put("pager", pager);
		map.put("category", category);
		map.put("name", name);
		return "books/fragment";
	}
	
	@RequestMapping("/books/detail")
	public String detail(String id, HttpServletRequest request, ModelMap map) {
		map.put("books", booksService.findById(id));
		return "books/detail";
	}
	
}
