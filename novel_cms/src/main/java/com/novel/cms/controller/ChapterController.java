package com.novel.cms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.microc.novel.basic.model.Chapter;
import com.novel.cms.service.ChapterService;

@Controller
public class ChapterController {
	
	@Resource
	private ChapterService service;
	
	/**
	 * 章节列表
	 * @param chapter
	 * @return
	 */
	@RequestMapping(value = "/chapter", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findCategory(ModelMap modelMap, String bookId, HttpSession session) throws Exception {
		List<Chapter> chapters = service.findAll(bookId);
		modelMap.addAttribute("chapters", chapters);
		session.setAttribute("bookId", bookId);
		return new ModelAndView("/chapter/chapter", modelMap);
	}
	
	/**
	 * put
	 * @param chapter
	 * @return
	 */
	@RequestMapping(value = "/chapter", method ={RequestMethod.PUT})
	public ModelAndView put(ModelMap modelMap, String[] marked) throws Exception {
		if(marked!=null && marked.length>0){
			modelMap.put("chapter", service.findById(marked[0]));
			//edit
			return new ModelAndView("/chapter/edit", modelMap);
		}
		// add 
		return new ModelAndView("/chapter/add", modelMap);
	}
	
	/**
	 * 添加
	 * @param chapter
	 * @return
	 */
	@RequestMapping(value = "/chapter/add", method ={RequestMethod.POST})
	public @ResponseBody boolean add(Chapter chapter) throws Exception {
		try {
			service.add(chapter);
			return true;
		} catch (Exception e) {e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 编辑
	 * @param chapter
	 * @return
	 */
	@RequestMapping(value = "/chapter/edit", method ={RequestMethod.POST})
	public @ResponseBody boolean edit(Chapter chapter) throws Exception {
		try {
			service.update(chapter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 删除
	 * @param chapter
	 * @return
	 */
	@RequestMapping(value = "/chapter", method ={RequestMethod.DELETE})
	public @ResponseBody boolean delete(String[] marked) throws Exception {
		try {
			service.delete(marked);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
