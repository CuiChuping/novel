package com.microc.novel.crawler.utils;

import static com.microc.novel.crawler.consts.Constants.DEFAULT_CHARSET;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpUtil {

	private final static String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static String loadUrlToString(String sUrl) {
		try {
			URL url = new URL(sUrl);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), DEFAULT_CHARSET));
			StringBuilder result = new StringBuilder();
			for (String temp; (temp = reader.readLine()) != null; ) {
				result.append(temp).append(LINE_SEPARATOR);
			}
			return result.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
}
