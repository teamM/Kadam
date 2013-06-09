package com.kadam.vo;

import java.sql.Date;
public class ReceiptVO {

	private int Receipt_id;
	private String donor_name;
	private String collection_mode;
	private String fund_name;
	private Date date;
	private int amount;
	private String details;
	public int getReceipt_id() {
		return Receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		Receipt_id = receipt_id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public String getCollection_mode() {
		return collection_mode;
	}
	public void setCollection_mode(String collection_mode) {
		this.collection_mode = collection_mode;
	}
	public String getFund_name() {
		return fund_name;
	}
	public void setFund_name(String fund_name) {
		this.fund_name = fund_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
