package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tgoodspraisehistory entity. @author MyEclipse Persistence Tools
 */

public class Tgoodspraisehistory implements java.io.Serializable {

	// Fields

	private Integer goodsViewHistoryId;
	private Integer phoneUserId;
	private Integer goodsId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tgoodspraisehistory() {
	}

	/** full constructor */
	public Tgoodspraisehistory(Integer phoneUserId, Integer goodsId,
			Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.goodsId = goodsId;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getGoodsViewHistoryId() {
		return this.goodsViewHistoryId;
	}

	public void setGoodsViewHistoryId(Integer goodsViewHistoryId) {
		this.goodsViewHistoryId = goodsViewHistoryId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}