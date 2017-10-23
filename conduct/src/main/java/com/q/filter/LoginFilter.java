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

import com.q.model.TbUser;

/**
 * ������
 * ��������ʱ��֤�Ƿ��Ѿ���¼
 * @author Qloud
 * */
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;  
	        HttpServletResponse res = (HttpServletResponse) response;  
	        // �жϵ�ǰsession�Ƿ����û���Ϣ  
	        String url = req.getServletPath();
	        // ��������������
	        if((url.indexOf("/login.jsp")>-1)||(url.indexOf("css")>-1)||(url.indexOf("images")>-1)||(url.indexOf("mp4")>-1)
	        		||(url.indexOf("login")>-1)||url.indexOf("/userRegister.jsp")>-1||url.indexOf("/forget.jsp")>-1
	        		||url.indexOf("/check")>-1){
				chain.doFilter(req, res);
				return;
			}
	        if(req.getSession().getAttribute("userLogin") == null){  
	            res.sendRedirect(req.getContextPath() + "/login.jsp");
	            return;
	        }else{
	        	TbUser user = (TbUser) req.getSession().getAttribute("userLogin");
	        	if(user.getStatues() == 1 && (url.indexOf("/userList.jsp")>-1 || url.indexOf("/admin.jsp")>-1 ||
	        			url.indexOf("/userInfo.jsp")>-1)){
	        		res.sendRedirect(req.getContextPath() + "/main.jsp");
	        	}else{
	        		chain.doFilter(req, res);
	        	}
	        }  
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
