package com.etech.entity;

/**
 * Tshopusershoprelation entity. @author MyEclipse Persistence Tools
 */

public class Tshopusershoprelation implements java.io.Serializable {

	// Fields

	private Integer shopUserShopRelationId;
	private Integer shopUserId;
	private Integer shopId;
	private Short isDefaultShop;

	// Constructors

	/** default constructor */
	public Tshopusershoprelation() {
	}

	/** full constructor */
	public Tshopusershoprelation(Integer shopUserId, Integer shopId,
			Short isDefaultShop) {
		this.shopUserId = shopUserId;
		this.shopId = shopId;
		this.isDefaultShop = isDefaultShop;
	}

	// Property accessors

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

	public Short getIsDefaultShop() {
		return this.isDefaultShop;
	}

	public void setIsDefaultShop(Short isDefaultShop) {
		this.isDefaultShop = isDefaultShop;
	}

}