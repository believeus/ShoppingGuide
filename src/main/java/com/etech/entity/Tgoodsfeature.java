package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodsfeature entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodsfeature", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "GoodsFeatureID", nullable = false)
	public Integer getGoodsFeatureId() {
		return this.goodsFeatureId;
	}

	public void setGoodsFeatureId(Integer goodsFeatureId) {
		this.goodsFeatureId = goodsFeatureId;
	}

	@Column(name = "GoodsID", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "FeatureID", nullable = false)
	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}