package com.kadam.vo;

import java.sql.Date;

public class DonorRegistrationVO {
	private int donor_id;
	private String donor_name;
	private Date donor_regdate;
	private String donor_commitment;
	private String donor_address;
	private double donor_phone1;
	private double donor_phone2;
	private Date donor_bdy;
	private Date donor_annvi;
	private String donor_email;
	private String donor_email2;
	private String donor_workplace;
	private String donor_designation;
	private String donor_pancard;
	private String donor_comments;
	public int getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public Date getDonor_regdate() {
		return donor_regdate;
	}
	public void setDonor_regdate(Date donor_regdate) {
		this.donor_regdate = donor_regdate;
	}
	public String getDonor_commitment() {
		return donor_commitment;
	}
	public void setDonor_commitment(String donor_commitment) {
		this.donor_commitment = donor_commitment;
	}
	public String getDonor_address() {
		return donor_address;
	}
	public void setDonor_address(String donor_address) {
		this.donor_address = donor_address;
	}
	public double getDonor_phone1() {
		return donor_phone1;
	}
	public void setDonor_phone1(double donor_phone1) {
		this.donor_phone1 = donor_phone1;
	}
	public double getDonor_phone2() {
		return donor_phone2;
	}
	public void setDonor_phone2(double donor_phone2) {
		this.donor_phone2 = donor_phone2;
	}
	public Date getDonor_bdy() {
		return donor_bdy;
	}
	public void setDonor_bdy(Date parsed_bdy) {
		this.donor_bdy =  parsed_bdy;
	}
	public Date getDonor_annvi() {
		return donor_annvi;
	}
	public void setDonor_annvi(Date parsed_annvi) {
		this.donor_annvi =  parsed_annvi;
	}
	public String getDonor_email() {
		return donor_email;
	}
	public void setDonor_email(String donor_email) {
		this.donor_email = donor_email;
	}
	public String getDonor_email2() {
		return donor_email2;
	}
	public void setDonor_email2(String donor_email2) {
		this.donor_email2 = donor_email2;
	}
	public String getDonor_workplace() {
		return donor_workplace;
	}
	public void setDonor_workplace(String donor_workplace) {
		this.donor_workplace = donor_workplace;
	}
	public String getDonor_designation() {
		return donor_designation;
	}
	public void setDonor_designation(String donor_designation) {
		this.donor_designation = donor_designation;
	}
	public String getDonor_pancard() {
		return donor_pancard;
	}
	public void setDonor_pancard(String donor_pancard) {
		this.donor_pancard = donor_pancard;
	}
	public String getDonor_comments() {
		return donor_comments;
	}
	public void setDonor_comments(String donor_comments) {
		this.donor_comments = donor_comments;
	}
	
	
}
