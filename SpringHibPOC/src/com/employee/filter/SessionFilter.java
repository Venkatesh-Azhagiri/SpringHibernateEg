package com.employee.filter;

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
import javax.servlet.http.HttpSession;

import com.employee.base.model.UserModel;

/**
 * Servlet Filter implementation class SessionFilter
 */

public class SessionFilter implements Filter {
	//public UserModel userModel;
    /**
     * Default constructor. 
     */
    public SessionFilter() {
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
		Object user = null;
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);
		if(session != null){
			user= session.getAttribute("user");
		}
		System.out.println("user*********"+user);
		System.out.println("url****"+((HttpServletRequest) request).getRequestURL().toString());
		if(user == null &&  !(((HttpServletRequest) request).getRequestURL().toString().contains("/SpringHibPOC/index.do"))
				&&!(((HttpServletRequest) request).getRequestURL().toString().matches(".*(css|jpg|png|gif|js)"))){
			System.out.println("user filter if");
			((HttpServletResponse) response).sendRedirect("index.do");
		}else{
			System.out.println("user filter after if");
			//pass the request along the filter chain
			chain.doFilter(request, response);
		}
		System.out.println("filter travel end");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/*public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}*/
}
