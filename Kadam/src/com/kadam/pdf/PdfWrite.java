package com.kadam.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfWrite {
  private static String FILE = "C:/Users/deepu/git/Kadam/Kadam/PDF Store/FirstPdf.pdf";
  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD);
  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.NORMAL);

  public void pdf_write() {
	 try {
      Document document = new Document();
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      addTitlePage(document,writer);
      //addContent(document);
      document.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // iText allows to add metadata to the PDF which can be viewed in your Adobe
  // Reader
  // under File -> Properties
  private static void addMetaData(Document document) {
    document.addTitle("Receipt generated");
    document.addSubject("Using iText");
    document.addKeywords("");
    document.addAuthor("");
    document.addCreator("");
  }

  private static void addTitlePage(Document document,PdfWriter writer)throws DocumentException, IOException {
    
	  //adding line
	  PdfContentByte cb = writer.getDirectContent();
	  cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
	
	//top line
	    cb.moveTo(50, 810);
	    cb.lineTo(550, 810);
	    
	    //left line
	    cb.moveTo(50, 810);
	    cb.lineTo(50, 150);
	    
	    //right line
	    cb.moveTo(550, 810);
	    cb.lineTo(550, 150);
	    
	    //bottom line
	    cb.moveTo(50, 150);
	    cb.lineTo(550, 150);
  	  
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
    
    
    preface = new Paragraph("                                                         Name :                                            PAN : ",smallBold);
    document.add(preface);
    
    preface = new Paragraph("                                                         Address :                                         Type : ",smallBold);
    document.add(preface);
    
    cb.moveTo(100, 650);
    cb.lineTo(500, 650);    
    
    addEmptyLine(preface, 3);
    preface = new Paragraph("\n\nDetails of donation during the period ....\n\n",subFont);
    preface.setAlignment(Element.ALIGN_CENTER);
    document.add(preface);
    
    createTable(document);
    
  //draw a line after table
    cb.moveTo(50, 400);
    cb.lineTo(550, 400);
    
    preface = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
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
    cb.moveTo(50, 200);
    cb.lineTo(550, 200);
    
    preface = new Paragraph("\n\n\n\n\n\n\n\n\n\nIT 8o(G) Ecemption Notification Ref No. DIT(E) BLR/8oG/184/AABTK9713B/ITO(E)/Vol2012-2013 dated 14th\n August 2012 from Assessment Year 2013-2014 onwards.",smallBold);
    preface.setAlignment(Element.ALIGN_CENTER);
    document.add(preface);
    
    cb.stroke();
    // Start a new page
    //document.newPage();
   }
  
  private static void createTable(Document document) throws DocumentException {
	    
	  PdfPTable table = new PdfPTable(3);
	  
    // t.setBorderColor(BaseColor.GRAY);
    // t.setPadding(4);
    // t.setSpacing(4);
    // t.setBorderWidth(1);

    PdfPCell c1 = new PdfPCell(new Phrase("RECEIPT NO"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("PARTICULARS"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("AMOUNT"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    table.setHeaderRows(1);

    table.addCell("1.0");
    table.addCell("1.1");
    table.addCell("1.2");
    table.addCell("2.1");
    table.addCell("2.2");
    table.addCell("2.3");  
    table.addCell("");
    table.addCell("TOTAL");
    table.addCell("....");
    
    document.add(table);

  }
  
  private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
} 