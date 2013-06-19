package com.kadam.customtags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kadam.dao.impl.ReceiptgenerationDAO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.ReceiptVO;

public class PrintReceiptTag extends SimpleTagSupport{
	
	ReceiptgenerationDAO dao;
	List<ReceiptVO> receipt_list ;

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		final JspWriter out = getJspContext().getOut(); // gets the output stream to
		PageContext pageContext = (PageContext)getJspContext();
		HttpSession session = pageContext.getSession();
		
		try {
			dao = new ReceiptgenerationDAO();
			receipt_list = dao.printReceipt();
			ReceiptVO vo ;
			Iterator<ReceiptVO> io = receipt_list.iterator();
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th>receipt no</th>");
			out.print("<th>Date</th>");
			out.print("<th>Details</th>");
			out.print("<th>Read File</th>");
			out.print("</tr>");
			
			while(io.hasNext()){
				vo = io.next();
				String receiptno = vo.getReceipt_id() + "_" + vo.getReceipt_date();
				//System.out.println("receiptno : " + receiptno);
				session.setAttribute("receiptno", vo.getReceipt_id() + "_" + vo.getReceipt_date());
				out.print("<tr>");
				out.print("<td>"+ vo.getReceipt_id()+"</td>");
				out.print("<td>"+ vo.getReceipt_date() + "</td>");
				out.print("<td>"+ vo.getDetails()+ "</td>");
				out.print("<td><a href='readPDF.jsp?&RNO='"+receiptno+"'' >open</a></td>");
				out.print("</tr>");
			}	
			out.print("</table>");
			System.out.println("get session: " + session.getAttribute("receiptno"));
			
		} catch (KadamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KadamBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doTag();
		
	}
}
