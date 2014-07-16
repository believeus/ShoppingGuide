package com.etech.entity;

import java.sql.Timestamp;

/**
 * TtabletraceId entity. @author MyEclipse Persistence Tools
 */

public class TtabletraceId implements java.io.Serializable {

	// Fields

	private String tableName;
	private Integer stampId;
	private Timestamp lastChangeTime;

	// Constructors

	/** default constructor */
	public TtabletraceId() {
	}

	/** full constructor */
	public TtabletraceId(String tableName, Integer stampId,
			Timestamp lastChangeTime) {
		this.tableName = tableName;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TtabletraceId))
			return false;
		TtabletraceId castOther = (TtabletraceId) other;

		return ((this.getTableName() == castOther.getTableName()) || (this
				.getTableName() != null && castOther.getTableName() != null && this
				.getTableName().equals(castOther.getTableName())))
				&& ((this.getStampId() == castOther.getStampId()) || (this
						.getStampId() != null && castOther.getStampId() != null && this
						.getStampId().equals(castOther.getStampId())))
				&& ((this.getLastChangeTime() == castOther.getLastChangeTime()) || (this
						.getLastChangeTime() != null
						&& castOther.getLastChangeTime() != null && this
						.getLastChangeTime().equals(
								castOther.getLastChangeTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result
				+ (getStampId() == null ? 0 : this.getStampId().hashCode());
		result = 37
				* result
				+ (getLastChangeTime() == null ? 0 : this.getLastChangeTime()
						.hashCode());
		return result;
	}

}