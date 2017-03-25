package cn.dao;

import java.util.Map;

import cn.db.DB;
import cn.domain.Book;

public class BookDao {
	public Map<String, Book> getAllBook() {
		return DB.getAllBook();
	}
	public Book findBook(String id) {
		return DB.findBook(id);
	}
}
