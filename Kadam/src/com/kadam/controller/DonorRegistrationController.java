package com.kadam.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kadam.bo.DonorRegistrationBO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
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
		donor_reg_vo.setDonor_commitment(request.getParameter("donor_commitment"));
		donor_reg_vo.setDonor_address(request.getParameter("donor_address"));
		donor_reg_vo.setDonor_phone1(Integer.parseInt(request.getParameter("donor_phone1")));
		donor_reg_vo.setDonor_phone2(Integer.parseInt(request.getParameter("donor_phone2")));
		//donor_reg_vo.setDonor_bdy(request.getParameter("donor_bdy"));
		//donor_reg_vo.setDonor_annvi(request.getParameter("donor_annvi"));
		donor_reg_vo.setDonor_email(request.getParameter("donor_email"));
		donor_reg_vo.setDonor_email2(request.getParameter("donor_email2"));
		donor_reg_vo.setDonor_workplace(request.getParameter("donor_workplace"));
		donor_reg_vo.setDonor_designation(request.getParameter("donor_designation"));
		donor_reg_vo.setDonor_pancard(request.getParameter("donor_pancard"));
		donor_reg_vo.setDonor_comments(request.getParameter("donor_comments"));
		
		DonorRegistrationBO bo=new DonorRegistrationBO();
		try {
			bo.donorRegistration(donor_reg_vo);
		} catch (KadamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KadamBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
