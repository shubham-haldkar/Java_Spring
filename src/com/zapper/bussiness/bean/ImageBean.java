package com.zapper.bussiness.bean;

import java.util.Date;

public class ImageBean {

	private int id ;
	private String path ;
	private Date insertTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	
	
	@Override
	public String toString() {
		return "ImageBean [id=" + id + ", path=" + path + ", insertTime=" + insertTime + "]";
	}
	
	
}
