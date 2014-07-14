package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tgoodsfavorite entity. @author MyEclipse Persistence Tools
 */

public class Tgoodsfavorite implements java.io.Serializable {

	// Fields

	private Integer goodsFavoriteId;
	private Integer favoriteGroupId;
	private Integer goodsId;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Tgoodsfavorite() {
	}

	/** full constructor */
	public Tgoodsfavorite(Integer favoriteGroupId, Integer goodsId,
			Timestamp addTime) {
		this.favoriteGroupId = favoriteGroupId;
		this.goodsId = goodsId;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getGoodsFavoriteId() {
		return this.goodsFavoriteId;
	}

	public void setGoodsFavoriteId(Integer goodsFavoriteId) {
		this.goodsFavoriteId = goodsFavoriteId;
	}

	public Integer getFavoriteGroupId() {
		return this.favoriteGroupId;
	}

	public void setFavoriteGroupId(Integer favoriteGroupId) {
		this.favoriteGroupId = favoriteGroupId;
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