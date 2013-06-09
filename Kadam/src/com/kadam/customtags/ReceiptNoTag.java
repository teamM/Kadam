package com.kadam.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kadam.dao.impl.ReceiptgenerationDAO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.util.PropertyUtil;

public class ReceiptNoTag extends SimpleTagSupport{
	
	public void doTag() {
		
		ReceiptgenerationDAO dao = null;
		try {
			dao = new ReceiptgenerationDAO();
		} catch (KadamException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KadamBusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int receipt_id = dao.autogenerate_receiptid();
		System.out.println("receipt id = " + receipt_id);

		final JspWriter out = getJspContext().getOut();		
		try {
			out.print("<input type='text' name='receiptno' value=' "+ receipt_id +" '>");
		} catch (IOException e) {
			
		}

	}


}
