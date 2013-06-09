package com.kadam.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kadam.execeptions.KadamBusinessException;
import com.kadam.execeptions.KadamException;
import com.kadam.vo.ReceiptVO;

public class ReceiptgenerationDAO {

	PreparedStatement statement_execute=null;
	Connection con;
	ResultSet result;
	public ReceiptgenerationDAO() throws KadamException, KadamBusinessException {
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaps", "root", "admin");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new KadamException("Database driver not found");
		}
		catch(SQLException e){
			throw new KadamBusinessException("Connection could not be established");
		}
	}

	public int autogenerate_receiptid() {
		int maxId=0, receipt_id ;
		try {
			statement_execute = con.prepareStatement("select max(receipt_voucher_no) from master_receipts");
			result = statement_execute.executeQuery();
			if(result.next()){
				maxId = result.getInt(1);
			}
	        receipt_id = maxId + 1;
	        
	    } catch (SQLException ex) {
	        throw new IllegalStateException("Cannot access database", ex);
	    }
		return receipt_id;		
	}
	
	public boolean insertReceiptDetails(ReceiptVO vo) {
		
		try {
			statement_execute = con.prepareStatement("insert into master_receipts values(?,?,?,?,?,?)");
			statement_execute.setString(1, vo.getDonor_name());
			statement_execute.setString(2, vo.getCollection_mode());
			statement_execute.setString(3, vo.getFund_name());
			statement_execute.setDate(4, vo.getDate());
			statement_execute.setInt(5, vo.getAmount());
			statement_execute.setString(6, vo.getDetails());
			statement_execute.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException("Cannot access database", e);
		}
		
		return true;
	}
}
