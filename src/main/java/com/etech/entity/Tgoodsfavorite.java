package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoodsfavorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoodsfavorite", catalog = "dbshop")
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
	@Id
	@GeneratedValue
	@Column(name = "GoodsFavoriteID", nullable = false)
	public Integer getGoodsFavoriteId() {
		return this.goodsFavoriteId;
	}

	public void setGoodsFavoriteId(Integer goodsFavoriteId) {
		this.goodsFavoriteId = goodsFavoriteId;
	}

	@Column(name = "FavoriteGroupID", nullable = false)
	public Integer getFavoriteGroupId() {
		return this.favoriteGroupId;
	}

	public void setFavoriteGroupId(Integer favoriteGroupId) {
		this.favoriteGroupId = favoriteGroupId;
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