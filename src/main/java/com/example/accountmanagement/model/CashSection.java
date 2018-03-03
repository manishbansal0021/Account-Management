package com.example.accountmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cash_Section")

public class CashSection {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "partyname")
	private String partyname;
	
	@Column(name = "cashreceived")
	private int cashreceived;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	public int getCashreceived() {
		return cashreceived;
	}

	public void setCashreceived(int cashreceived) {
		this.cashreceived = cashreceived;
	}
	
}
