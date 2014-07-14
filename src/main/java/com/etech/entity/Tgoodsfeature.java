package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tgoodsfeature entity. @author MyEclipse Persistence Tools
 */

public class Tgoodsfeature implements java.io.Serializable {

	// Fields

	private Integer goodsFeatureId;
	private Integer goodsId;
	private Integer featureId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tgoodsfeature() {
	}

	/** full constructor */
	public Tgoodsfeature(Integer goodsId, Integer featureId, Timestamp addTime) {
		this.goodsId = goodsId;
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

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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