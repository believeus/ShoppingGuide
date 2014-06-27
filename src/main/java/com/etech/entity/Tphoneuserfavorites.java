package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tphoneuserfavorites entity. @author MyEclipse Persistence Tools
 */

public class Tphoneuserfavorites implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short type;
	private Integer objectId;
	private Integer phoneUserId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tphoneuserfavorites() {
	}

	/** full constructor */
	public Tphoneuserfavorites(Short type, Integer objectId,
			Integer phoneUserId, Timestamp addTime) {
		this.type = type;
		this.objectId = objectId;
		this.phoneUserId = phoneUserId;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}