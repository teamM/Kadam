package com.kadam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kadam.bo.LoginBo;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.LoginVo;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String userName = request.getParameter("username");
		 String passWord = request.getParameter("password");
		 boolean authentication;
		 
		 LoginVo userloginvo=new LoginVo();
		 LoginBo bo=new LoginBo();
		 
		userloginvo.setUsername(userName);
		userloginvo.setPassword(passWord);
		
		try {
			authentication=bo.loginAuthentication(userloginvo);
		} catch (KadamException e) {
			e.printStackTrace();
		} catch (KadamBusinessException e) {
			e.printStackTrace();
		}
		
		
	}

}
