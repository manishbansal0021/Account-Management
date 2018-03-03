package com.example.accountmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {
	@Id
	@Column(name = "Tilename")
	private String tilename;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "Available_Stock")
	private int availablestock;

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

	public int getAvailablestock() {
		return availablestock;
	}

	public void setAvailablestock(int availablestock) {
		this.availablestock = availablestock;
	}
}