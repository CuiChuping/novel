package com.microc.novel.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microc.novel.basic.model.Books;
import com.microc.novel.web.service.ShelfService;

@Controller
public class ShelfController {

	@Autowired
	private ShelfService shelfService;
	
	@RequestMapping("/shelf")
	public String shelf(HttpServletRequest request, ModelMap map) {
		List<Books> booksList = shelfService.findShelfBooks(request);
		map.put("booksList", booksList);
		return "shelf/list";
	}
	
}
