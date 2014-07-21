package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tshopusershoprelation entity. @author MyEclipse Persistence Tools
 */
public class Tshopusershoprelation implements java.io.Serializable {

	private static final long serialVersionUID = -8528593388678127856L;
	private Integer shopUserShopRelationId;
	private Integer shopUserId;
	private Integer shopId;

	// Constructors

	/** default constructor */
	public Tshopusershoprelation() {
	}

	/** full constructor */
	public Tshopusershoprelation(Integer shopUserId, Integer shopId) {
		this.shopUserId = shopUserId;
		this.shopId = shopId;
	}

	public Integer getShopUserShopRelationId() {
		return this.shopUserShopRelationId;
	}

	public void setShopUserShopRelationId(Integer shopUserShopRelationId) {
		this.shopUserShopRelationId = shopUserShopRelationId;
	}

	public Integer getShopUserId() {
		return this.shopUserId;
	}

	public void setShopUserId(Integer shopUserId) {
		this.shopUserId = shopUserId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

}