package com.kadam.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.kadam.bo.DonorRegistrationBO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.DonorRegistrationVO;

/**
 * Servlet implementation class DonorRegistrationController
 */
public class DonorRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HttpSession session ;
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
		session=request.getSession();
		
		donor_reg_vo.setDonor_name(request.getParameter("donor_name"));
		//donor_reg_vo.setDonor_regdate(DateFormat.parse(request.getParameter("donor_regdate"))); //Date inserted automatically in DB
		donor_reg_vo.setDonor_commitment(request.getParameter("donor_commitment"));
		donor_reg_vo.setDonor_address(request.getParameter("donor_address"));
		donor_reg_vo.setDonor_phone1(Double.parseDouble(request.getParameter("donor_phone1")));
		donor_reg_vo.setDonor_phone2(Double.parseDouble(request.getParameter("donor_phone2")));
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date parsed_bdy = null;
		Date parsed_annvi=null;
		//donor_reg_vo.setDonor_bdy(request.getParameter("donor_bdy"));
		//donor_reg_vo.setDonor_annvi(request.getParameter("donor_annvi"));
        try {
			parsed_bdy = format.parse(request.getParameter("donor_bday"));
			java.sql.Date sql_bdy = new java.sql.Date(parsed_bdy.getTime());
			donor_reg_vo.setDonor_bdy(sql_bdy);
			
			parsed_annvi = format.parse(request.getParameter("don_anniversary"));
			java.sql.Date sql_annvi = new java.sql.Date(parsed_annvi.getTime());
			donor_reg_vo.setDonor_annvi(sql_annvi);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		donor_reg_vo.setDonor_email(request.getParameter("donor_email1"));
		donor_reg_vo.setDonor_email2(request.getParameter("donor_email2"));
		donor_reg_vo.setDonor_workplace(request.getParameter("donor_workplace"));
		donor_reg_vo.setDonor_designation(request.getParameter("donor_designation"));
		donor_reg_vo.setDonor_pancard(request.getParameter("donor_pan"));
		donor_reg_vo.setDonor_comments(request.getParameter("donor_comments"));
		
		DonorRegistrationBO bo=new DonorRegistrationBO();
		try {
			bo.donorRegistration(donor_reg_vo);
			session.setAttribute("success",	"Registration Successful");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("donor_registration.jsp");
			dispatcher1.forward(request, response);
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
