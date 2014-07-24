package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tshopbusinessscope entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshopbusinessscope", catalog = "dbshop")
public class Tshopbusinessscope implements java.io.Serializable {

	// Fields

	private Integer shopBusinessScopeId;
	private Integer shopId;
	private Integer goodsTypeId;

	// Constructors

	/** default constructor */
	public Tshopbusinessscope() {
	}

	/** full constructor */
	public Tshopbusinessscope(Integer shopId, Integer goodsTypeId) {
		this.shopId = shopId;
		this.goodsTypeId = goodsTypeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopBusinessScopeID", unique = true, nullable = false)
	public Integer getShopBusinessScopeId() {
		return this.shopBusinessScopeId;
	}

	public void setShopBusinessScopeId(Integer shopBusinessScopeId) {
		this.shopBusinessScopeId = shopBusinessScopeId;
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