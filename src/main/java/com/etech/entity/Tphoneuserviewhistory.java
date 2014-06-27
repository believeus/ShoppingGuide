package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tphoneuserviewhistory entity. @author MyEclipse Persistence Tools
 */

public class Tphoneuserviewhistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short viewObject;
	private Integer objectId;
	private Timestamp viewTime;

	// Constructors

	/** default constructor */
	public Tphoneuserviewhistory() {
	}

	/** full constructor */
	public Tphoneuserviewhistory(Short viewObject, Integer objectId,
			Timestamp viewTime) {
		this.viewObject = viewObject;
		this.objectId = objectId;
		this.viewTime = viewTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getViewObject() {
		return this.viewObject;
	}

	public void setViewObject(Short viewObject) {
		this.viewObject = viewObject;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Timestamp getViewTime() {
		return this.viewTime;
	}

	public void setViewTime(Timestamp viewTime) {
		this.viewTime = viewTime;
	}

}