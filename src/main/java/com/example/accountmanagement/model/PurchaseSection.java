package com.example.accountmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "purchaseSection")
public class PurchaseSection {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	@Column(name = "tilename")
	private String tilename;
	
	@Column(name = "pdate")
	private String pdate;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPdate() {
		return pdate;
	}
	
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	public String getTilename() {
		return tilename;
	}
	
	public void setTilename(String tilename) {
		this.tilename = tilename;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
