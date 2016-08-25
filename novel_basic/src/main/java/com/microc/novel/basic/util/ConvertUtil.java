package com.microc.novel.basic.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author cuichuping
 *
 */
public class ConvertUtil {
	
	public static <T> Map<Object, T> listToMap(List<T> list, String key) {
		Map<Object, T> map = new LinkedHashMap<>();
		if(list.isEmpty()) return map;
		Class<?> clazz = list.get(0).getClass();
		try {
			Method method = new PropertyDescriptor(key, clazz).getReadMethod();
			for (T object : list) {
				map.put(method.invoke(object), object);
			}
		} catch (IntrospectionException e) {
			throw new RuntimeException("field ["+key+"] not found", e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return map;
	}
	
}
