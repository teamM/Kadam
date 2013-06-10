package com.kadam.bo;

import com.kadam.dao.impl.ReceiptgenerationDAO;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.ReceiptVO;

public class ReceiptGenerationBO {

	public boolean insertReceiptDetails(ReceiptVO vo) throws KadamException, KadamBusinessException {
		ReceiptgenerationDAO dao = new ReceiptgenerationDAO();
		return dao.insertReceiptDetails(vo);
	}
	
}
