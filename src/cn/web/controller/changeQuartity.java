package cn.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Cart;
import cn.service.BusinessService;

/**
 * Servlet implementation class changeQuartity
 */
@WebServlet("/changeQuartity")
public class changeQuartity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeQuartity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String id = request.getParameter("id");
		String  quartity= request.getParameter("quartity");
		BusinessService service = new BusinessService();
		Map<String, String> errors = new HashMap<String, String>();
		int q;
		try {
			q = Integer.parseInt(quartity);
			if(q <= 0) {
//				errors.put("NaN", "请输入一个正整数！！！");
				throw new NumberFormatException();
			}
			service.changeQuartity(cart, id, quartity);
		} catch (NumberFormatException e) {
			errors.put("NaN", "请输入一个正整数！！！");
			request.setAttribute("errors", errors);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/listCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
