package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tshopviewhistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshopviewhistory", catalog = "dbshop")
public class Tshopviewhistory implements java.io.Serializable {

	// Fields

	private Integer shopViewHistoryId;
	private Integer phoneUserId;
	private Integer shopId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tshopviewhistory() {
	}

	/** full constructor */
	public Tshopviewhistory(Integer phoneUserId, Integer shopId,
			Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.shopId = shopId;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ShopViewHistoryID", unique = true, nullable = false)
	public Integer getShopViewHistoryId() {
		return this.shopViewHistoryId;
	}

	public void setShopViewHistoryId(Integer shopViewHistoryId) {
		this.shopViewHistoryId = shopViewHistoryId;
	}

	@Column(name = "PhoneUserID", nullable = false)
	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	@Column(name = "ShopID", nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}