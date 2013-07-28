package com.kadam.bo;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.kadam.dao.impl.DonorRegistrationDao;
import com.kadam.dao.impl.ReceiptgenerationDAO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.pdf.OpenPDF;
import com.kadam.pdf.PdfDateversion;
import com.kadam.pdf.PdfWrite;
import com.kadam.vo.DonorRegistrationVO;
import com.kadam.vo.ReceiptGenerationDateversionVO;
import com.kadam.vo.ReceiptVO;

public class ReceiptGenerationBO {

	public boolean insertReceiptDetails(ReceiptVO vo) throws KadamException, KadamBusinessException {
		ReceiptgenerationDAO dao = new ReceiptgenerationDAO();
		PdfWrite pdf = new PdfWrite();
		OpenPDF open = new OpenPDF();
		
		boolean flag = dao.insertReceiptDetails(vo);
		/*if(flag==true){
			String receipt_no = pdf.pdf_write(vo);
			open.readpdf(receipt_no);
		}*/
		return true;
	}
	
	public boolean receiptRegenerationDateversion(ReceiptGenerationDateversionVO vo,Document document,PdfWriter writer) throws KadamException, KadamBusinessException{
		
		PdfDateversion pdf = new PdfDateversion();
		DonorRegistrationDao don_dao = new DonorRegistrationDao();
		ReceiptgenerationDAO rec_dao = new ReceiptgenerationDAO();
		
		//Retreive the donor details
		DonorRegistrationVO don_vo = don_dao.retreiveDonorDetails(vo.getDonor_name());
		
		//Retreive the donation details of the donor between the to and from date
		List<ReceiptVO> receipt_list = rec_dao.retreiveReceiptDetails(vo);
		
		pdf.genPDF(document,writer,receipt_list, vo,don_vo);
		
		return false;		
	}
}
