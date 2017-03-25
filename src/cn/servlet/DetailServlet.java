package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		String bookHistory = null; 
		String cookievalue = null;
		String id = request.getParameter("id");
		Book book = DB.getAll().get(id);
		
		out.write(book.getName() + " " + book.getPrice() + " " + book.getDescription());
		
		Cookie[] cookie = request.getCookies();
		for(int i=0;i<cookie.length&&cookie!=null;i++) {
			if(cookie[i].getName().equals("bookHistory")) {
				bookHistory = cookie[i].getValue();
			}
		}
		if(bookHistory == null) {
			cookievalue = id;
		} else {
		String[] cutArray = bookHistory.split("\\#");
		List<String> cutList = Arrays.asList(cutArray);
		LinkedList<String> list = new LinkedList<String>(cutList);
		if(list.contains(id)) {
			list.remove(id);
		} else {
			if(list.size()>=3) {
				list.removeLast();
			}
		}
		list.addFirst(id);
		
		StringBuffer sb = new StringBuffer();
		for(String s : list) {
			sb.append(s).append("#");
		}
		cookievalue = sb.deleteCharAt(sb.length()-1).toString();	
		}
		System.out.println(cookievalue);
		
		Cookie c = new Cookie("bookHistory", cookievalue);
		c.setMaxAge(24*3600);
		c.setPath("/cart");
		response.addCookie(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
