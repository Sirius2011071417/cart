package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowLastDateServlet
 */
@WebServlet("/ShowLastDateServlet")
public class ShowLastDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLastDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		
		out.write("<a href='/cart/DeleteLastDateServlet'>删除上次访问时间</a>");
		out.write("您上次的访问时间是:");
		Cookie[] cookie = request.getCookies();
		for(int i=0;i<cookie.length&&cookie!=null;i++) {
			if(cookie[i].getName().equals("lastdate")) {
				long cookievalue = Long.parseLong(cookie[i].getValue());
				Date date = new Date(cookievalue);
				out.write(date.toString());
			}
		}
		
		Cookie c = new Cookie("lastdate", System.currentTimeMillis()+"");
		c.setMaxAge(60*60);
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
