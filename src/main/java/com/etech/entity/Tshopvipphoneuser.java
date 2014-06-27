package com.etech.entity;

/**
 * Tshopvipphoneuser entity. @author MyEclipse Persistence Tools
 */

public class Tshopvipphoneuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer shopId;
	private Integer phoneUserId;
	private Integer vipLevelId;
	private Integer score;

	// Constructors

	/** default constructor */
	public Tshopvipphoneuser() {
	}

	/** full constructor */
	public Tshopvipphoneuser(Integer shopId, Integer phoneUserId,
			Integer vipLevelId, Integer score) {
		this.shopId = shopId;
		this.phoneUserId = phoneUserId;
		this.vipLevelId = vipLevelId;
		this.score = score;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getPhoneUserId() {
		return this.phoneUserId;
	}

	public void setPhoneUserId(Integer phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public Integer getVipLevelId() {
		return this.vipLevelId;
	}

	public void setVipLevelId(Integer vipLevelId) {
		this.vipLevelId = vipLevelId;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}