package com.kadam.pdf;

import java.io.File;

import org.apache.catalina.Session;

public class OpenPDF {
	
	public void readpdf(String receiptno){
		try {
			System.out.println("open pdf :" + "Donation_receipt_" + receiptno + ".pdf");
			if ((new File("C:/Users/deepu/git/Kadam/Kadam/PDF Store/Donation_receipt_" + receiptno + ".pdf")).exists()) {

				Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler C:/Users/deepu/git/Kadam/Kadam/PDF Store/Donation_receipt_" + receiptno + ".pdf");
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
