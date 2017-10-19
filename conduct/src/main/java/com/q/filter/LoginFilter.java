package com.q.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;  
	        HttpServletResponse res = (HttpServletResponse) response;  
	        // 判断当前session是否有用户信息  
	        String url = req.getServletPath();
	        if(req.getSession().getAttribute("user") == null && url.equals("/conduct/login.jsp") ) {  
	            res.sendRedirect(req.getContextPath() + "/login.jsp");
	            return;
	        }  
	        chain.doFilter(request, response);  
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
