package com.example.accountmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sales_Section")
public class SaleSection {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int id;
	
	@Column(name = "tilename")
	private String tilename;
	
	@Column(name = "Sdate")
	private String sdate;
	
	@Column(name = "partyname")
	private String partyname;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "Rate")
	private int rate;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "Saletype")
	private String saletype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTilename() {
		return tilename;
	}
	public void setTilename(String tilename) {
		this.tilename = tilename;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSaletype() {
		return saletype;
	}
	public void setSaletype(String saletype) {
		this.saletype = saletype;
	}
}
