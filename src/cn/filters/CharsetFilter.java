package cn.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharsetFilter
 */
@WebFilter("/CharsetFilter")
public class CharsetFilter implements Filter {

	 private FilterConfig config = null;
    public CharsetFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		config = null;
		System.out.println("CharsetFilter准备销毁----");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding(config.getInitParameter("charset"));
		res.setCharacterEncoding(config.getInitParameter("charset"));
		res.setHeader("Content-Type", config.getInitParameter("contenttype"));
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
		System.out.println("CharsetFilter初始化----");
	}

}
