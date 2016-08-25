package com.microc.novel.crawler.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {

	public static List<String[]> subGroup(String content, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		List<String[]> list = new ArrayList<>();
		while(matcher.find()) {
			String[] row = new String[matcher.groupCount()];
			for (int i = 0; i < row.length; i++) {
				row[i] = matcher.group(i + 1);
			}
			list.add(row);
		}
		return list;
	} 
	
}
