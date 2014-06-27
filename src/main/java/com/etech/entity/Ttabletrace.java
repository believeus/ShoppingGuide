package com.etech.entity;

import java.sql.Timestamp;

/**
 * Ttabletrace entity. @author MyEclipse Persistence Tools
 */

public class Ttabletrace implements java.io.Serializable {

	// Fields

	private String tableName;
	private Integer stampId;
	private Timestamp lastChangeTime;

	// Constructors

	/** default constructor */
	public Ttabletrace() {
	}

	/** minimal constructor */
	public Ttabletrace(Integer stampId) {
		this.stampId = stampId;
	}

	/** full constructor */
	public Ttabletrace(Integer stampId, Timestamp lastChangeTime) {
		this.stampId = stampId;
		this.lastChangeTime = lastChangeTime;
	}

	// Property accessors

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getStampId() {
		return this.stampId;
	}

	public void setStampId(Integer stampId) {
		this.stampId = stampId;
	}

	public Timestamp getLastChangeTime() {
		return this.lastChangeTime;
	}

	public void setLastChangeTime(Timestamp lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}

}