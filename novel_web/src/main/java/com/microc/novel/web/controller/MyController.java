package com.microc.novel.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microc.novel.web.service.MyService;


@Controller
public class MyController {

	@Autowired
	private MyService myService;
	
	@RequestMapping("/my")
	public String my() {
		return "my/my";
	}
	
	@RequestMapping("my/suggestion")
	public String suggestion() {
		return "my/suggestion";
	}
	
	@RequestMapping("my/suggestionSubmit")
	public String suggestionSubmit(HttpServletRequest request, String contactWay, String suggestion) {
		//后期可添加获取更多信息
		
		myService.suggestionSubmit(contactWay, suggestion);
		System.err.println("sdsd");
		return "my/my";
	}
	
	@RequestMapping("my/callus")
	public String callus() {
		return "my/callus";
	}
	
	@RequestMapping("my/aboutSoftWare")
	public String aboutSoftWare() {
		return "my/aboutSoftWare";
	}
	
	@RequestMapping("my/relief")
	public String relief() {
		return "my/relief";
	}
	
}
