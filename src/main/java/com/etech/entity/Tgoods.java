package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tgoods entity. @author MyEclipse Persistence Tools
 */

public class Tgoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Integer shopId;
	private String goodsName;
	private Integer goodsTypeId;
	private Short isOnSale;
	private String goodsFeature;
	private String introduction;
	private Timestamp addTime;
	private Timestamp stateChangeTime;
	private Short isRecommend;
	private Short examineState;
	private String goodsPhotoUrl;
	private String goodsDefaultPhotoUrl;
	private Integer goodsDefaultPhotoWidth;
	private Integer goodsDefaultPhotoHeight;
	private Integer viewCount;
	private Integer bePraisedCount;

	// Constructors

	/** default constructor */
	public Tgoods() {
	}

	/** minimal constructor */
	public Tgoods(Integer shopId, String goodsName, Integer goodsTypeId,
			Short isOnSale, Timestamp addTime, Short isRecommend,
			Short examineState, Integer viewCount, Integer bePraisedCount) {
		this.shopId = shopId;
		this.goodsName = goodsName;
		this.goodsTypeId = goodsTypeId;
		this.isOnSale = isOnSale;
		this.addTime = addTime;
		this.isRecommend = isRecommend;
		this.examineState = examineState;
		this.viewCount = viewCount;
		this.bePraisedCount = bePraisedCount;
	}

	/** full constructor */
	public Tgoods(Integer shopId, String goodsName, Integer goodsTypeId,
			Short isOnSale, String goodsFeature, String introduction,
			Timestamp addTime, Timestamp stateChangeTime, Short isRecommend,
			Short examineState, String goodsPhotoUrl,
			String goodsDefaultPhotoUrl, Integer goodsDefaultPhotoWidth,
			Integer goodsDefaultPhotoHeight, Integer viewCount,
			Integer bePraisedCount) {
		this.shopId = shopId;
		this.goodsName = goodsName;
		this.goodsTypeId = goodsTypeId;
		this.isOnSale = isOnSale;
		this.goodsFeature = goodsFeature;
		this.introduction = introduction;
		this.addTime = addTime;
		this.stateChangeTime = stateChangeTime;
		this.isRecommend = isRecommend;
		this.examineState = examineState;
		this.goodsPhotoUrl = goodsPhotoUrl;
		this.goodsDefaultPhotoUrl = goodsDefaultPhotoUrl;
		this.goodsDefaultPhotoWidth = goodsDefaultPhotoWidth;
		this.goodsDefaultPhotoHeight = goodsDefaultPhotoHeight;
		this.viewCount = viewCount;
		this.bePraisedCount = bePraisedCount;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Short getIsOnSale() {
		return this.isOnSale;
	}

	public void setIsOnSale(Short isOnSale) {
		this.isOnSale = isOnSale;
	}

	public String getGoodsFeature() {
		return this.goodsFeature;
	}

	public void setGoodsFeature(String goodsFeature) {
		this.goodsFeature = goodsFeature;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getStateChangeTime() {
		return this.stateChangeTime;
	}

	public void setStateChangeTime(Timestamp stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

	public Short getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Short isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Short getExamineState() {
		return this.examineState;
	}

	public void setExamineState(Short examineState) {
		this.examineState = examineState;
	}

	public String getGoodsPhotoUrl() {
		return this.goodsPhotoUrl;
	}

	public void setGoodsPhotoUrl(String goodsPhotoUrl) {
		this.goodsPhotoUrl = goodsPhotoUrl;
	}

	public String getGoodsDefaultPhotoUrl() {
		return this.goodsDefaultPhotoUrl;
	}

	public void setGoodsDefaultPhotoUrl(String goodsDefaultPhotoUrl) {
		this.goodsDefaultPhotoUrl = goodsDefaultPhotoUrl;
	}

	public Integer getGoodsDefaultPhotoWidth() {
		return this.goodsDefaultPhotoWidth;
	}

	public void setGoodsDefaultPhotoWidth(Integer goodsDefaultPhotoWidth) {
		this.goodsDefaultPhotoWidth = goodsDefaultPhotoWidth;
	}

	public Integer getGoodsDefaultPhotoHeight() {
		return this.goodsDefaultPhotoHeight;
	}

	public void setGoodsDefaultPhotoHeight(Integer goodsDefaultPhotoHeight) {
		this.goodsDefaultPhotoHeight = goodsDefaultPhotoHeight;
	}

	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getBePraisedCount() {
		return this.bePraisedCount;
	}

	public void setBePraisedCount(Integer bePraisedCount) {
		this.bePraisedCount = bePraisedCount;
	}

}