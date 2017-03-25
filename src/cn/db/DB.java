package cn.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.domain.Book;

public class DB {
	private static Map<String, Book> map = new LinkedHashMap<String, Book>();
	static {
		map.put("1", new Book("1", "javaweb开发", "老方", 39.9, "一本好书"));
		map.put("2", new Book("2", "jdbc", "老方", 29.9, "一本好书"));
		map.put("3", new Book("3", "hibernate开发", "老方", 40, "一本好书"));
		map.put("4", new Book("4", "strtus开发", "老方", 40, "一本好书"));
		map.put("5", new Book("5", "spring开发", "老方", 50, "一本好书"));
		map.put("6", new Book("6", "jsp开发", "老方", 39.9, "一本好书"));
		map.put("7", new Book("7", "servlet开发", "老方", 23, "一本好书"));
		map.put("8", new Book("8", "JavaSE开发", "老方", 30, "一本好书"));
	}
	
	public static Map<String, Book> getAllBook() {
		return map;
	}

	public static Book findBook(String id) {
		return map.get(id);
	}
}
