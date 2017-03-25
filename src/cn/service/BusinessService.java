package cn.service;

import java.util.Map;

import cn.dao.BookDao;
import cn.domain.Book;
import cn.domain.Cart;

public class BusinessService {
	
	BookDao dao = new BookDao();
	public Map<String, Book> getAllBook() {
		return dao.getAllBook();
	}
	public Book findBook(String id) {
		return dao.findBook(id);
	}
	public void deleteItem(String id, Cart cart) {
		cart.getMap().remove(id);
	}
	public void clearCart(Cart cart) {
		cart.getMap().clear();
	}
	public void changeQuartity(Cart cart, String id, String quartity) {
		cart.getMap().get(id).setQuartity(Integer.parseInt(quartity));
	}

}
