package com.kadam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		 HttpSession session = request.getSession();

		 
		userloginvo.setUsername(userName);
		userloginvo.setPassword(passWord);
		
		try {
			authentication=bo.loginAuthentication(userloginvo);
			System.out.println("hello "+authentication);
			if(authentication==true){
				System.out.println("authenticating");
				//session.setAttribute("login",userloginvo.getUsertype());
				//in future if there is to be admin and normal user then the above can be used
				session.setAttribute("username", userloginvo.getUsername());
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("content_kadam.jsp");
				//dispatcher1.forward(request, response);
				response.sendRedirect("content_kadam.jsp");
				return;
			}
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("invalidlogin.jsp");
				dispatcher2.forward(request, response);
			
		} catch (KadamException e) {
			e.printStackTrace();
		} catch (KadamBusinessException e) {
			e.printStackTrace();
		}
		
		
	}

}
