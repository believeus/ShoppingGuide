package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodsviewhistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodsviewhistory", catalog = "dbshop")
public class Tgoodsviewhistory implements java.io.Serializable {

	// Fields

	private Integer goodsViewHistoryId;
	private Integer phoneUserId;
	private Integer goodsId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tgoodsviewhistory() {
	}

	/** full constructor */
	public Tgoodsviewhistory(Integer phoneUserId, Integer goodsId,
			Timestamp addTime) {
		this.phoneUserId = phoneUserId;
		this.goodsId = goodsId;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GoodsViewHistoryID", unique = true, nullable = false)
	public Integer getGoodsViewHistoryId() {
		return this.goodsViewHistoryId;
	}

	public void setGoodsViewHistoryId(Integer goodsViewHistoryId) {
		this.goodsViewHistoryId = goodsViewHistoryId;
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