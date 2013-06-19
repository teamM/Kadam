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
	
	PreparedStatement statement;
	Connection con;
	ResultSet result;
	public DonorRegistrationDao() throws KadamException, KadamBusinessException {
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
	

	
	public boolean donorRegistration(DonorRegistrationVO donor_reg_vo) throws KadamBusinessException{
		try {
			statement=con.prepareStatement("insert into master_donor (don_id,don_name,don_regdate,don_commitment ,don_address ,don_phone1,don_phone2,don_bday,don_anniv,don_email ,don_email2 ,don_workplace,don_designation,don_pan,don_comments) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setDate(1, donor_reg_vo.getDonor_regdate());
			statement.setString(2, donor_reg_vo.getDonor_commitment());
			statement.setString(3, donor_reg_vo.getDonor_address());
			statement.setInt(4, donor_reg_vo.getDonor_phone1());
			statement.setInt(5, donor_reg_vo.getDonor_phone2());
			statement.setDate(6, donor_reg_vo.getDonor_bdy());
			statement.setDate(7, donor_reg_vo.getDonor_annvi());
			statement.setString(8, donor_reg_vo.getDonor_email());
			statement.setString(9, donor_reg_vo.getDonor_email2());
			statement.setString(10, donor_reg_vo.getDonor_workplace());
			statement.setString(12, donor_reg_vo.getDonor_designation());
			statement.setString(13, donor_reg_vo.getDonor_pancard());
			statement.setString(14, donor_reg_vo.getDonor_comments());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new KadamBusinessException(e+"Master donor information could not be inserted");
		}

		return false;
	}

}
