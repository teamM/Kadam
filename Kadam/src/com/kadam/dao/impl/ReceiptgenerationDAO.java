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
import com.kadam.util.PropertyUtil;
import com.kadam.vo.ReceiptGenerationDateversionVO;
import com.kadam.vo.ReceiptVO;

public class ReceiptgenerationDAO {

	PreparedStatement statement_execute=null;
	Connection con;
	ResultSet result;
	public ReceiptgenerationDAO() throws KadamException, KadamBusinessException {
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection(PropertyUtil.getDataBaseUrl(), PropertyUtil.getDataBaseUserName(), PropertyUtil.getDataBasePassWord());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new KadamException("Database driver not found");
		}
		catch(SQLException e){
			throw new KadamBusinessException("Connection could not be established");
		}
	}

	public int autogenerate_receiptid() throws KadamBusinessException {
		int maxId=0, receipt_id ;
		try {
			statement_execute = con.prepareStatement("select max(receipt_voucher_no) from master_receipts");
			result = statement_execute.executeQuery();
			if(result.next()){
				maxId = result.getInt(1);
			}
	        receipt_id = maxId + 1;
	        
	    } catch (SQLException ex) {
	    	throw new KadamBusinessException("Cannot generate receipt id");
	    }
		return receipt_id;		
	}
	
	public boolean insertReceiptDetails(ReceiptVO vo) throws KadamBusinessException {
		
		try {
			statement_execute = con.prepareStatement("insert into master_receipts (donor_name,collection_mode,fund_name,amount,details) values(?,?,?,?,?);");
			statement_execute.setString(1, vo.getDonor_name());
			statement_execute.setString(2, vo.getCollection_mode());
			statement_execute.setString(3, vo.getFund_name());			
			statement_execute.setInt(4, vo.getAmount());
			statement_execute.setString(5, vo.getDetails());
			statement_execute.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new KadamBusinessException("Cannot insert the receipt details");
		}
		
		return true;
	}
	
	//This method is not used now
	public List<ReceiptVO> printReceipt() throws KadamBusinessException{
		List<ReceiptVO> receipt_list = new ArrayList<ReceiptVO>();
		ReceiptVO vo ;
		
		try {
			statement_execute = con.prepareStatement("select receipt_voucher_no,receipt_date,details,fund_name,donor_name,collection_mode from master_receipts");
			result = statement_execute.executeQuery();
			while(result.next()){
				vo = new ReceiptVO();
				vo.setReceipt_id(result.getInt(1));
				vo.setReceipt_date(result.getDate(2));
				vo.setDetails(result.getString(3));
				vo.setFund_name(result.getString(4));
				vo.setDonor_name(result.getString(5));
				vo.setCollection_mode(result.getString(6));
				
				receipt_list.add(vo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new KadamBusinessException("Can not retreive the print details");
		}
		
		return receipt_list;
	}
	
	public List<ReceiptVO> retreiveReceiptDetails(ReceiptGenerationDateversionVO vo_detail){
		List<ReceiptVO> receipt_list = new ArrayList<ReceiptVO>();
		ReceiptVO vo ;
		try {
			statement_execute = con.prepareStatement("select * from master_receipts where DATE(receipt_date)>=? and DATE(receipt_date)<=? and donor_name=?");
			statement_execute.setDate(1, vo_detail.getFrom_date());
			statement_execute.setDate(2, vo_detail.getTo_date());
			statement_execute.setString(3, vo_detail.getDonor_name());
			result = statement_execute.executeQuery();
			while(result.next()){
				vo = new ReceiptVO();
				vo.setReceipt_id(result.getInt(1));
				vo.setDonor_name(result.getString(2));
				vo.setCollection_mode(result.getString(3));
				vo.setFund_name(result.getString(4));
				vo.setReceipt_date(result.getDate(5));
				vo.setAmount(result.getInt(6));
				receipt_list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receipt_list;
	}
}
