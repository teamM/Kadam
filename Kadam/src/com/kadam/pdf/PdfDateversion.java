package com.kadam.pdf;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kadam.vo.DonorRegistrationVO;
import com.kadam.vo.ReceiptGenerationDateversionVO;
import com.kadam.vo.ReceiptVO;

public class PdfDateversion {
	
	  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
	  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD);
	  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL);
	
	public void genPDF(Document document,PdfWriter writer,List<ReceiptVO> receipt_list,ReceiptGenerationDateversionVO vo,DonorRegistrationVO don_vo){
				
		document.open();
		 try {
			addContent(document,writer,receipt_list,vo,don_vo);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      document.close();
		
	}
	
	 private static void addContent(Document document,PdfWriter writer,List<ReceiptVO> receipt_list,ReceiptGenerationDateversionVO vo,DonorRegistrationVO don_vo)throws DocumentException, IOException {
		    
		  //adding line
		  PdfContentByte cb = writer.getDirectContent();
		  cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
		
		//top line
		    cb.moveTo(50, 810);
		    cb.lineTo(550, 810);
		    
		    //left line
		    cb.moveTo(50, 810);
		    cb.lineTo(50, 50);
		    
		    //right line
		    cb.moveTo(550, 810);
		    cb.lineTo(550, 50);
		    
		    //bottom line
		    cb.moveTo(50, 50);
		    cb.lineTo(550, 50);
	  	  
		Paragraph preface = new Paragraph();
	    // Lets write a big header
	    preface = new Paragraph("         Report generated by: " + System.getProperty("user.name") + ", " + new Date(), smallBold); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	    document.add(preface);
	    
	    addEmptyLine(preface, 4);
	    Paragraph head = new Paragraph("KADAM", catFont);
	    head.setAlignment(Element.ALIGN_CENTER);
	    document.add(head);
	    addEmptyLine(preface, 1);
	    //preface.add(new Paragraph("KADAM", catFont));
	    // Will create: Report generated by: _name, _date
	    
	    preface = new Paragraph("Kadam Charitable & Education Foundation",smallBold);
	    preface.setAlignment(Element.ALIGN_CENTER);        
	    document.add(preface);

	    preface = new Paragraph("Alps-1101, Heritage Estate, Yelahanka. Bangalore-560064",smallBold);
	    preface.setAlignment(Element.ALIGN_CENTER);        
	    document.add(preface);

	    preface = new Paragraph("email: contact@kadamfoundation.org",smallBold);
	    preface.setAlignment(Element.ALIGN_CENTER);        
	    document.add(preface);

	    preface = new Paragraph("Phone no : 7676202606",smallBold);        
	    preface.setAlignment(Element.ALIGN_CENTER);        
	    document.add(preface);
	    
	    cb.moveTo(100, 700);
	    cb.lineTo(500, 700);
	    
	    //dataaaaaaaaa
	    Chunk chunk=new Chunk();
	    /*chunk.setUnderline(+1f,-2f);//1st co-ordinate is for line width,2nd is space betweew
	    document.add(chunk);
	        Chunk chunk1=new Chunk("Name : ");
	    chunk1.setUnderline(+0.1f, -3f);
	    document.add(chunk1);
	*/

	    
	    document.add(Chunk.NEWLINE);   //Something like in HTML <img src="http://www.java4s.com/wp-includes/images/smilies/icon_smile.gif" alt=":-)" class="wp-smiley">
	    document.add(Chunk.NEWLINE);
	    
	    PdfPTable table = new PdfPTable(4);
	    table.getDefaultCell().disableBorderSide(1);
	    
	    PdfPCell c1=new PdfPCell(new Phrase("Name :"));
	    c1.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c1);
	    
	    PdfPCell c2 = new PdfPCell(new Phrase(don_vo.getDonor_name()));
	    c2.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c2);
	    
	    PdfPCell c3 = new PdfPCell(new Phrase("Pan :"));
	    c3.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c3);
	    
	    PdfPCell c4 = new PdfPCell(new Phrase(don_vo.getDonor_pancard()));
	    c4.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c4);
	    
	    PdfPCell c5 = new PdfPCell(new Phrase("Address :"));
	    c5.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c5);
	    
	    PdfPCell c6 = new PdfPCell(new Phrase(don_vo.getDonor_address()));
	    c6.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c6);
	    
	    PdfPCell c8 = new PdfPCell(new Phrase("Type :"));
	    c8.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c8);
	    
	    PdfPCell c9 = new PdfPCell(new Phrase(""));
	    c9.setBorder(Rectangle.NO_BORDER);	    
	    table.addCell(c9);
	    
	        
	    document.add(table);
	    /*preface = new Paragraph("                                                         Name :                                            PAN : ",smallBold);
	    document.add(preface);
	    
	    preface = new Paragraph("                                                         Address :                                         Type : ",smallBold);
	    document.add(preface);*/
	    
	    cb.moveTo(100, 630);
	    cb.lineTo(500, 630);    
	    
	    addEmptyLine(preface, 3);
	    preface = new Paragraph("\n\nDetails of donation during the period " + vo.getFrom_date() + " - " + vo.getTo_date() + "....\n\n",subFont);
	    preface.setAlignment(Element.ALIGN_CENTER);
	    document.add(preface);
	    
	    createTable(document,receipt_list);
	    
	  //draw a line after table
	    cb.moveTo(50, 200);
	    cb.lineTo(550, 200);
	    
	    document.add(Chunk.NEWLINE);
	    document.add(Chunk.NEWLINE);
	    document.add(Chunk.NEWLINE);	    
	    document.add(Chunk.NEWLINE);
	    document.add(Chunk.NEWLINE);
	    preface = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
	    		"                                                                                                                           " +
	    		"For Kadam Charitable & Education Foundation\n" +
	    		"                                                                                                                           "+
	    		"                           Sgd/-\n" +
	    		"                                                                                                                           "+
	    		"                      Saurabh Jain\n" +
	    		"                                                                                                                           "+
	    		"                           Trustee",smallBold);
	    document.add(preface);
	    addEmptyLine(preface, 3);
	  
	  //draw a line at the end
	    cb.moveTo(50, 100);
	    cb.lineTo(550, 100);
	    
	    document.add(Chunk.NEWLINE);
	    document.add(Chunk.NEWLINE);
	    preface = new Paragraph("\n\nIT 8o(G) Ecemption Notification Ref No. DIT(E) BLR/8oG/184/AABTK9713B/ITO(E)/Vol2012-2013 dated 14th\n August 2012 from Assessment Year 2013-2014 onwards.",smallBold);
	    preface.setAlignment(Element.ALIGN_CENTER);
	    document.add(preface);
	    
	    cb.stroke();
	    // Start a new page
	    //document.newPage();
	   }
	 
	 private static void createTable(Document document,List<ReceiptVO> receipt_list) throws DocumentException {
		    
		  PdfPTable table = new PdfPTable(3);
		  int sum = 0;
		  
	   // t.setBorderColor(BaseColor.WHITE);
	    // t.setPadding(4);
	    // t.setSpacing(4);
	    // t.setBorderWidth(1);

	    PdfPCell c1 = new PdfPCell(new Phrase("RECEIPT NO"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    c1.setPadding(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("PARTICULARS"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    c1.setPadding(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("AMOUNT"));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    c1.setPadding(5);
	    table.addCell(c1);
	    table.setHeaderRows(1);

	    for(ReceiptVO vo : receipt_list){
	    	c1 = new PdfPCell(new Phrase("" + vo.getReceipt_id()));
	    	c1.setPadding(5);
	    	table.addCell(c1);
		    
	    	c1 = new PdfPCell(new Phrase("" + vo.getReceipt_date() + "\n" + vo.getFund_name()));
	    	c1.setPadding(5);
	    	table.addCell(c1);
	    	
	    	c1 = new PdfPCell(new Phrase("" + vo.getAmount()));
	    	c1.setPadding(5);
	    	table.addCell(c1);
	    	
		    sum = sum + vo.getAmount();
	    }
		c1 = new PdfPCell(new Phrase(""));
    	c1.setPadding(5);
    	table.addCell(c1);
    
    	c1 = new PdfPCell(new Phrase("TOTAL"));
    	c1.setPadding(5);
    	table.addCell(c1);
    
    	c1 = new PdfPCell(new Phrase("" + sum));
    	c1.setPadding(5);
    	table.addCell(c1);
    	      
	    document.add(table);

	  }
	 
	 private static void addEmptyLine(Paragraph paragraph, int number) {
		    for (int i = 0; i < number; i++) {
		      paragraph.add(new Paragraph(" "));
		    }
	 }
}
