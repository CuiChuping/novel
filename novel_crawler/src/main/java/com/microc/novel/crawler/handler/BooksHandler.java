package com.microc.novel.crawler.handler;

import java.util.ArrayList;
import java.util.List;

import com.microc.novel.basic.model.Books;
import com.microc.novel.crawler.utils.HttpUtil;
import com.microc.novel.crawler.utils.MatcherUtil;

import static com.microc.novel.crawler.consts.Constants.*;


public class BooksHandler {
	
	public static void main(String[] args) throws Exception {
		buildBooks("玄幻小说", 1);
		// getPageCount("玄幻小说");
	}
	
	/**
	 * 获取指定分类指定页面的书籍信息
	 * @param category
	 * @param pageNum
	 * @return
	 */
	public static List<Books> buildBooks(String category, int pageNum) {
		List<Books> bookList = new ArrayList<Books>();
		String content = HttpUtil.loadUrlToString(getUrl(category, pageNum));
		if(content != null) {
			List<String[]> bookInfos = MatcherUtil.subGroup(content, PAGE_CATEGORY_RGE);
			for (int i = 0; i < bookInfos.size(); i++) {
				String bookName = explainProtocols(bookInfos.get(i), BOOK_NAME);
				String author = explainProtocols(bookInfos.get(i), BOOK_AUTHOR);
				String wordCount = explainProtocols(bookInfos.get(i), WORD_COUNT);
				String bookDesc = explainProtocols(bookInfos.get(i), BOOK_DESC);
				String bookImage = explainProtocols(bookInfos.get(i), BOOK_IMAGE);
				if(bookImage != null && !bookImage.startsWith("http://")) {
					bookImage = BASE_URL + bookImage;
				}
				Books books = new Books();
				books.setName(bookName);
				books.setAuthor(author);
				books.setDesc(bookDesc);
				books.setWordCount(wordToInt(wordCount));
				books.setCategoryId(category);
				books.setImagePath(bookImage);
				System.out.println(books);
				bookList.add(books);
			}
		}
		return bookList;
	}
	
	/**
	 * 解析查找协议，获取本页面或重定向页面指定的值
	 * @param content 当前页面的匹配值
	 * @param protocols 查找协议
	 * @return
	 */
	public static String explainProtocols(String[] content, String protocols) {
		if("none".equals(protocols)) {
			return null;
		}
		String[] cmdBlock = protocols.split(" ");
		if("this_page".equals(cmdBlock[0])) {
			return content[$ToInt(cmdBlock[1])];
		}
		if("other_page".equals(cmdBlock[0])) {
			String ctn = HttpUtil.loadUrlToString(content[$ToInt(cmdBlock[1])]);
			return MatcherUtil.subGroup(ctn, cmdBlock[2]).get(0)[$ToInt(cmdBlock[3])];
		}
		return null;
	}
	
	/**
	 * 获取当前分类的页数
	 * @param category
	 * @return
	 */
	public static int getPageCount(String category) {
		String content = HttpUtil.loadUrlToString(getUrl(category, 1));
		String pageCount = MatcherUtil.subGroup(content, LAST_PAGE_NUM).get(0)[0];
		return Integer.parseInt(pageCount == null ? "0" : pageCount);
	}
	
	/**
	 * 获取指定分类制定页面的URL
	 * @param category
	 * @param pageNum
	 * @return
	 */
	public static String getUrl(String category, int pageNum) {
		return CATEGORY_URL.get(category).replace("{pageNum}", pageNum+"");
	}
	
	/**
	 * 查找协议到下标
	 * @param $str
	 * @return
	 */
	private static Integer $ToInt(String $str) {
		return Integer.parseInt($str.substring(1)) - 1;
	}
	
	/**
	 * 文字字数到数字
	 * 100 -> 100
	 * 10K -> 10000
	 */
	private static Long wordToInt(String wordCount) {
		try {
			return Long.valueOf(wordCount);
		} catch (Exception e) {
			if(wordCount.endsWith("K") || wordCount.endsWith("k")) {
				return Long.valueOf(wordCount.substring(0, wordCount.length() - 1)) * 1000;
			}
		}
		return 0L;
	}
	
}
