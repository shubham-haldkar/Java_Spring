package com.zapper.bussiness.bean;

import java.util.Date;

public class InventoryBean {
	private int id;
	private String inventoryName ; 

	private int stock ;
	private Date insertTime;
	private String status ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "InventoryBean [id=" + id + ", inventoryName=" + inventoryName + ", stock=" + stock + ", insertTime="
				+ insertTime + ", status=" + status + "]";
	}
 
	
	
}
