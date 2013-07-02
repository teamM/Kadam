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
		/*
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request1 = (HttpServletRequest) request;
	    HttpSession session = request1.getSession();	
	    /////////////////////////////////////////////////////////
	    ServletRequest request_original=request;
	    ServletResponse response_original=response;
	    /////////////////////////////////////////////////
	    
	    RequestDispatcher dispatcher1 = request1.getRequestDispatcher("/main_pages/login.jsp");
	    
	    int frwd=0;
	    System.out.println("in filter");
	    if(session.isNew()){
	    	System.out.println("in new session");
	    	 session.setAttribute("username","new");
	    	 System.out.println("in filter a new session");
	    	 frwd=1;
	    }else if(session.getAttribute("username").equals("new")){
	    	System.out.println("in old session");
	    	 frwd=1;
	 	    }
	    
	    if(frwd==0){
	    	System.out.println("chaining");
	    	chain.doFilter(request, response);
	    }else{
	    	dispatcher1.forward(request, response);

	    	//chain.doFilter(request, response);
	    	System.out.println("forwarding");
	    }
	    System.out.println("filter returned");
		// pass the request along the filter chain
    	//chain.doFilter(request, response);
	*/
		HttpServletRequest request1 = (HttpServletRequest) request;
	    HttpSession session = request1.getSession();
	    RequestDispatcher dispatcher1 = request1.getRequestDispatcher("login.jsp");

	    int frwd=0;
		System.out.println(" in filter");
		if(session.isNew()){
	    	System.out.println("in new session");
	    	 session.setAttribute("username","new");
	    	 System.out.println("in filter a new session");
	    	 frwd=1;
	    }else if(session.getAttribute("username").equals("new")){
	    	System.out.println("in old session");
	    	 frwd=1;
	 	    }
		if(frwd==0){
	    	System.out.println("chaining");
	    	chain.doFilter(request, response);
	    }else{
	    	dispatcher1.forward(request, response);

	    	//chain.doFilter(request, response);
	    	System.out.println("forwarding");
	    }
		}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}