package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tphoneuserfeature entity. @author MyEclipse Persistence Tools
 */

public class Tphoneuserfeature implements java.io.Serializable {

	// Fields

	private Integer goodsFeatureId;
	private Integer phoneUserId;
	private Integer featureId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tphoneuserfeature() {
	}

	/** full constructor */
	public Tphoneuserfeature(Integer phoneUserId, Integer featureId,
			Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.featureId = featureId;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getGoodsFeatureId() {
		return this.goodsFeatureId;
	}

	public void setGoodsFeatureId(Integer goodsFeatureId) {
		this.goodsFeatureId = goodsFeatureId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}