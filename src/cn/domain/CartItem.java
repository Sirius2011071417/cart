package cn.domain;

public class CartItem {
	private Book book;
	private double price;
	private int quartity;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Book book, int quartity) {
		super();
		this.book = book;
		this.quartity = quartity;
		this.price = this.quartity * this.book.getPrice();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuartity() {
		return quartity;
	}
	public void setQuartity(int quartity) {
		this.quartity = quartity;
		this.price = this.quartity * this.book.getPrice();
	}
	
}
