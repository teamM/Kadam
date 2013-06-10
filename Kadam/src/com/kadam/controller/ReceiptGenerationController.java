package com.kadam.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kadam.bo.ReceiptGenerationBO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.ReceiptVO;

/**
 * Servlet implementation class ReceiptGenerationController
 */
public class ReceiptGenerationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptGenerationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReceiptVO receipt_vo = new ReceiptVO();
		ReceiptGenerationBO bo = new ReceiptGenerationBO();
		
		receipt_vo.setDonor_name(request.getParameter("donor"));
		receipt_vo.setCollection_mode(request.getParameter("collectionmode"));
		receipt_vo.setFund_name(request.getParameter("fundname"));
		Date donor_date = new Date(Long.parseLong(request.getParameter("date")));
		receipt_vo.setDate(donor_date);
		receipt_vo.setAmount(Integer.parseInt(request.getParameter("amount")));
		receipt_vo.setDetails(request.getParameter("details"));
		
		try {
			if(bo.insertReceiptDetails(receipt_vo)==true){
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("donation_receipts.jsp");
				dispatcher1.forward(request, response);
			}
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
