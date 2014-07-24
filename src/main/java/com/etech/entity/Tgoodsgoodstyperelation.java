package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodsgoodstyperelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodsgoodstyperelation", catalog = "dbshop")
public class Tgoodsgoodstyperelation implements java.io.Serializable {

	// Fields

	private Integer goodsGoodsTypeRelationId;
	private Integer goodsId;
	private Integer goodsTypeId;

	// Constructors

	/** default constructor */
	public Tgoodsgoodstyperelation() {
	}

	/** full constructor */
	public Tgoodsgoodstyperelation(Integer goodsId, Integer goodsTypeId) {
		this.goodsId = goodsId;
		this.goodsTypeId = goodsTypeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GoodsGoodsTypeRelationID", unique = true, nullable = false)
	public Integer getGoodsGoodsTypeRelationId() {
		return this.goodsGoodsTypeRelationId;
	}

	public void setGoodsGoodsTypeRelationId(Integer goodsGoodsTypeRelationId) {
		this.goodsGoodsTypeRelationId = goodsGoodsTypeRelationId;
	}

	@Column(name = "GoodsID", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "GoodsTypeID", nullable = false)
	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

}