package com.etech.entity;

/**
 * Tbusinessscope entity. @author MyEclipse Persistence Tools
 */

public class Tbusinessscope implements java.io.Serializable {

	// Fields

	private Integer businessScopeId;
	private Integer shopId;
	private Integer goodsTypeId;

	// Constructors

	/** default constructor */
	public Tbusinessscope() {
	}

	/** full constructor */
	public Tbusinessscope(Integer shopId, Integer goodsTypeId) {
		this.shopId = shopId;
		this.goodsTypeId = goodsTypeId;
	}

	// Property accessors

	public Integer getBusinessScopeId() {
		return this.businessScopeId;
	}

	public void setBusinessScopeId(Integer businessScopeId) {
		this.businessScopeId = businessScopeId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

}