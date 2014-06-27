package com.etech.entity;

import java.sql.Timestamp;

/**
 * TeventCountdataeveryday entity. @author MyEclipse Persistence Tools
 */

public class TeventCountdataeveryday implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer shopUserCount;
	private Integer shopUserValidCount;
	private Integer shopUserActiveCount;
	private Integer goodsCount;
	private Integer goodsValidCount;
	private Integer phoneUserCount;
	private Integer phoneUserActiveCount;
	private Integer activityCount;
	private Integer activityValidCount;
	private Timestamp countDate;

	// Constructors

	/** default constructor */
	public TeventCountdataeveryday() {
	}

	/** full constructor */
	public TeventCountdataeveryday(Integer shopUserCount,
			Integer shopUserValidCount, Integer shopUserActiveCount,
			Integer goodsCount, Integer goodsValidCount,
			Integer phoneUserCount, Integer phoneUserActiveCount,
			Integer activityCount, Integer activityValidCount,
			Timestamp countDate) {
		this.shopUserCount = shopUserCount;
		this.shopUserValidCount = shopUserValidCount;
		this.shopUserActiveCount = shopUserActiveCount;
		this.goodsCount = goodsCount;
		this.goodsValidCount = goodsValidCount;
		this.phoneUserCount = phoneUserCount;
		this.phoneUserActiveCount = phoneUserActiveCount;
		this.activityCount = activityCount;
		this.activityValidCount = activityValidCount;
		this.countDate = countDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopUserCount() {
		return this.shopUserCount;
	}

	public void setShopUserCount(Integer shopUserCount) {
		this.shopUserCount = shopUserCount;
	}

	public Integer getShopUserValidCount() {
		return this.shopUserValidCount;
	}

	public void setShopUserValidCount(Integer shopUserValidCount) {
		this.shopUserValidCount = shopUserValidCount;
	}

	public Integer getShopUserActiveCount() {
		return this.shopUserActiveCount;
	}

	public void setShopUserActiveCount(Integer shopUserActiveCount) {
		this.shopUserActiveCount = shopUserActiveCount;
	}

	public Integer getGoodsCount() {
		return this.goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Integer getGoodsValidCount() {
		return this.goodsValidCount;
	}

	public void setGoodsValidCount(Integer goodsValidCount) {
		this.goodsValidCount = goodsValidCount;
	}

	public Integer getPhoneUserCount() {
		return this.phoneUserCount;
	}

	public void setPhoneUserCount(Integer phoneUserCount) {
		this.phoneUserCount = phoneUserCount;
	}

	public Integer getPhoneUserActiveCount() {
		return this.phoneUserActiveCount;
	}

	public void setPhoneUserActiveCount(Integer phoneUserActiveCount) {
		this.phoneUserActiveCount = phoneUserActiveCount;
	}

	public Integer getActivityCount() {
		return this.activityCount;
	}

	public void setActivityCount(Integer activityCount) {
		this.activityCount = activityCount;
	}

	public Integer getActivityValidCount() {
		return this.activityValidCount;
	}

	public void setActivityValidCount(Integer activityValidCount) {
		this.activityValidCount = activityValidCount;
	}

	public Timestamp getCountDate() {
		return this.countDate;
	}

	public void setCountDate(Timestamp countDate) {
		this.countDate = countDate;
	}

}