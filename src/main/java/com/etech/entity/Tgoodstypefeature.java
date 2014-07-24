package com.etech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodstypefeature entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodstypefeature", catalog = "dbshop")
public class Tgoodstypefeature implements java.io.Serializable {

	// Fields

	private Integer goodsTypeFeatureId;
	private Integer goodsTypeId;
	private Integer featureId;

	// Constructors

	/** default constructor */
	public Tgoodstypefeature() {
	}

	/** full constructor */
	public Tgoodstypefeature(Integer goodsTypeId, Integer featureId) {
		this.goodsTypeId = goodsTypeId;
		this.featureId = featureId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GoodsTypeFeatureID", unique = true, nullable = false)
	public Integer getGoodsTypeFeatureId() {
		return this.goodsTypeFeatureId;
	}

	public void setGoodsTypeFeatureId(Integer goodsTypeFeatureId) {
		this.goodsTypeFeatureId = goodsTypeFeatureId;
	}

	@Column(name = "GoodsTypeID", nullable = false)
	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	@Column(name = "FeatureID", nullable = false)
	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

}