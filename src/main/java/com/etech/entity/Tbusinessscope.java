package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tbusinessscope entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbusinessscope", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "BusinessScopeID", nullable = false)
	public Integer getBusinessScopeId() {
		return this.businessScopeId;
	}

	public void setBusinessScopeId(Integer businessScopeId) {
		this.businessScopeId = businessScopeId;
	}

	@Column(name = "ShopID", nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name = "GoodsTypeID", nullable = false)
	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

}