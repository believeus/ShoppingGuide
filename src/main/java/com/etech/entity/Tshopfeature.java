package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tshopfeature", catalog = "dbshop")
public class Tshopfeature implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -1554610193552004000L;
	private Integer shopFeatureId;
	private Integer shopId;
	private Integer featureId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tshopfeature() {
	}

	/** full constructor */
	public Tshopfeature(Integer shopId, Integer featureId, Timestamp addTime) {
		this.shopId = shopId;
		this.featureId = featureId;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopFeatureID", nullable = false)
	public Integer getShopFeatureId() {
		return this.shopFeatureId;
	}

	public void setShopFeatureId(Integer shopFeatureId) {
		this.shopFeatureId = shopFeatureId;
	}

	@Column(name = "ShopID", nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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