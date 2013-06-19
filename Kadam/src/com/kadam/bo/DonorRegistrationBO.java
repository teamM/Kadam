package com.kadam.bo;

import com.kadam.dao.impl.DonorRegistrationDao;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.DonorRegistrationVO;

public class DonorRegistrationBO {
	
	

	public Boolean donorRegistration(DonorRegistrationVO donor_reg_vo) throws KadamException, KadamBusinessException{
		DonorRegistrationDao dao=new DonorRegistrationDao();
		dao.donorRegistration(donor_reg_vo);
		
	
		return null;		
	}

}
