package com.kadam.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kadam.vo.DonorRegistrationVO;

/**
 * Servlet implementation class DonorRegistrationController
 */
public class DonorRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//Object creation
		DonorRegistrationVO donor_reg_vo = new DonorRegistrationVO();
		
		donor_reg_vo.setDonor_id(Integer.parseInt(request.getParameter("donor_id")));
		donor_reg_vo.setDonor_name(request.getParameter("donor_name"));
		//donor_reg_vo.setDonor_regdate(DateFormat.parse(request.getParameter("donor_regdate")));
		
		//KARTHIK set all other vo variables
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
