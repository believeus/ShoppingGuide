package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tgoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tgoods", catalog = "dbshop")
public class Tgoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Integer shopId;
	private String goodsName;
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
	private Integer publishUserId;
	private Short publishFlag;

	// Constructors

	/** default constructor */
	public Tgoods() {
	}

	/** minimal constructor */
	public Tgoods(Integer shopId, String goodsName, Short isOnSale,
			Timestamp addTime, Short isRecommend, Short examineState,
			Integer viewCount, Integer bePraisedCount, Integer publishUserId,
			Short publishFlag) {
		this.shopId = shopId;
		this.goodsName = goodsName;
		this.isOnSale = isOnSale;
		this.addTime = addTime;
		this.isRecommend = isRecommend;
		this.examineState = examineState;
		this.viewCount = viewCount;
		this.bePraisedCount = bePraisedCount;
		this.publishUserId = publishUserId;
		this.publishFlag = publishFlag;
	}

	/** full constructor */
	public Tgoods(Integer shopId, String goodsName, Short isOnSale,
			String goodsFeature, String introduction, Timestamp addTime,
			Timestamp stateChangeTime, Short isRecommend, Short examineState,
			String goodsPhotoUrl, String goodsDefaultPhotoUrl,
			Integer goodsDefaultPhotoWidth, Integer goodsDefaultPhotoHeight,
			Integer viewCount, Integer bePraisedCount, Integer publishUserId,
			Short publishFlag) {
		this.shopId = shopId;
		this.goodsName = goodsName;
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
		this.publishUserId = publishUserId;
		this.publishFlag = publishFlag;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "GoodsID", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "ShopID", nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Column(name = "GoodsName", nullable = false, length = 100)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "IsOnSale", nullable = false)
	public Short getIsOnSale() {
		return this.isOnSale;
	}

	public void setIsOnSale(Short isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Column(name = "GoodsFeature", length = 65535)
	public String getGoodsFeature() {
		return this.goodsFeature;
	}

	public void setGoodsFeature(String goodsFeature) {
		this.goodsFeature = goodsFeature;
	}

	@Column(name = "Introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "AddTime", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "StateChangeTime", length = 19)
	public Timestamp getStateChangeTime() {
		return this.stateChangeTime;
	}

	public void setStateChangeTime(Timestamp stateChangeTime) {
		this.stateChangeTime = stateChangeTime;
	}

	@Column(name = "IsRecommend", nullable = false)
	public Short getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Short isRecommend) {
		this.isRecommend = isRecommend;
	}

	@Column(name = "ExamineState", nullable = false)
	public Short getExamineState() {
		return this.examineState;
	}

	public void setExamineState(Short examineState) {
		this.examineState = examineState;
	}

	@Column(name = "GoodsPhotoURL", length = 65535)
	public String getGoodsPhotoUrl() {
		return this.goodsPhotoUrl;
	}

	public void setGoodsPhotoUrl(String goodsPhotoUrl) {
		this.goodsPhotoUrl = goodsPhotoUrl;
	}

	@Column(name = "GoodsDefaultPhotoURL", length = 65535)
	public String getGoodsDefaultPhotoUrl() {
		return this.goodsDefaultPhotoUrl;
	}

	public void setGoodsDefaultPhotoUrl(String goodsDefaultPhotoUrl) {
		this.goodsDefaultPhotoUrl = goodsDefaultPhotoUrl;
	}

	@Column(name = "GoodsDefaultPhotoWidth")
	public Integer getGoodsDefaultPhotoWidth() {
		return this.goodsDefaultPhotoWidth;
	}

	public void setGoodsDefaultPhotoWidth(Integer goodsDefaultPhotoWidth) {
		this.goodsDefaultPhotoWidth = goodsDefaultPhotoWidth;
	}

	@Column(name = "GoodsDefaultPhotoHeight")
	public Integer getGoodsDefaultPhotoHeight() {
		return this.goodsDefaultPhotoHeight;
	}

	public void setGoodsDefaultPhotoHeight(Integer goodsDefaultPhotoHeight) {
		this.goodsDefaultPhotoHeight = goodsDefaultPhotoHeight;
	}

	@Column(name = "ViewCount", nullable = false)
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "BePraisedCount", nullable = false)
	public Integer getBePraisedCount() {
		return this.bePraisedCount;
	}

	public void setBePraisedCount(Integer bePraisedCount) {
		this.bePraisedCount = bePraisedCount;
	}

	@Column(name = "PublishUserID", nullable = false)
	public Integer getPublishUserId() {
		return this.publishUserId;
	}

	public void setPublishUserId(Integer publishUserId) {
		this.publishUserId = publishUserId;
	}

	@Column(name = "PublishFlag", nullable = false)
	public Short getPublishFlag() {
		return this.publishFlag;
	}

	public void setPublishFlag(Short publishFlag) {
		this.publishFlag = publishFlag;
	}

}