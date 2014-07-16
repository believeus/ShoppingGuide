package com.etech.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TeventCountdataeveryday entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tevent_countdataeveryday", catalog = "dbshop")
public class TeventCountdataeveryday implements java.io.Serializable {

	// Fields

	private Integer eventId;
	private Integer shopUserCount;
	private Integer shopUserValidCount;
	private Integer shopUserActiveCount;
	private Integer goodsCount;
	private Integer goodsValidCoun;
	private Integer phoneUserCount;
	private Integer phoneUserActiveCount;
	private Timestamp countDate;

	// Constructors

	/** default constructor */
	public TeventCountdataeveryday() {
	}

	/** full constructor */
	public TeventCountdataeveryday(Integer shopUserCount,
			Integer shopUserValidCount, Integer shopUserActiveCount,
			Integer goodsCount, Integer goodsValidCoun, Integer phoneUserCount,
			Integer phoneUserActiveCount, Timestamp countDate) {
		this.shopUserCount = shopUserCount;
		this.shopUserValidCount = shopUserValidCount;
		this.shopUserActiveCount = shopUserActiveCount;
		this.goodsCount = goodsCount;
		this.goodsValidCoun = goodsValidCoun;
		this.phoneUserCount = phoneUserCount;
		this.phoneUserActiveCount = phoneUserActiveCount;
		this.countDate = countDate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "EventID", nullable = false)
	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Column(name = "ShopUserCount", nullable = false)
	public Integer getShopUserCount() {
		return this.shopUserCount;
	}

	public void setShopUserCount(Integer shopUserCount) {
		this.shopUserCount = shopUserCount;
	}

	@Column(name = "ShopUserValidCount", nullable = false)
	public Integer getShopUserValidCount() {
		return this.shopUserValidCount;
	}

	public void setShopUserValidCount(Integer shopUserValidCount) {
		this.shopUserValidCount = shopUserValidCount;
	}

	@Column(name = "ShopUserActiveCount", nullable = false)
	public Integer getShopUserActiveCount() {
		return this.shopUserActiveCount;
	}

	public void setShopUserActiveCount(Integer shopUserActiveCount) {
		this.shopUserActiveCount = shopUserActiveCount;
	}

	@Column(name = "GoodsCount", nullable = false)
	public Integer getGoodsCount() {
		return this.goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	@Column(name = "GoodsValidCoun", nullable = false)
	public Integer getGoodsValidCoun() {
		return this.goodsValidCoun;
	}

	public void setGoodsValidCoun(Integer goodsValidCoun) {
		this.goodsValidCoun = goodsValidCoun;
	}

	@Column(name = "PhoneUserCount", nullable = false)
	public Integer getPhoneUserCount() {
		return this.phoneUserCount;
	}

	public void setPhoneUserCount(Integer phoneUserCount) {
		this.phoneUserCount = phoneUserCount;
	}

	@Column(name = "PhoneUserActiveCount", nullable = false)
	public Integer getPhoneUserActiveCount() {
		return this.phoneUserActiveCount;
	}

	public void setPhoneUserActiveCount(Integer phoneUserActiveCount) {
		this.phoneUserActiveCount = phoneUserActiveCount;
	}

	@Column(name = "CountDate", nullable = false, length = 19)
	public Timestamp getCountDate() {
		return this.countDate;
	}

	public void setCountDate(Timestamp countDate) {
		this.countDate = countDate;
	}

}