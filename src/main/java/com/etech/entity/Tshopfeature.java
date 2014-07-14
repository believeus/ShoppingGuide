package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshopfeature entity. @author MyEclipse Persistence Tools
 */

public class Tshopfeature implements java.io.Serializable {

	// Fields

	private Integer shopFeatureId;
	private Integer shopId;
	private Integer featureId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tshopfeature() {
	}

	/** full constructor */
	public Tshopfeature(Integer shopId, Integer featureId, Timestamp addTime) {
		this.shopId = shopId;
		this.featureId = featureId;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getShopFeatureId() {
		return this.shopFeatureId;
	}

	public void setShopFeatureId(Integer shopFeatureId) {
		this.shopFeatureId = shopFeatureId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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