package com.kadam.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.kadam.bo.ReceiptGenerationBO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.ReceiptGenerationDateversionVO;
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
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReceiptVO receipt_vo = new ReceiptVO();
		ReceiptGenerationBO bo = new ReceiptGenerationBO();		
		
		receipt_vo.setReceipt_id(Integer.parseInt(request.getParameter("receiptno")));
		receipt_vo.setDonor_name(request.getParameter("donor"));
		receipt_vo.setCollection_mode(request.getParameter("collectionmode"));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed;
		try {
			parsed = format.parse(request.getParameter("date"));
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			receipt_vo.setReceipt_date(sql);
			System.out.println("sql date :" + sql);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		receipt_vo.setFund_name(request.getParameter("fundname"));
		receipt_vo.setAmount(Integer.parseInt(request.getParameter("amount")));
		receipt_vo.setDetails(request.getParameter("details"));
		
		try {
			bo.insertReceiptDetails(receipt_vo);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("donation_receipts.jsp");
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
