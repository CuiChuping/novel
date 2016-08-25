package com.novel.cms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.microc.novel.basic.model.Books;
import com.microc.novel.basic.model.Category;
import com.novel.cms.service.CategoryService;
import com.novel.cms.service.NovelService;

@Controller
public class NovelController {
	
	@Resource
	private NovelService service;
	
	@Resource
	private CategoryService categoryService;
	
	/**
	 * 小说列表
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/novel", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findCategory(String cateGoryId, HttpSession session, ModelMap modelMap) throws Exception {
		List<Books> books = service.findAll(cateGoryId);
		List<Category> categorys = categoryService.findAll();
		if(cateGoryId != null){
			for(Category cate : categorys){
				if(cate.getId().equals(cateGoryId)){
					session.setAttribute("categoryName",cate.getName());
				}
			}
		}
		modelMap.addAttribute("books", books);
		session.setAttribute("categorys", categorys);
		return new ModelAndView("/novel/novelList", modelMap);
	}
	
	/**
	 * put
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/novel", method ={RequestMethod.PUT})
	public ModelAndView put(ModelMap modelMap, String[] marked) throws Exception {
		if(marked!=null && marked.length>0){
			modelMap.put("novel", service.findById(marked[0]));
			//edit
			return new ModelAndView("/novel/edit", modelMap);
		}
		// add 
		return new ModelAndView("/novel/add", modelMap);
	}
	
	/**
	 * 添加
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/books/add", method ={RequestMethod.POST})
	public @ResponseBody boolean add(Books Books, @RequestParam(required=false, value="image")MultipartFile file ) throws Exception {
		try {
			service.add(Books, file);
			return true;
		} catch (Exception e) {e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 编辑
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/books/edit", method ={RequestMethod.POST})
	public @ResponseBody boolean edit(Books Books, @RequestParam(required=false, value="imageEdit")MultipartFile file) throws Exception {
		try {
			service.update(Books, file);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 删除
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/novel", method ={RequestMethod.DELETE})
	public @ResponseBody boolean delete(String[] marked) throws Exception {
		try {
			service.delete(marked);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
