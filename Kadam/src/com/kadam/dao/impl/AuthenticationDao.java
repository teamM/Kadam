package com.kadam.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.DonorRegistrationVO;
import com.kadam.vo.LoginVo;

public class AuthenticationDao {
	
	PreparedStatement statement;
	Connection con;
	ResultSet result;
	public  AuthenticationDao() throws KadamException, KadamBusinessException {
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new KadamException("Database driver not found");
		}
		catch(SQLException e){
			throw new KadamBusinessException("Connection could not be established");
		}
	}
	
	
	public boolean userAuthentication(LoginVo userloginvo) throws KadamBusinessException{
		try{
			statement=con.prepareStatement("select * from kadamusers where uid=? and password=?");
			statement.setString(1, userloginvo.getUsername());    
			statement.setString(2, userloginvo.getPassword());
			System.out.println(userloginvo.getPassword()+"pass"+userloginvo.getUsername()+"username");
			result=statement.executeQuery();
			
			if(result.next()){
				return true;
			}
			con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				throw new KadamBusinessException(e+"Subject information could not be inserted");
			}	
		
		return false;
		
	}		
}
