package com.kadam.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;

public class AutoFillDao {
	
	PreparedStatement statement;
	Connection con;
	ResultSet result;
	public  AutoFillDao() throws KadamException, KadamBusinessException {
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
	
	
	@SuppressWarnings("unchecked")
	public List<String> donornameAutofill(String query) throws KadamBusinessException {
		// TODO Auto-generated method stub
		List<String> names=new ArrayList<String>();
		try {
			System.out.println("in dao");
			String query1=query+"%";
			statement=con.prepareStatement("select donor_name from master_receipts where donor_name like ?");
			statement.setString(1, query1);
			result=statement.executeQuery();
			while (result.next()){
				names.add(result.getString(1));
				//System.out.println(result.getString(1));
			}
			//System.out.println(result.getFetchSize()+" now ");
            //names=(List<String>) result.getArray("donor_name");
			
			con.close();
			}catch (SQLException e) {
				System.out.println("exception "+e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new KadamBusinessException(e+" Donor_name autofill cannot be retrived from database");
		}	
		//names.add("vivek");
		//names.add("madhav");
		return names;
	}	
}
