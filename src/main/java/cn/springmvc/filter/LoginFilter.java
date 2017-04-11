package cn.springmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		System.out.println(request.getRemoteAddr());
		String requestURI = httpRequest.getRequestURI().replace(httpRequest.getContextPath()+"/", "");
		if(!requestURI.equals("login.jsp")){
			HttpSession session = httpRequest.getSession();
			if(session.getAttribute("username")==null){
				session.setAttribute("msg", "您还没有登录");
				httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
				return;
			}
		}
		
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
