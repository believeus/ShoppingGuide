package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tshopfavorite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tshopfavorite", catalog = "dbshop")
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

	/** minimal constructor */
	public Tshopfavorite(Integer favoriteGroupId, Integer shopId,
			Timestamp addTime) {
		this.favoriteGroupId = favoriteGroupId;
		this.shopId = shopId;
		this.addTime = addTime;
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
	@Id
	@GeneratedValue
	@Column(name = "ShopFavoriteID", unique = true, nullable = false)
	public Integer getShopFavoriteId() {
		return this.shopFavoriteId;
	}

	public void setShopFavoriteId(Integer shopFavoriteId) {
		this.shopFavoriteId = shopFavoriteId;
	}

	@Column(name = "FavoriteGroupID", nullable = false)
	public Integer getFavoriteGroupId() {
		return this.favoriteGroupId;
	}

	public void setFavoriteGroupId(Integer favoriteGroupId) {
		this.favoriteGroupId = favoriteGroupId;
	}

	@Column(name = "ShopID", nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name = "FansNickName", length = 50)
	public String getFansNickName() {
		return this.fansNickName;
	}

	public void setFansNickName(String fansNickName) {
		this.fansNickName = fansNickName;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}