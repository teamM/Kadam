package com.kadam.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.kadam.pdf.OpenPDF;

public class ReadPdfTag extends SimpleTagSupport{

	OpenPDF pdf = new OpenPDF();
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		pdf.readpdf();
	}
}
