package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ScanServlet
 */
@WebServlet("/ScanServlet")
public class ScanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String, Book> books = DB.getAll();
		out.write("本网站有如下商品:<br/>");
		for(Map.Entry<String, Book> e : books.entrySet()) {
			Book book = e.getValue();
			out.write(book.getName() + "<a href='/cart/DetailServlet?id="+book.getId()+"'>详情</a>");
		}
		
		out.write("你浏览过的商品:<br/>");
		Cookie[] cookie = request.getCookies();
		for(int i=0;i<cookie.length&&cookie!=null;i++) {
			if(cookie[i].getName().equals("bookHistory")) {
				String[] ids = cookie[i].getValue().split("\\#");
				for(String id : ids) {
					Book b = DB.getAll().get(id);
					out.write(b.getName());
				}
			}
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