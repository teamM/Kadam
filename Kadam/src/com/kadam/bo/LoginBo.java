package com.kadam.bo;

import com.kadam.dao.impl.AuthenticationDao;
import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.LoginVo;

public class LoginBo {
	
	public boolean loginAuthentication(LoginVo userloginvo) throws KadamException, KadamBusinessException{
		
		AuthenticationDao dao=new AuthenticationDao();
		
		return dao.userAuthentication(userloginvo);
		
		
	}
	

}
