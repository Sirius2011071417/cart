package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteLastDateServlet
 */
@WebServlet("/DeleteLastDateServlet")
public class DeleteLastDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLastDateServlet() {
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
		//第一个版本
		/*Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length&&cookies!=null;i++) {
			if(cookies[i].getName().equals("lastdate")) {
				cookies[i].setMaxAge(0);
				cookies[i].setPath("/cart");
				response.addCookie(cookies[i]);
			}
		}*/
		//第二个版本
		Cookie cookie = new Cookie("lastdate", System.currentTimeMillis()+"");
		cookie.setMaxAge(0);
		cookie.setPath("/cart");
		response.addCookie(cookie);
		out.write("你已删除最近来访记录！");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
