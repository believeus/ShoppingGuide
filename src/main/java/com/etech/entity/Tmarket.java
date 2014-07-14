package com.etech.entity;

import java.sql.Timestamp;

/**
 * Tmarket entity. @author MyEclipse Persistence Tools
 */

public class Tmarket implements java.io.Serializable {

	// Fields

	private Integer marketId;
	private Integer areaId;
	private String marketName;
	private String address;
	private Double latitude;
	private Double longitude;
	private Integer floorCount;
	private Timestamp openingTimeStart;
	private Timestamp openingTimeEnding;
	private String introduction;
	private String photoUrl;

	// Constructors

	/** default constructor */
	public Tmarket() {
	}

	/** minimal constructor */
	public Tmarket(Integer areaId, String marketName, Double latitude,
			Double longitude) {
		this.areaId = areaId;
		this.marketName = marketName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/** full constructor */
	public Tmarket(Integer areaId, String marketName, String address,
			Double latitude, Double longitude, Integer floorCount,
			Timestamp openingTimeStart, Timestamp openingTimeEnding,
			String introduction, String photoUrl) {
		this.areaId = areaId;
		this.marketName = marketName;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.floorCount = floorCount;
		this.openingTimeStart = openingTimeStart;
		this.openingTimeEnding = openingTimeEnding;
		this.introduction = introduction;
		this.photoUrl = photoUrl;
	}

	// Property accessors

	public Integer getMarketId() {
		return this.marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getFloorCount() {
		return this.floorCount;
	}

	public void setFloorCount(Integer floorCount) {
		this.floorCount = floorCount;
	}

	public Timestamp getOpeningTimeStart() {
		return this.openingTimeStart;
	}

	public void setOpeningTimeStart(Timestamp openingTimeStart) {
		this.openingTimeStart = openingTimeStart;
	}

	public Timestamp getOpeningTimeEnding() {
		return this.openingTimeEnding;
	}

	public void setOpeningTimeEnding(Timestamp openingTimeEnding) {
		this.openingTimeEnding = openingTimeEnding;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}