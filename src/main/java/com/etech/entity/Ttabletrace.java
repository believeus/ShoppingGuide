package com.etech.entity;

import java.sql.Timestamp;

/**
 * Ttabletrace entity. @author MyEclipse Persistence Tools
 */

public class Ttabletrace implements java.io.Serializable {

	// Fields
	private String tableName;
	private Integer stampID;
	private Timestamp lastChangeTime;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Integer getStampID() {
		return stampID;
	}
	public void setStampID(Integer stampID) {
		this.stampID = stampID;
	}
	public Timestamp getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(Timestamp lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
	
	

}