package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String, Book> books = DB.getAll();
		out.write("本网站有如下商品：<br/>");
		for(Map.Entry<String, Book> e : books.entrySet()) {
			Book book = e.getValue();
			out.write(book.getName() + "<a href=/cart/BuyServlet?id="+book.getId()+">购买</a>");
//			out.write(book.getName() + "<a href=/cart/DetailServlet?id="+book.getId()+">购买</a>");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

class DB {
	private static Map<String, Book> books = new HashMap<String, Book>();
	static {
		books.put("1", new Book("1", "javaweb", 10, "一本好书"));
		books.put("2", new Book("2", "spring", 10, "一本好书"));
		books.put("3", new Book("3", "tomcat", 10, "一本好书"));
		books.put("4", new Book("4", "springMVC", 10, "一本好书"));
		books.put("5", new Book("5", "Hibernate", 10, "一本好书"));
	}
	public static Map<String, Book> getAll() {
		return books;
	}
}

class Book {
	private String id;
	private String name;
	private double price;
	private String description;
	
	public Book() {
		super();
	}
	public Book(String id, String name, double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}