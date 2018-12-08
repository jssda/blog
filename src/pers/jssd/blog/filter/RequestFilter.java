package pers.jssd.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter(filterName = "all",
	urlPatterns = "/*",
	initParams = {
	@WebInitParam(name = "exclude", value = "/index.jsp,/ValidateImageServlet,/LoginServlet"),
	@WebInitParam(name = "ignoreType", value = "gif,bmp,png,jpg,css,js")
})
public class RequestFilter implements Filter {

	String[] values = null;
	String[] ignoreTypes = null;
    /**
     * Default constructor. 
     */
    public RequestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest HttpRequest = (HttpServletRequest) request;
		HttpServletResponse HttpResponse = (HttpServletResponse) response;
		HttpRequest.setCharacterEncoding("utf-8");
		HttpResponse.setContentType("text/html; charset=utf-8");
		boolean flag = false;
		boolean isIgnore = false;
		
		String url = HttpRequest.getServletPath();
		if(ignoreTypes != null) {
			for(int i = 0; i < ignoreTypes.length; i ++) {
				if(url.endsWith("." + ignoreTypes[i])) {
					isIgnore = true;
					System.out.println("过滤: " + ignoreTypes[i]);
					break;
				}
			}
		} else {
			chain.doFilter(HttpRequest, HttpResponse);
		}
		
		for(String temp : values) {
			if(temp.equals(HttpRequest.getServletPath()))
				flag = true;
		}
		
		if(flag || isIgnore) {
			chain.doFilter(request, response);
		}else {
			System.out.println(HttpRequest.getServletPath());
			if(HttpRequest.getSession().getAttribute("loginId") != null && 
					!HttpRequest.getSession().getAttribute("loginId").equals("")) {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {
				HttpResponse.sendRedirect("/blog/index.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		values = fConfig.getInitParameter("exclude").split(",");
		if(fConfig.getInitParameter("ignoreType") != null && !fConfig.getInitParameter("ignoreType").trim().equals(""))
			ignoreTypes = fConfig.getInitParameter("ignoreType").split(",");
	}

}
