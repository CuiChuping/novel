package com.microc.novel.crawler.consts;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public interface Constants {
	
	String DEFAULT_CHARSET = "GBK";
	
	Map<String, String> CATEGORY_URL = new HashMap<String, String>(){{
		put("玄幻小说", "http://www.lingdiankanshu.com/s_1/{pageNum}/");
		put("修真小说", "http://www.lingdiankanshu.com/s_2/{pageNum}/");
		put("都市小说", "http://www.lingdiankanshu.com/s_3/{pageNum}/");
		put("穿越小说", "http://www.lingdiankanshu.com/s_4/{pageNum}/");
		put("网游小说", "http://www.lingdiankanshu.com/s_5/{pageNum}/");
		put("科幻小说", "http://www.lingdiankanshu.com/s_6/{pageNum}/");
		put("其他小说", "http://www.lingdiankanshu.com/s_7/{pageNum}/");
	}};
	
	//***************************************** Books 相关信息 *************************************************
	
	String BASE_URL = "http://www.lingdiankanshu.com";
	
	String PAGE_CATEGORY_RGE = "<tr>\\s*?<td class=\"odd\"><a\\shref=\"([\\w:/\\.]*?)\"(?:\\starget=\".*?\")?>(.*?)</a></td>\\s*?<td class=\"even\"><a\\shref=\"([\\w:/\\.]*?)\"(?:\\starget=\".*?\")?>(.*?)</a></td>\\s*?<td class=\"odd\">(.*?)</td>\\s*?<td class=\"even\">(.*?)</td>\\s*?<td class=\"odd\" align=\"center\">(.*?)</td>\\s*?<td class=\"even\" align=\"center\">(.*?)</td>\\s*?</tr>";
	
	// 协议类型                           $索引         [next匹配规则   $next索引]
	// none
	// this_page    $1
	// other_page   $1      regex       $1
	
	String BOOK_NAME = "this_page $2";
	
	String BOOK_AUTHOR = "this_page $5";
	
	String WORD_COUNT = "this_page $6";
	
	String BOOK_DESC = "other_page $1 <div\\sid=\"intro\">([\\w\\W]*?)</div> $1";
	
	String BOOK_IMAGE = "other_page $1 <img\\salt=\".*?\"\\ssrc=\"([\\w:\\./-]*?)\"\\swidth=\"120\"\\sheight=\"150\"\\s/> $1";
	
	String LAST_PAGE_NUM = "class=\"last\">(\\d*?)</a>";
	
}
