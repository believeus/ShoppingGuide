package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tgoods entity. @author MyEclipse Persistence Tools
 */

public class Tgoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Tshops tshops;
	private String name;
	private Integer typeOfGoodsId;
	private String goodsBrand;
	private Float price;
	private Float discount;
	private Integer isOnSale;
	private String salesStatus;
	private String introduction;
	private String photosUrl;
	private Timestamp publishTime;
	private Integer publishUserId;
	private Integer pageView;
	private String keywords;
	private Timestamp stateChangeTime;

	// Constructors

	/** default constructor */
	public Tgoods() {
	}

	/** minimal constructor */
	public Tgoods(Tshops tshops, String name, Integer typeOfGoodsId,
			Float discount, Integer isOnSale, Timestamp publishTime,
			Integer publishUserId, Integer pageView) {
		this.tshops = tshops;
		this.name = name;
		this.typeOfGoodsId = typeOfGoodsId;
		this.discount = discount;
		this.isOnSale = isOnSale;
		this.publishTime = publishTime;
		this.publishUserId = publishUserId;
		this.pageView = pageView;
	}

	/** full constructor */
	public Tgoods(Tshops tshops, String name, Integer typeOfGoodsId,
			String goodsBrand, Float price, Float discount, Integer isOnSale,
			String salesStatus, String introduction, String photosUrl,
			Timestamp publishTime, Integer publishUserId, Integer pageView,
			String keywords, Timestamp stateChangeTime) {
		this.tshops = tshops;
		this.name = name;
		this.typeOfGoodsId = typeOfGoodsId;
		this.goodsBrand = goodsBrand;
		this.price = price;
		this.discount = discount;
		this.isOnSale = isOnSale;
		this.salesStatus = salesStatus;
		this.introduction = introduction;
		this.photosUrl = photosUrl;
		this.publishTime = publishTime;
		this.publishUserId = publishUserId;
		this.pageView = pageView;
		this.keywords = keywords;
		this.stateChangeTime = stateChangeTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tshops getTshops() {
		return this.tshops;
	}

	public void setTshops(Tshops tshops) {
		this.tshops = tshops;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTypeOfGoodsId() {
		return this.typeOfGoodsId;
	}

	public void setTypeOfGoodsId(Integer typeOfGoodsId) {
		this.typeOfGoodsId = typeOfGoodsId;
	}

	public String getGoodsBrand() {
		return this.goodsBrand;
	}

	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getIsOnSale() {
		return this.isOnSale;
	}

	public void setIsOnSale(Integer isOnSale) {
		this.isOnSale = isOnSale;
	}

	public String getSalesStatus() {
		return this.salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPhotosUrl() {
		return this.photosUrl;
	}

	public void setPhotosUrl(String photosUrl) {
		this.photosUrl = photosUrl;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getPublishUserId() {
		return this.publishUserId;
	}

	public void setPublishUserId(Integer publishUserId) {
		this.publishUserId = publishUserId;
	}

	public Integer getPageView() {
		return this.pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Timestamp getStateChangeTime() {
		return this.stateChangeTime;
	}

	public void setStateChangeTime(Timestamp stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

}