package com.kadam.pdf;

import java.io.File;

public class OpenPDF {
	
	public void readpdf(){
		try {

			if ((new File("C:/Users/deepu/git/Kadam/Kadam/PDF Store/PositionPdf.pdf")).exists()) {

				Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler C:/Users/deepu/git/Kadam/Kadam/PDF Store/PositionPdf.pdf");
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
