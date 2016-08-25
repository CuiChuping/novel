package com.microc.novel.basic.util;

import java.util.HashMap;
import java.util.Map;

public class BT {

	public static final String EMPTY = "";

	public static final int ZERO = 0;

	public interface BaseType<T> {

		public boolean isEmpty(final T value);

		public T parse(final Object value);

		public T nullToEmpty(final T value);
	}

	public static final BaseType<String> STRING = new BaseType<String> () {

		public final boolean isEmpty(final String value) {
			return value == null || value.length() == 0;
		}

		public String nullToEmpty(final String value) {
			return value == null ? EMPTY : value;
		}

		public String parse(final Object value) {
			if(value == null) return EMPTY;
			if (value instanceof String) return (String)value;
			return value.toString();
		}
	};

	public static final BaseType<Boolean> BOOLEAN = new BaseType<Boolean> () {

		public boolean isEmpty(Boolean value) {
			return value == null || !value;
		}

		public Boolean nullToEmpty(Boolean value) {
			return value == null ? false : value;
		}

		public Boolean parse(Object value) {
			if(value == null) return false;
			if (value instanceof Boolean) return (Boolean)value;
			return Boolean.parseBoolean(value.toString()) || "1".equals(value.toString());
		}
	};

	public static final BaseType<Integer> INTEGER = new BaseType<Integer> () {

		public boolean isEmpty(Integer value) {
			return value == null || value == ZERO;
		}

		public Integer nullToEmpty(Integer value) {
			return value == null ? ZERO : value;
		}

		public Integer parse(Object value) {
			if(value == null) return ZERO;
			if (value instanceof Integer) return (Integer)value;
			if (value instanceof Number) return ((Number)value).intValue();
			return Integer.parseInt(value.toString());
		}
	};

	public static final BaseType<Long> LONG = new BaseType<Long> () {

		public boolean isEmpty(Long value) {
			return value == null || value == ZERO;
		}

		public Long nullToEmpty(Long value) {
			return value == null ? (long)ZERO : value;
		}

		public Long parse(Object value) {
			if(value == null) return (long)ZERO;
			if (value instanceof Long) return (Long)value;
			if (value instanceof Number) return ((Number)value).longValue();
			return Long.parseLong(value.toString());
		}
	};

	public static final BaseType<Double> DOUBLE = new BaseType<Double> () {

		public boolean isEmpty(Double value) {
			return value == null || value == ZERO;
		}

		public Double nullToEmpty(Double value) {
			return value == null ? (double)ZERO : value;
		}

		public Double parse(Object value) {
			if(value == null) return (double)ZERO;
			if (value instanceof Double) return (Double)value;
			if (value instanceof Number) return ((Number)value).doubleValue();
			return Double.parseDouble(value.toString());
		}
	};

	public static boolean contain(String type) {
		String t = type.toUpperCase();
		return !STRING.isEmpty(t) && map.containsKey(t);
	}

	public static BaseType<?> get(String type) {
		String t = type.toUpperCase();
		return contain(t) ? map.get(t) : STRING;
	}

	public static boolean contain(Class<?> clazz) {
		String t = clazz.getSimpleName().toUpperCase();
		return map.containsKey(t);
	}

	public static BaseType<?> get(Class<?> clazz) {
		String t = clazz.getSimpleName().toUpperCase();
		return map.containsKey(t) ? map.get(t) : STRING;
	}

	public static boolean eq(BaseType<?> bt, Class<?> clazz) {
		String t = clazz.getSimpleName().toUpperCase();
		return map.containsKey(t)? bt.equals(map.get(t)) : false;
	}

	public static <T> boolean isEmpty(BaseType<T> bt, Object o) {
		return bt.isEmpty(bt.parse(o));
	}

	private static Map<String, BaseType<?>> map = new HashMap<String, BaseType<?>>();

	static {
		map.put("STRING", STRING);
		map.put("BOOLEAN", BOOLEAN);
		map.put("INT", INTEGER);
		map.put("INTEGER", INTEGER);
		map.put("LONG", LONG);
		map.put("DOUBLE", DOUBLE);
	}
}