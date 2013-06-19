package com.kadam.customtags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kadam.pdf.OpenPDF;

public class ReadPdfTag extends SimpleTagSupport{

	OpenPDF pdf = new OpenPDF();
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext)getJspContext();
		HttpSession session = pageContext.getSession();
		
		// TODO Auto-generated method stub
		super.doTag();
		pdf.readpdf((String)session.getAttribute("receiptno"));
		System.out.println("readpdfTag" + session.getAttribute("receiptno"));
	}
}
