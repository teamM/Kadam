package com.kadam.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kadam.bo.AutoFillBo;
import com.kadam.bo.LoginBo;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;

/**
 * Servlet Filter implementation class LoadDonorNameFilter
 */
public class LoadDonorNameFilter implements Filter {

    /**
     * Default constructor. 
     */
	AutoFillBo bo = new AutoFillBo();
    public LoadDonorNameFilter() {
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
		HttpServletRequest request1=(HttpServletRequest) request;
		HttpSession session=request1.getSession();
		
		try {
			System.out.println("in db filter");
			
			List<String> names = bo.donornameAutofill();
			session.setAttribute("donor_names", names);
			
		} catch (KadamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KadamBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
