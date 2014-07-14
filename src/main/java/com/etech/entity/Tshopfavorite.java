package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tshopfavorite entity. @author MyEclipse Persistence Tools
 */

public class Tshopfavorite implements java.io.Serializable {

	// Fields

	private Integer shopFavoriteId;
	private Integer favoriteGroupId;
	private Integer shopId;
	private String fansNickName;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tshopfavorite() {
	}

	/** full constructor */
	public Tshopfavorite(Integer favoriteGroupId, Integer shopId,
			String fansNickName, Timestamp addTime) {
		this.favoriteGroupId = favoriteGroupId;
		this.shopId = shopId;
		this.fansNickName = fansNickName;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getShopFavoriteId() {
		return this.shopFavoriteId;
	}

	public void setShopFavoriteId(Integer shopFavoriteId) {
		this.shopFavoriteId = shopFavoriteId;
	}

	public Integer getFavoriteGroupId() {
		return this.favoriteGroupId;
	}

	public void setFavoriteGroupId(Integer favoriteGroupId) {
		this.favoriteGroupId = favoriteGroupId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getFansNickName() {
		return this.fansNickName;
	}

	public void setFansNickName(String fansNickName) {
		this.fansNickName = fansNickName;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}