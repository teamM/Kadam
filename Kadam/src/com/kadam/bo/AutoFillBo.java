package com.kadam.bo;

import java.util.List;

import com.kadam.dao.impl.AutoFillDao;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;

public class AutoFillBo {
	public List<String> donornameAutofill() throws KadamException, KadamBusinessException{
		System.out.println("in bo ");
		AutoFillDao dao=new AutoFillDao();
		return dao.donornameAutofill();
		
	}

}
