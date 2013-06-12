package com.kadam.customtags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
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
			System.out.println(receipt_list.size());
			while(io.hasNext()){
				vo = io.next();
				System.out.println(vo);
				out.print("<tr>");
				out.print("<td>"+ vo.getReceipt_id()+"</td>");
				out.print("<td>"+ vo.getDate() + "</td>");
				out.print("<td>"+ vo.getDetails()+ "</td>");
				out.print("<td><a href='readPDF.jsp'>open</a></td>");
				out.print("</tr>");
			}	
			out.print("</table>");
			
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
