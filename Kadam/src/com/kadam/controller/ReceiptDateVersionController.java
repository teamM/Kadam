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
import com.itextpdf.text.pdf.PdfWriter;
import com.kadam.bo.ReceiptGenerationBO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.ReceiptGenerationDateversionVO;

/**
 * Servlet implementation class ReceiptDateVersionController
 */
public class ReceiptDateVersionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptDateVersionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {

		//Used to generate the Receipt date version
		ReceiptGenerationDateversionVO vo = new ReceiptGenerationDateversionVO();
		ReceiptGenerationBO bo = new ReceiptGenerationBO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed;
		try {
			vo.setDonor_name(request.getParameter("donor"));
			parsed = format.parse(request.getParameter("from_date"));
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			vo.setFrom_date(sql);
			
			parsed = format.parse(request.getParameter("to_date"));
			sql = new java.sql.Date(parsed.getTime());
			vo.setTo_date(sql);
			
		} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		//bo.receiptRegenerationDateversion(vo);
		try{
			// step 1
	        Document document = new Document();
	        // step 2
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PdfWriter writer = PdfWriter.getInstance(document, baos);
	        // step 3
	       
	        try {
				bo.receiptRegenerationDateversion(vo,document,writer);
			} catch (KadamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KadamBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // setting some response headers
	        response.setHeader("Expires", "0");
	        response.setHeader("Cache-Control",
	            "must-revalidate, post-check=0, pre-check=0");
	        response.setHeader("Pragma", "public");
	        // setting the content type
	        response.setContentType("application/pdf");
	        // the contentlength
	        response.setContentLength(baos.size());
	        // write ByteArrayOutputStream to the ServletOutputStream
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        os.flush();
	        os.close();
	        RequestDispatcher dispatcher1 = request.getRequestDispatcher("generateReceipts_dateversion.jsp");
			dispatcher1.forward(request, response);
		 }
		catch(DocumentException e) {
		    throw new IOException(e.getMessage());
		}

	}
}
