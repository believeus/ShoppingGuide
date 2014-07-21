package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tshoppraisehistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshoppraisehistory", catalog = "dbshop")
public class Tshoppraisehistory implements java.io.Serializable {

	// Fields

	private Integer shopPraiseHistoryId;
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
	@Id
	@GeneratedValue
	@Column(name = "ShopPraiseHistoryID", nullable = false)
	public Integer getShopPraiseHistoryId() {
		return this.shopPraiseHistoryId;
	}

	public void setShopPraiseHistoryId(Integer shopPraiseHistoryId) {
		this.shopPraiseHistoryId = shopPraiseHistoryId;
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