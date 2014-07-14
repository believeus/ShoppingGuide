package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshoppraisehistory entity. @author MyEclipse Persistence Tools
 */

public class Tshoppraisehistory implements java.io.Serializable {

	// Fields

	private Integer shopViewHistoryId;
	private Integer phoneUserId;
	private Integer shopId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tshoppraisehistory() {
	}

	/** full constructor */
	public Tshoppraisehistory(Integer phoneUserId, Integer shopId,
			Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.shopId = shopId;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getShopViewHistoryId() {
		return this.shopViewHistoryId;
	}

	public void setShopViewHistoryId(Integer shopViewHistoryId) {
		this.shopViewHistoryId = shopViewHistoryId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}