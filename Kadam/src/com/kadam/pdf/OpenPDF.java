package com.kadam.pdf;

import java.io.File;

import org.apache.catalina.Session;

import com.kadam.util.PropertyUtil;

public class OpenPDF {
	
	public void readpdf(String receiptno){
		try {			
			if ((new File(PropertyUtil.getUIText("link") + receiptno + ".pdf")).exists()) {

				Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler " + PropertyUtil.getUIText("link") + receiptno + ".pdf");
				p.waitFor();

			} else {

				System.out.println("File is not exists");

			}

			System.out.println("Done");

		  } catch (Exception ex) {
			ex.printStackTrace();
		  }


	}

}
