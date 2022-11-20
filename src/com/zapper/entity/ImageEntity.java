package com.zapper.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Uploaded_Images")
public class ImageEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String path ;
	
	@Temporal(TemporalType.DATE)
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
