package com.novel.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.novel.cms.service.LoginService;

@Controller
public class LoginController {

	@Resource
	private LoginService service;
	
	/**
	 * 登陆
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/login", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(ModelMap modelMap) throws Exception {
		return new ModelAndView("/login/login", modelMap);
	}

	/**
	 * 小说列表
	 * @param novel
	 * @return
	 */
	@RequestMapping(value = "/confirmLogin", method ={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView novelList(ModelMap modelMap, String id, String password) throws Exception {
		boolean flag = service.login(id, password);
		if(flag){
			return new ModelAndView("redirect:/novel");
		}else{
			return new ModelAndView("/login/login", modelMap);
		}
	}
}
