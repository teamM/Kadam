package com.kadam.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.DonorRegistrationVO;

public class DonorRegistrationDao {
	
	PreparedStatement addcolumn_statement=null,teachertable_statement,addteacher_statement,addaccount_statement,generatepassword_statement;
	Connection con;
	ResultSet result;
	public DonorRegistrationDao() throws KadamException, KadamBusinessException {
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
	

	
	boolean donorRegistration(DonorRegistrationVO don_vo){
		
		return false;
	}

}
