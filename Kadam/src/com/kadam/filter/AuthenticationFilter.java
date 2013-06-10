package com.kadam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
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
		HttpServletRequest request1 = (HttpServletRequest) request;
	    HttpSession session = request1.getSession();	
	    
	    RequestDispatcher dispatcher1 = request1.getRequestDispatcher("login.jsp");
	    
	    if(session.isNew()){
	    	 session.setAttribute("username","new");
	 		dispatcher1.forward(request, response);

	    	 System.out.println("in filter a new session");
	    }else{
	    	 System.out.println("in filter a old"+session.getAttribute("username"));

	    	if(session.getAttribute("username").equals("new")){
	    		dispatcher1.forward(request, response);

	 		    System.out.println("in filter old session");

	 	    }
	    }
	   
	    System.out.println("in filter");


		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}