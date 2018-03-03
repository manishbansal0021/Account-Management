package com.example.accountmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_detail")
public class CreditDetail {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="pname")
	private String pname;
	@Column(name="pdate")
	private String pdate;
	@Column(name="tilename")
	private String tilename;
	@Column(name="size")
	private String size;
	@Column(name="quantity")
	private int quantity;
	@Column(name="rate")
	private int rate;
	@Column(name="depositamt")
	private int depositamt;
	
	
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
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getDepositamt() {
		return depositamt;
	}
	public void setDepositamt(int depositamt) {
		this.depositamt = depositamt;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}

