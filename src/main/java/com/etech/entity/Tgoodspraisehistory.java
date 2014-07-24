package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodspraisehistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodspraisehistory", catalog = "dbshop")
public class Tgoodspraisehistory implements java.io.Serializable {

	// Fields

	private Integer goodsPraiseHistoryId;
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
	@Id
	@GeneratedValue
	@Column(name = "GoodsPraiseHistoryID", unique = true, nullable = false)
	public Integer getGoodsPraiseHistoryId() {
		return this.goodsPraiseHistoryId;
	}

	public void setGoodsPraiseHistoryId(Integer goodsPraiseHistoryId) {
		this.goodsPraiseHistoryId = goodsPraiseHistoryId;
	}

	@Column(name = "PhoneUserID", nullable = false)
	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	@Column(name = "GoodsID", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}