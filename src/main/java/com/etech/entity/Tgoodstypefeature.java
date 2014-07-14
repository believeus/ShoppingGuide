package com.etech.entity;

/**
 * Tgoodstypefeature entity. @author MyEclipse Persistence Tools
 */

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

	public Integer getGoodsTypeFeatureId() {
		return this.goodsTypeFeatureId;
	}

	public void setGoodsTypeFeatureId(Integer goodsTypeFeatureId) {
		this.goodsTypeFeatureId = goodsTypeFeatureId;
	}

	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

}