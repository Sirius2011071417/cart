package cn.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
	private double price;
	
	
	
	public Map<String, CartItem> getMap() {
		return map;
	}



	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}



	public double getPrice() {
		double totalprice = 0;
		for(Map.Entry<String, CartItem> entry: map.entrySet()) {
			CartItem item = entry.getValue();
			totalprice += item.getPrice();
		}
		this.price = totalprice;
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public void add(Book book) {
		CartItem item = map.get(book.getId());
		if(item==null) {
			map.put(book.getId(), new CartItem(book, 1));
		} else {
			item.setQuartity(item.getQuartity() + 1);
		}
	}
}
