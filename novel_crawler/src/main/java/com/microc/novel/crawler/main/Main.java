package com.microc.novel.crawler.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microc.novel.crawler.consts.Constants;
import com.microc.novel.crawler.service.BooksService;

public class Main {

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath*:/beans/*");
		BooksService booksService = applicationContext.getBean(BooksService.class);
		for(String category : Constants.CATEGORY_URL.keySet()) {
			booksService.crawler(category);
			System.out.println("正在启动 " + category);
		}
		System.out.println("爬虫启动完毕");
		applicationContext.close();
	}
}
